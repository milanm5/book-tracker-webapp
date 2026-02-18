import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private http = inject(HttpClient);
  private api = "http://localhost:8081/register"

  constructor() { }

  register(registerData: User): Observable<any> {
    return this.http.post(this.api, registerData);
  }

  login() {
    
  }
}
