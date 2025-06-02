import { Component } from '@angular/core';
import { BotonComponent } from "../../biblioteca/boton/boton.component";
import { PRODUCTOS } from '../../mocks/mock-productos';
import { Producto } from '../../../modelos/producto';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-admin-listado',
  imports: [BotonComponent, CurrencyPipe],
  templateUrl: './admin-listado.component.html',
  styleUrl: './admin-listado.component.css'
})
export class AdminListadoComponent {
  productos: Producto[] = PRODUCTOS;
}
