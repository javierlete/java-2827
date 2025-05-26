import { Component } from '@angular/core';
import { TituloComponent } from "./titulo/titulo.component";

@Component({
  selector: 'app-root',
  imports: [TituloComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Componente de App';
}
