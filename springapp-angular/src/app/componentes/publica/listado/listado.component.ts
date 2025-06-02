import { Component } from '@angular/core';
import { FichaComponent } from "../ficha/ficha.component";
import { Producto } from '../../../modelos/producto';
import { PRODUCTOS } from '../../mocks/mock-productos';


@Component({
  selector: 'app-listado',
  imports: [FichaComponent],
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {
  productos: Producto[] = PRODUCTOS;
}
