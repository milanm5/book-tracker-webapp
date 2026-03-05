import { Routes } from '@angular/router';
import { SearchResultComponent } from './components/search-result/search-result.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    {path:"searchResult", component: SearchResultComponent, title:"Search"},
    {path:"register", component: RegisterComponent, title:"Register"},
    {path:"login", component: LoginComponent, title:"Login"},
    {path:"home", component: HomeComponent, title:"Home"}
];
