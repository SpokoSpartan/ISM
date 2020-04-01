import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {HttpClient, HttpErrorResponse, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserResponse} from "../domains/UserResponse";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private username: BehaviorSubject<any> = new BehaviorSubject([]);
  private userId: BehaviorSubject<any> = new BehaviorSubject([]);

  constructor(private http: HttpClient,
              private router: Router) {
    this.clearData();
    this.getPrincipalFromAPI();
  }

  getuseId() {
    return this.userId.asObservable();
  }

  getUsername() {
    return this.username.asObservable();
  }

  async loginUser(username: string, password: string) {
    let body = new HttpParams();
    body = body.set('username', username);
    body = body.set('password', password);
    let gaveCorrectData = true;
    await this.http.post<any>('http://localhost:8080/login', body, {withCredentials: true}).toPromise()
        .catch((response: HttpErrorResponse) => {
          if (response.status !== 200) {
            gaveCorrectData = false;
          }
        });
    if (gaveCorrectData) {
      await this.getPrincipalFromAPI().then(() => {
        this.router.navigateByUrl('homepage');
      });
    } else {
      this.userId.next(-1);
    }
  }

  async logout() {
    let gaveCorrectData = true;
    this.http.post('http://localhost:8080/logout',null, {withCredentials: true}).toPromise()
        .catch((error: HttpErrorResponse) => {
          gaveCorrectData = false;
          return;
        });
    if (gaveCorrectData) {
      this.getPrincipalFromAPI().then(() => this.router.navigateByUrl('login'))
    }
  }

  async getPrincipalFromAPI() {
    let isStatusOk = true;
    const response: any = await this.http.get<UserResponse>('http://localhost:8080/user/get', {withCredentials: true}).toPromise()
        .catch((e: HttpErrorResponse) => {
          isStatusOk = false;
          this.logoutUser();
        });
    const user: UserResponse = response;
    if (isStatusOk && user != null) {
      console.log("HJASFKEF");
      console.log('user '+ user.id);
      this.username.next(user.username);
      this.userId.next(user.id);
    } else {
      this.logoutUser();
    }
  }

  async logoutUser() {
    this.clearData();
    this.router.navigateByUrl('login');
  }

  clearData() {
    this.userId.next(0);
    this.username.next('Not logged in');
  }

}
