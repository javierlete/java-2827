import { Component } from '@angular/core';
import { LabelInputComponent, Opcion } from "../../biblioteca/label-input/label-input.component";
import { Producto } from '../../../modelos/producto';
import { ActivatedRoute } from '@angular/router';
import { PRODUCTOS } from '../../mocks/mock-productos';
import { CATEGORIAS } from '../../mocks/mock-categorias';
import { Categoria } from '../../../modelos/categoria';

@Component({
  selector: 'app-admin-detalle',
  imports: [LabelInputComponent],
  templateUrl: './admin-detalle.component.html',
  styleUrl: './admin-detalle.component.css'
})
export class AdminDetalleComponent {
  producto?: Producto;
  opciones!: Opcion[];

  constructor(private readonly route: ActivatedRoute) { }

  ngOnInit(): void {
    this.opciones = CATEGORIAS.map<Opcion>((c: Categoria) => ({ id: c.id, texto: c.nombre }));

    const id = Number(this.route.snapshot.paramMap.get('id'));

    if (id) {
      this.producto = PRODUCTOS.find(p => p.id === id) as Producto;
    }
  }
}
