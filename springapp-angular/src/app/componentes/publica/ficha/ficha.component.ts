import { Component, Input, OnInit } from '@angular/core';
import { Producto } from '../../../modelos/producto';
import { BotonComponent } from "../../biblioteca/boton/boton.component";
import { CurrencyPipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { ProductoService } from '../../../servicios/producto.service';
import { CloudinaryImage } from '@cloudinary/url-gen/index';
import { ImagenService } from '../../../servicios/imagen.service';
import { CloudinaryModule } from '@cloudinary/ng';

@Component({
  selector: 'app-ficha',
  imports: [BotonComponent, CurrencyPipe, CloudinaryModule],
  templateUrl: './ficha.component.html',
  styleUrl: './ficha.component.css'
})
export class FichaComponent implements OnInit {
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

  imagen!: CloudinaryImage;

  constructor(private readonly route: ActivatedRoute, private readonly productoService: ProductoService, private readonly imagenService: ImagenService) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    if (id) {
      this.imagenService.obtenerImagen(id, 400, 500).subscribe((img: CloudinaryImage) => {
        this.imagen = img;
      });
      
      this.productoService.getById(id).subscribe((producto: Producto | undefined) => {
        if (producto) {
          this.producto = producto;
        } else {
          console.error(`Producto con ID ${id} no encontrado.`);
        }
      });
    }
  }

  timestamp(): number {
    return Math.floor(Date.now() / 1000);
  }
}
