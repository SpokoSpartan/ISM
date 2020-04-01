import {Component, OnInit} from '@angular/core';
import {LoginServiceService} from "../../services/login-service.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  gaveCorrectData = true;

  constructor(private loginService: LoginServiceService) {
    this.loginService.getuseId().subscribe(userId => userId == -1 ? this.gaveCorrectData = false : this.gaveCorrectData = true);
  }

  ngOnInit(): void {
  }

  login() {
    const username = (<HTMLInputElement>document.getElementById('inputUser')).value;
    const password = (<HTMLInputElement>document.getElementById('inputPassword')).value;
    this.loginService.loginUser(username, password);
  }

}
