import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EventResponse} from "../../domains/EventResponse";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {LoginServiceService} from "../../services/login-service.service";
import {API_URL} from "../../config";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router, private loginService: LoginServiceService) {
  }

  events: Array<EventResponse> = [];
  userId: number;

  ngOnInit() : void {
    this.loginService.getuseId().subscribe(userId => {
      console.log(userId);
      this.userId = userId});
    this.getEventList()
        .subscribe(x => this.events = x);
  }

  getEventList(): Observable<any> {
    return this.http.get<EventResponse[]>(API_URL + '/event/get', {withCredentials: true});
  }

  viewButtonClicked(eventId: number) {
    this.router.navigateByUrl("show-event/" + eventId);
  }

}
