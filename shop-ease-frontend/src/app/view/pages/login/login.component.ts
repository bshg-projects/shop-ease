import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/controller/auth/services/auth.service';
import { TokenService } from 'src/app/controller/auth/services/token.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loading = false

  constructor(private userService: AuthService, private router: Router, private authService: TokenService) { }

  get login() {
    return this.userService.jwtRequest;
  }

  submit() {
    this.loading = true;
    this.userService.login().subscribe({
      next: data => {
        console.log(data)
        this.authService.setToken(data.accessToken)
        this.router.navigate(["dashboard"]).then()
        this.loading = false
      },
      error: err => {
        console.log(err)
        this.loading = false;
      }
    })
  }
}
