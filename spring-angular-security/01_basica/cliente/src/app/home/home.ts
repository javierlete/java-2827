import { Component } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  title = 'Demo';
  greeting: any = {};

  constructor(private readonly app: AppService) {
    this.app.getGreeting().subscribe(data => this.greeting = data);
  }

  authenticated() { return this.app.authenticated; }
}
