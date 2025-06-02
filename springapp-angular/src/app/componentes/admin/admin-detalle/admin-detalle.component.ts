import { Component } from '@angular/core';
import { LabelInputComponent } from "../../biblioteca/label-input/label-input.component";
import { Producto } from '../../../modelos/producto';
import { ActivatedRoute } from '@angular/router';
import { PRODUCTOS } from '../../mocks/mock-productos';

@Component({
  selector: 'app-admin-detalle',
  imports: [LabelInputComponent],
  templateUrl: './admin-detalle.component.html',
  styleUrl: './admin-detalle.component.css'
})
export class AdminDetalleComponent {
  producto?: Producto;

  constructor(private readonly route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    if (id) {
      this.producto = PRODUCTOS.find(p => p.id === id) as Producto;
    }
  }
}
