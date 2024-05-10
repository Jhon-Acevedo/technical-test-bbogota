import {Routes} from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {UserDetailsComponent} from "./pages/components/user-details/user-details.component";

export const routes: Routes = [

  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'user-details',
    component: UserDetailsComponent
  }

];
