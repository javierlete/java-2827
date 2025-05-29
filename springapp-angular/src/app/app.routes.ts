import { Routes } from '@angular/router';
import { ListadoComponent } from './componentes/listado/listado.component';
import { DetalleComponent } from './componentes/detalle/detalle.component';
import { AdminListadoComponent } from './componentes/admin-listado/admin-listado.component';

export const routes: Routes = [
    { path: '', redirectTo: 'listado', pathMatch: 'full' },
    { path: 'listado', component: ListadoComponent },
    { path: 'detalle', component: DetalleComponent },
    { path: 'admin/listado', component: AdminListadoComponent },
];
