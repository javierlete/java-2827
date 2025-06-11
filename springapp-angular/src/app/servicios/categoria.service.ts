import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../modelos/categoria';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  URL = 'https://docker-springapp.onrender.com/api/v2/categorias';

  constructor(private readonly http: HttpClient) { }

  getAll(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.URL);
  }
}
