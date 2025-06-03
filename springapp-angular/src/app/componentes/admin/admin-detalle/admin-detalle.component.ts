import { Component } from '@angular/core';
import { LabelInputComponent, Opcion } from "../../biblioteca/label-input/label-input.component";
import { Producto } from '../../../modelos/producto';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../../../modelos/categoria';
import { ProductoService } from '../../../servicios/producto.service';
import { CategoriaService } from '../../../servicios/categoria.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-detalle',
  imports: [LabelInputComponent],
  templateUrl: './admin-detalle.component.html',
  styleUrl: './admin-detalle.component.css'
})
export class AdminDetalleComponent {
  producto: Producto = {
    id: 0,
    nombre: '',
    precio: 0,
    descripcion: null,
    categoria: {
      id: 0,
      nombre: ''
    }
  };
  opciones!: Opcion[];

  constructor(private readonly route: ActivatedRoute, private readonly router: Router, private readonly productoService: ProductoService, private readonly categoriaService: CategoriaService) { }

  ngOnInit(): void {
    this.categoriaService.getAll().subscribe((categorias: Categoria[]) => {
      this.opciones = categorias.map<Opcion>((c: Categoria) => ({ id: c.id, texto: c.nombre }))
    });

    const id = Number(this.route.snapshot.paramMap.get('id'));

    if (id) {
      this.productoService.getById(id).subscribe((producto: Producto | undefined) => {
        if (producto) {
          this.producto = producto;
        } else {
          console.error(`Producto con ID ${id} no encontrado.`);
        }
      });
    }
  }

  guardar(): void {
    if (this.producto.id) {
      this.productoService.put(this.producto).subscribe(() => {
        this.router.navigate(['/admin/listado']);
      });
    } else {
      this.productoService.post(this.producto).subscribe(() => {
        this.router.navigate(['/admin/listado']);
      });
    }
  }
}
