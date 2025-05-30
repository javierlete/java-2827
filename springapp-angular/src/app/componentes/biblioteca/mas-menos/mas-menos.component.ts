import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'jl-mas-menos',
  imports: [FormsModule],
  templateUrl: './mas-menos.component.html',
  styleUrl: './mas-menos.component.css'
})
export class MasMenosComponent {
  @Input('valorPorDefecto') cantidad: number = 1;
  @Input() min = 0;
  @Input() max = 99;
  @Input() ancho = 7;

  mas() {
    if (!this.max || this.cantidad < this.max) {
      this.cantidad++;
    }
  }

  menos() {
    if (this.cantidad > this.min) {
      this.cantidad--;
    }
  }
}
