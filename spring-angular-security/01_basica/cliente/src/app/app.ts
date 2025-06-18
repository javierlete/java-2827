import { Component } from '@angular/core';
import { AppService } from './app.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  imports: [RouterOutlet, RouterLink],
  styleUrl: './app.css'
})
export class App {

  constructor(private readonly app: AppService, private readonly router: Router) {
    this.app.authenticate({username: '', password: ''}).subscribe();
  }

  logout() {
    this.app.logout().subscribe(() => this.router.navigateByUrl('/login'));
  }
}
