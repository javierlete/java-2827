import { Component } from '@angular/core';
import { AppService } from './app.service';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  imports: [RouterOutlet],
  styleUrl: './app.css'
})
export class App {
  protected title = 'Demo';
  protected greeting = { 'id': 'XXX', 'content': 'Hello World' };

  constructor(private readonly app: AppService) {
    this.app.getGreeting().subscribe({
      next: (data) => {
        this.greeting = data;
      },
      error: (err) => {
        console.error('Error fetching greeting:', err);
      }
    });
  }
}
