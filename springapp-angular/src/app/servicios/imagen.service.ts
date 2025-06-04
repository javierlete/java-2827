import { Injectable, Injector } from '@angular/core';
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
    }
  });

  constructor(private readonly injector: Injector) {

  }

  obtenerImagen(id: number, ancho: number, alto: number): Observable<CloudinaryImage> {
    console.log('Obteniendo imagen para ID:', id);
    
    const img = this.cld.image(id.toString());
    img.resize(fill().width(ancho).height(alto));
    return of(img);
  }
}
