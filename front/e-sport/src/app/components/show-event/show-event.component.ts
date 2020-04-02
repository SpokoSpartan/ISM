import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {EventResponse} from "../../domains/EventResponse";
import {CommentResponse} from "../../domains/CommentResponse";
import {LoginServiceService} from "../../services/login-service.service";
import {API_URL} from "../../config";

@Component({
  selector: 'app-show-event',
  templateUrl: './show-event.component.html',
  styleUrls: ['./show-event.component.css']
})
export class ShowEventComponent implements OnInit {

  userId: number;

  constructor(private route: ActivatedRoute, private http: HttpClient, private loginService: LoginServiceService) {
    this.loginService.getuseId().subscribe(userId => this.userId = userId);
  }

  event: EventResponse;
  isEditingComment = false;
  editedComment = 0;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.initEvent(id).subscribe(x => this.event = x);
  }

  initEvent(id: string) {
    return this.http.get<EventResponse>(API_URL + '/event/get/{eventId}?eventId='+ id, {withCredentials: true});
  }

  addCommentPressed() {
    const comment = (<HTMLInputElement>document.getElementById('add-comment')).value;
    this.addComment(comment, this.event.id)
  }

  addComment(content: string, eventId: number) {
    if (this.isEditingComment == false) {
      if (content == null || content === '') {
        return;
      }
      this.http.post(API_URL + '/comment/create/{eventId}?content=' + content + '&eventId=' + eventId, null, {withCredentials: true})
          .subscribe(x => {
            const commentResponse = new CommentResponse(x as number, content, this.userId, new Date());
            this.event.comments.push(commentResponse);
          })
    } else {
      this.event.comments.forEach(comment => {
        if (comment.id === this.editedComment) {
          this.http.put(API_URL + '/comment/edit/{commentId}?commentId=' + this.editedComment + '&content=' + content, null, {withCredentials: true})
              .subscribe(x => comment.content = content);
        }
      });
    }
    this.isEditingComment = false;
    this.editedComment = 0;
    (<HTMLInputElement>document.getElementById('add-comment')).value = "";
  }

  removeComment(id: number) {
    let comments: Array<CommentResponse> = [];
    this.event.comments.forEach(comment => {
      if (comment.id === id) {
        this.http.delete(API_URL + '/comment/removeComment/{commentId}?commentId='+ id, {withCredentials: true})
            .toPromise().catch((error: HttpErrorResponse) => {
              comments.push(comment);
        });
      } else {
        comments.push(comment);
      }
    });
    this.event.comments = comments;
    this.isEditingComment = false;
    this.editedComment = 0;
    (<HTMLInputElement>document.getElementById('add-comment')).value = "";
  }

  editComment(commentId: number) {
    this.isEditingComment = true;
    this.editedComment = commentId;
    let editedContent = '';
    this.event.comments.forEach(comment => {
      if (comment.id === commentId) {
        editedContent = comment.content;
      }
    });
    (<HTMLInputElement>document.getElementById('add-comment')).value = editedContent;
  }

  cancelEditing() {
    this.isEditingComment = false;
    this.editedComment = 0;
  }

  isEditableToUser(comment: CommentResponse): boolean {
    return comment.ownerId === this.userId;
  }

  isRemovableToUser(comment: CommentResponse): boolean {
    console.log(comment.id);
    console.log(this.userId);
    return comment.ownerId === this.userId;
  }

}
