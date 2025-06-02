import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Categoria } from '../modelos/categoria';
import { CATEGORIAS } from '../componentes/mocks/mock-categorias';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  getAll(): Observable<Categoria[]> {
    return of(CATEGORIAS);
  }
}
