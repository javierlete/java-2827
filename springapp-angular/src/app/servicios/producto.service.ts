import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Producto } from '../modelos/producto';
import { PRODUCTOS } from '../componentes/mocks/mock-productos';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  getAll(): Observable<Producto[]> {
    return of(PRODUCTOS);
  }

  getById(id: number): Observable<Producto | undefined> {
    const producto = PRODUCTOS.find(p => p.id === id);
    return of(producto);
  }
}
