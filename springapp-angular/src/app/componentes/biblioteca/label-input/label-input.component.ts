import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-label-input',
  imports: [RouterLink],
  templateUrl: './label-input.component.html',
  styleUrl: './label-input.component.css'
})
export class LabelInputComponent {
  @Input() etiqueta?: string;
  @Input() tipo = 'text';
  @Input() error?: string;
  @Input() decimales?: number;
  @Input() tipoFichero?: string;
  @Input() enlace?: string;
}
