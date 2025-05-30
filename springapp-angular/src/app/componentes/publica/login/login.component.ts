import { Component } from '@angular/core';
import { LabelInputComponent } from "../../biblioteca/label-input/label-input.component";
import { AlertaComponent } from "../../biblioteca/alerta/alerta.component";

@Component({
  selector: 'app-login',
  imports: [LabelInputComponent, AlertaComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

}
