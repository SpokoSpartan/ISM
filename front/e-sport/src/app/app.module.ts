import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, Injectable, NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from "./components/navbar/navbar.component";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {ShowEventComponent} from "./components/show-event/show-event.component";
import {routes} from "./routes";
import {Router, RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {LoginComponent} from './components/login/login.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import {ChartsModule} from "ng2-charts";


@Injectable()
class UIErrorHandler extends ErrorHandler {
    constructor(private router: Router) {
        super();
    }
    handleError(error) {
        this.router.navigateByUrl("login");
    }
}


@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        HomepageComponent,
        ShowEventComponent,
        LoginComponent,
        StatisticsComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        RouterModule.forRoot(routes),
        HttpClientModule,
        ChartsModule
    ],
    providers: [
        UIErrorHandler,
        { provide: ErrorHandler, useClass: UIErrorHandler },
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
