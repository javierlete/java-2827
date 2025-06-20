import { Routes } from '@angular/router';
import { AdminDetalleComponent } from './componentes/admin/admin-detalle/admin-detalle.component';
import { AdminListadoComponent } from './componentes/admin/admin-listado/admin-listado.component';
import { CarritoComponent } from './componentes/publica/carrito/carrito.component';
import { DetalleComponent } from './componentes/publica/detalle/detalle.component';
import { ListadoComponent } from './componentes/publica/listado/listado.component';
import { LoginComponent } from './componentes/publica/login/login.component';
import { adminGuard } from './guards/admin.guard';
import { logoutResolver } from './resolvers/logout.resolver';

export const routes: Routes = [
    // Entrada inicial
    { path: '', redirectTo: 'listado', pathMatch: 'full' },

    // Login
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LoginComponent, resolve: { logout: logoutResolver } },

    // Público
    { path: 'listado', component: ListadoComponent },
    { path: 'detalle/:id', component: DetalleComponent },
    { path: 'carrito', component: CarritoComponent },

    // Administración
    {
        path: 'admin', canActivateChild: [adminGuard], children: [
            { path: 'listado', component: AdminListadoComponent },
            { path: 'detalle', component: AdminDetalleComponent },
            { path: 'detalle/:id', component: AdminDetalleComponent },
        ]
    }
];
