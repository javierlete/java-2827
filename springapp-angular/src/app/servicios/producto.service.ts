import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Producto } from '../modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  URL = '/json/productos.json';

  constructor(private readonly http: HttpClient) { }

  getAll(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.URL);
  }

  getById(id: number): Observable<Producto | undefined> {
    return this.getAll().pipe(
      map((productos: Producto[]) => {
        const producto = productos.find(p => p.id === id);
        if (!producto) {
          console.error(`Producto con ID ${id} no encontrado.`);
        }
        return producto;
      })
    );
  }
}
