import { Injectable } from '@angular/core';
import { Login } from '../modelos/login';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  constructor(private readonly http: HttpClient) { }

  // Autentica al usuario y devuelve un token JWT
  autenticar(login: Login): Observable<string> {
    return this.http.post<string>('http://localhost:8080/api/v2/auth/login', login).pipe(
      tap(token => localStorage.setItem('token', token))
    );
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  usuarioAutenticado(): string | null {
    const token = localStorage.getItem('token');
    
    if (!token) {
      return null; // Si no hay token, no hay usuario autenticado
    }
    
    return JSON.parse(atob(token.split('.')[1])).sub;
  }

  autenticado(): boolean {
    const token = localStorage.getItem('token');
    return !!token; // Devuelve true si hay un token, false si no
  }

  rol(): string | null {
    return 'ADMINISTRADOR';
  }
}
