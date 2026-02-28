import { Component, inject } from '@angular/core';
import { Router, RouterLink } from "@angular/router";
import { UserService } from '../../services/user.service';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from '../../model/user';
import { ParseSourceFile } from '@angular/compiler';

@Component({
  selector: 'app-login',
  imports: [RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
  private userService = inject(UserService);
  private router = inject(Router);
  
  protected loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')
  });


  onSubmit() {
    
    const request: User = {
      email: this.loginForm.value.email!,
      password: this.loginForm.value.password!,
      username: ""
    };

    this.userService.login(request).subscribe({
      next: res => {
        console.log("Logged in!");
        this.router.navigate(["/home"]);
        
      }
    });
  }

}
