import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private http = inject(HttpClient);
  private api = "http://localhost:8081/"

  constructor() { }

  register(registerData: User) {
    this.http.post(this.api, registerData);
  }

  login() {
    
  }
}
