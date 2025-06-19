import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Enlace, MenuComponent } from "./componentes/biblioteca/menu/menu.component";
import '@angular/common/locales/global/es';
import { AutenticacionService } from './servicios/autenticacion.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MenuComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'springapp-angular';

  constructor(public readonly autenticacionService: AutenticacionService) { }

  enlaces(usuario: string | null, rol: string | null): Enlace[] {
    const menus: Enlace[] = [];

    menus.push({ texto: 'Principal', link: '/listado' });

    rol == 'ADMINISTRADOR' && menus.push({ texto: 'Admin Productos', link: '/admin/listado', posicion: 'derecha' });

    menus.push({ texto: usuario ?? 'No estás autenticado', posicion: 'derecha' });
    
    rol && menus.push({ texto: rol, posicion: 'derecha' });
    
    usuario ?? menus.push({ texto: 'Login', link: '/login', posicion: 'derecha' });
    usuario && menus.push({ texto: 'Cierre de sesión', link: '/logout', posicion: 'derecha' });

    return menus;
  }
}
