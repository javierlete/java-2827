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

  subirImagen(file: File): Observable<any> {
    const fd = new FormData();

    fd.append('file', file);
    fd.append('upload_preset', 'springapp-seguro');
    fd.append('resource_type', 'image');

    return this.http.post<any>('https://api.cloudinary.com/v1_1/dsn31vddg/upload', fd);
  }
}
