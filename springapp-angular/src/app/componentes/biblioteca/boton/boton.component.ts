import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'jl-boton',
  imports: [RouterLink],
  templateUrl: './boton.component.html',
  styleUrl: './boton.component.css'
})
export class BotonComponent {
  @Input() tipo = 'primary';
  @Input() tamano?: 'sm'|'lg';
  @Input() enlace?: string;
  @Input() etiqueta = 'BOTON';
}
