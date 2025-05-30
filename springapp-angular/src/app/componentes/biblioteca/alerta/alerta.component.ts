import { Component, Input } from '@angular/core';

@Component({
  selector: 'jl-alerta',
  imports: [],
  templateUrl: './alerta.component.html',
  styleUrl: './alerta.component.css'
})
export class AlertaComponent {
  @Input() tipo = 'info';
  @Input() mensaje = 'MENSAJE';
}
