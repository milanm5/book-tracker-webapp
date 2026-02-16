import { Routes } from '@angular/router';
import { SearchResultComponent } from './components/search-result/search-result.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
    {path:"searchResult", component: SearchResultComponent},
    {path:"register", component: RegisterComponent},
    {path:"login", component: LoginComponent}
];
