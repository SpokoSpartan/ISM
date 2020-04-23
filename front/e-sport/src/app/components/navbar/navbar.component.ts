import { Component, OnInit } from '@angular/core';
import {LoginServiceService} from "../../services/login-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginService: LoginServiceService, private router: Router) { }

  username: string;
  userId: number;

  ngOnInit(): void {
    this.loginService.getUsername().subscribe(username => this.username = username);
    this.loginService.getuseId().subscribe(userId => {
      this.userId = userId;
    });
  }

  logout() {
    this.loginService.logout();
  }

  statisticsButtonClicked() {
    this.router.navigateByUrl('/stats');
  }

}
