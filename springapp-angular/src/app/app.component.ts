import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Enlace, MenuComponent } from "./componentes/biblioteca/menu/menu.component";
import '@angular/common/locales/global/es';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MenuComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'springapp-angular';

  enlaces: Enlace[] = [
    { texto: 'Principal', link: '/listado' },
    { texto: 'Admin Productos', link: '/admin/listado', posicion: 'derecha' },
    { texto: 'No estás autenticado', posicion: 'derecha' },
    { texto: 'Usuario', posicion: 'derecha' },
    { texto: 'Roles', posicion: 'derecha' },
    { texto: 'Login', link: '/login', posicion: 'derecha' },
    { texto: 'Cierre de sesión', link: '/logout', posicion: 'derecha' },
    { texto: 'es', link: '/es', posicion: 'derecha' },
    { texto: 'en', link: '/en', posicion: 'derecha' },
  ]
}
