import { Component, Input } from '@angular/core';
import { BotonComponent } from "../boton/boton.component";

@Component({
  selector: 'jl-label-input',
  imports: [BotonComponent],
  templateUrl: './label-input.component.html',
  styleUrl: './label-input.component.css'
})
export class LabelInputComponent {
  @Input() valor: any;
  @Input() opciones?: Opcion[];
  @Input() etiqueta?: string;
  @Input() tipo = 'text';
  @Input() error?: string;
  @Input() decimales?: number;
  @Input() tipoFichero?: string;
  @Input() enlace?: string;
}

export interface Opcion {
  id: number;
  texto: string;
}