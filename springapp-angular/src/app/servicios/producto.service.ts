import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Producto } from '../modelos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  URL = 'https://json-server-eoy6.onrender.com/productos';

  constructor(private readonly http: HttpClient) { }

  getAll(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.URL);
  }

  getById(id: number): Observable<Producto | undefined> {
    return this.http.get<Producto>(this.URL + '/' + id);
  }

  post(producto: Producto): Observable<Producto> {
    return this.http.post<Producto>(this.URL, producto);
  }

  put(producto: Producto): Observable<Producto> {
    return this.http.put<Producto>(this.URL + '/' + producto.id, producto);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(this.URL + '/' + id);
  }
}
