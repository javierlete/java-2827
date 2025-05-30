import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { BotonComponent } from "../../biblioteca/boton/boton.component";

@Component({
  selector: 'app-admin-listado',
  imports: [RouterLink, BotonComponent],
  templateUrl: './admin-listado.component.html',
  styleUrl: './admin-listado.component.css'
})
export class AdminListadoComponent {

}
