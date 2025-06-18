import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  public authenticated = false;
  private readonly url = 'http://localhost:8080';
  private credentials: any = { username: '', password: '' };

  constructor(private readonly http: HttpClient) {}
  
  cabeceras() {
    console.log('credentials', this.credentials);

    return new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this.credentials.username + ':' + this.credentials.password),
      'X-Requested-With': 'XMLHttpRequest'
    });
  }
  
  getGreeting(): Observable<any> {
    return this.http.get(this.url + '/resource', { headers: this.cabeceras() });
  }

  authenticate(credentials: any): Observable<any> {
    this.credentials = credentials;

    return this.http.get(this.url + '/user', { headers: this.cabeceras() }).pipe(
      tap((response: any) => {
        if (response['name']) {
          this.authenticated = true;
        } else {
          this.authenticated = false;
        }
      })
    );
  }

  logout(): Observable<any> {
    return this.http.post(this.url + '/logout', {}).pipe(
      tap(() => { this.authenticated = false })
    );
  }
}
