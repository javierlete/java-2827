import { Component } from '@angular/core';
import { FichaComponent } from "../ficha/ficha.component";
import { Producto } from '../../../modelos/producto';


@Component({
  selector: 'app-listado',
  imports: [FichaComponent],
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {
  productos: Producto[] = [
    { "id": 2, "nombre": "Portátil", "precio": 1234.00, "descripcion": "", 
      "categoria": { "id": 2, "nombre": "Informática", "descripcion": null }
    }, 
    { "id": 3, "nombre": "Nevera", "precio": 345.00, "descripcion": "", 
      "categoria": { "id": 3, "nombre": "Electrónica", "descripcion": null } 
    }
  ];
}
