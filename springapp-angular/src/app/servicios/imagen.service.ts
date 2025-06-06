import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { fill } from '@cloudinary/url-gen/actions/resize';
import { Cloudinary, CloudinaryImage } from '@cloudinary/url-gen/index';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ImagenService {
  img!: CloudinaryImage;

  cld = new Cloudinary({
    cloud: {
      cloudName: 'dsn31vddg'
    },
    url: {
      secure: true
    }
  });

  constructor(private readonly http: HttpClient) {

  }

  obtenerImagen(id: number, ancho: number, alto: number): Observable<CloudinaryImage> {
    console.log('Obteniendo imagen para ID:', id);
    
    const img = this.cld.image(id.toString());
    img.resize(fill().width(ancho).height(alto));
    return of(img);
  }

  subirImagen(id:number, file: File): Observable<any> {
    return new Observable<any>(observer => {
      const timestamp = Math.floor(Date.now() / 1000);
      const public_id = String(id);

      this.http.get<string>('http://localhost:8080/api/v2/cloudinary/firma?timestamp=' + timestamp + '&public_id=' + public_id).subscribe(
        firma => {
          console.log('Firma obtenida:', firma);

          const fd = new FormData();

          fd.append('file', file);
          fd.append('resource_type', 'image');
          fd.append('api_key', '783165747115854');
          
          fd.append('timestamp', timestamp.toString());
          fd.append('public_id', public_id);
          fd.append('upload_preset', 'springapp-seguro');

          fd.append('signature', firma);

          this.http.post<any>('https://api.cloudinary.com/v1_1/dsn31vddg/upload', fd).subscribe(
            res => {
              observer.next(res);
              observer.complete();
            },
            err => {
              observer.error(err);
            }
          );
        },
        error => {
          observer.error(error);
        }
      );
    });
  }
}
