import { Routes } from '@angular/router';
import { SearchResultComponent } from './components/search-result/search-result.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    {path:"searchResult", component: SearchResultComponent},
    {path:"register", component: RegisterComponent},
    {path:"login", component: LoginComponent},
    {path:"home", component: HomeComponent}
];
