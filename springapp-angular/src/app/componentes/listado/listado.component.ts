import { Component } from '@angular/core';
import { FichaComponent } from "../ficha/ficha.component";
import { CommonModule, NgForOf } from '@angular/common';

@Component({
  selector: 'app-listado',
  imports: [FichaComponent, CommonModule],
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {

}
