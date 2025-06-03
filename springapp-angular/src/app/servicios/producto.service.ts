import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Producto } from '../modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  URL = 'http://localhost:3000/productos';

  constructor(private readonly http: HttpClient) { }

  getAll(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.URL);
  }

  getById(id: number): Observable<Producto | undefined> {
    return this.http.get<Producto>(this.URL + '/' + id);
  }
}
