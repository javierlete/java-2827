import { Routes } from '@angular/router';
import { ListadoComponent } from './componentes/listado/listado.component';

export const routes: Routes = [
    { path: '', redirectTo: 'listado', pathMatch: 'full' },
    { path: 'listado', component: ListadoComponent }
];
