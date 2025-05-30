import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { BotonComponent } from "../../biblioteca/boton/boton.component";

@Component({
  selector: 'app-ficha',
  imports: [RouterLink, BotonComponent],
  templateUrl: './ficha.component.html',
  styleUrl: './ficha.component.css'
})
export class FichaComponent {
  @Input() horizontal = false;
}
