import {Routes} from "@angular/router";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {ShowEventComponent} from "./components/show-event/show-event.component";
import {LoginComponent} from "./components/login/login.component";

export const routes: Routes = [
    { path: '', redirectTo: 'homepage', pathMatch: 'full' },
    { path: 'homepage', component: HomepageComponent },
    { path: 'show-event/:id', component: ShowEventComponent },
    { path: 'login', component: LoginComponent}
    ];