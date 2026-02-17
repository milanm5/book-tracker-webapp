import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { UserService } from '../../services/user.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { User } from '../../model/user';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  private userService = inject(UserService);

  protected registerForm = new FormGroup({
    password: new FormControl(''),
    username: new FormControl(''),
    email: new FormControl('')
  })

  onSubmit() {

    const request: User = {
      password: this.registerForm.value.password!,
      username: this.registerForm.value.username!,
      email: this.registerForm.value.email!
    };

    this.userService.register(request);
  }
}
