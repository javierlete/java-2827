import { Routes } from '@angular/router';
import { ListadoComponent } from './componentes/publica/listado/listado.component';
import { DetalleComponent } from './componentes/publica/detalle/detalle.component';
import { AdminListadoComponent } from './componentes/admin/admin-listado/admin-listado.component';
import { AdminDetalleComponent } from './componentes/admin/admin-detalle/admin-detalle.component';
import { LoginComponent } from './componentes/publica/login/login.component';
import { CarritoComponent } from './componentes/publica/carrito/carrito.component';

export const routes: Routes = [
    // Entrada inicial
    { path: '', redirectTo: 'listado', pathMatch: 'full' },
    
    // Login
    { path: 'login', component: LoginComponent },
    
    // Público
    { path: 'listado', component: ListadoComponent },
    { path: 'detalle/:id', component: DetalleComponent },
    { path: 'carrito', component: CarritoComponent },

    // Administración
    { path: 'admin/listado', component: AdminListadoComponent },
    { path: 'admin/detalle', component: AdminDetalleComponent },
];
