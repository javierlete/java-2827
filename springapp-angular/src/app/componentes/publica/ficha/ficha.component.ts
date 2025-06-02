import { Component, Input } from '@angular/core';
import { Producto } from '../../../modelos/producto';
import { BotonComponent } from "../../biblioteca/boton/boton.component";
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-ficha',
  imports: [BotonComponent, CurrencyPipe],
  templateUrl: './ficha.component.html',
  styleUrl: './ficha.component.css'
})
export class FichaComponent {
  @Input() horizontal = false;

  @Input() producto: Producto = {
    id: 5,
    nombre: 'Producto de prueba',
    precio: 1234.56,
    descripcion: 'Descripción de prueba',
    categoria: {
      id: 2,
      nombre: 'Categoría de prueba',
      descripcion: 'Descripción de la categoría'
    }
  };
}
