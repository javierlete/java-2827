import { Routes } from '@angular/router';
import { ListadoComponent } from './componentes/publica/listado/listado.component';
import { DetalleComponent } from './componentes/publica/detalle/detalle.component';
import { AdminListadoComponent } from './componentes/admin/admin-listado/admin-listado.component';
import { AdminDetalleComponent } from './componentes/admin/admin-detalle/admin-detalle.component';
import { LoginComponent } from './componentes/publica/login/login.component';

export const routes: Routes = [
    { path: '', redirectTo: 'listado', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'listado', component: ListadoComponent },
    { path: 'detalle', component: DetalleComponent },
    { path: 'admin/listado', component: AdminListadoComponent },
    { path: 'admin/detalle', component: AdminDetalleComponent },
];
