import { Component } from '@angular/core';
import { LabelInputComponent } from "../../biblioteca/label-input/label-input.component";
import { AlertaComponent } from "../../biblioteca/alerta/alerta.component";
import { Login } from '../../../modelos/login';
import { AutenticacionService } from '../../../servicios/autenticacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [LabelInputComponent, AlertaComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  login: Login = {
    email: 'javier@email.net',
    password: 'javier'
  };
  
  constructor(private readonly autenticacionService: AutenticacionService, private readonly router: Router) { }

  autenticar() {
    console.log('Intentando autenticar con:', this.login);

    this.autenticacionService.autenticar(this.login).subscribe(() => this.router.navigate(['/']));
  }

}
