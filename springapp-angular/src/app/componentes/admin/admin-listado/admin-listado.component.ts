import { Component } from '@angular/core';
import { BotonComponent } from "../../biblioteca/boton/boton.component";
import { Producto } from '../../../modelos/producto';
import { CurrencyPipe } from '@angular/common';
import { ProductoService } from '../../../servicios/producto.service';

@Component({
  selector: 'app-admin-listado',
  imports: [BotonComponent, CurrencyPipe],
  templateUrl: './admin-listado.component.html',
  styleUrl: './admin-listado.component.css'
})
export class AdminListadoComponent {
  productos: Producto[] = [];

  constructor(private readonly productoService: ProductoService) { }
  
    ngOnInit(): void {
      this.productoService.getAll().subscribe((productos: Producto[]) => {
        this.productos = productos;
      });
    }

    borrar(id: number): void {
      this.productoService.delete(id).subscribe(() => {
        this.productos = this.productos.filter(producto => producto.id !== id);
      });
    }
}
