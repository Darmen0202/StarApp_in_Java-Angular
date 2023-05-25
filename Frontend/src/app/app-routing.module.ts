import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AuthComponent} from "./components/auth/auth.component";
import {RegisterComponent} from "./components/register/register.component";
import {AuthGuard} from "./auth.guard";
import {AppComponent} from "./app.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent , canActivate: [AuthGuard] },
  { path: 'login', component: AuthComponent },
  { path: 'registration', component: RegisterComponent},
  { path: '', component: AppComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
