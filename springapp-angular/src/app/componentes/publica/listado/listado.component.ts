import { Component } from '@angular/core';
import { FichaComponent } from "../ficha/ficha.component";
import { Producto } from '../../../modelos/producto';
import { ProductoService } from '../../../servicios/producto.service';

@Component({
  selector: 'app-listado',
  imports: [FichaComponent],
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {
  productos: Producto[] = [];

  constructor(private readonly productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.getAll().subscribe((productos: Producto[]) => {
      this.productos = productos;
    });
  }
}
