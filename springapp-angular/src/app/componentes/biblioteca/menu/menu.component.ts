import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'jl-menu',
  imports: [RouterLink],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  @Input() titulo: string = 'TITULO';
  @Input() expansion: 'sm'|'md'|'lg'|'xl'|'xxl' = 'lg';
  @Input() enlaces: Enlace[] = [];

  enlacesPosicion(posicion?: 'derecha') {
    if(!posicion) {
      return this.enlaces.filter(e => !e.posicion);
    } else {
      return this.enlaces.filter(e => e.posicion === posicion);
    }
  }
}

export interface Enlace {
  texto: string;
  link?: string;
  posicion?: 'derecha';

  subenlaces?: Enlace[];
}