import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private http = inject(HttpClient);
  private registerApi = "http://localhost:8081/register"
  private loginApi = "http://localhost:8081/login"

  constructor() { }

  register(registerData: User): Observable<any> {
    return this.http.post(this.registerApi, registerData);
  }

  login(loginData: User) {
    return this.http.post(this.loginApi, loginData);
  }
}
