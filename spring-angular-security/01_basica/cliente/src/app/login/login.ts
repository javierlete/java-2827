import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppService } from '../app.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  error = false;

  credentials = { username: '', password: '' };

  constructor(private readonly app: AppService, private readonly router: Router) {
  }

  login() {
    this.app.authenticate(this.credentials).subscribe(() => {
      this.router.navigateByUrl('/');
    });
    
    return false;
  }

}
