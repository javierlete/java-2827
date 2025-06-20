import { Component, OnInit } from '@angular/core';
import { LabelInputComponent } from "../../biblioteca/label-input/label-input.component";
import { AlertaComponent } from "../../biblioteca/alerta/alerta.component";
import { Login } from '../../../modelos/login';
import { AutenticacionService } from '../../../servicios/autenticacion.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Alerta } from '../../../modelos/alerta';

@Component({
  selector: 'app-login',
  imports: [LabelInputComponent, AlertaComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  login: Login = {
    email: 'javier@email.net',
    password: 'javier'
  };

  alerta?: Alerta;

  constructor(private readonly autenticacionService: AutenticacionService, private readonly router: Router, private readonly route: ActivatedRoute) { }

  ngOnInit(): void {
    // Si el resolver de logout ha devuelto un mensaje, lo mostramos
    const logoutMensaje = this.route.snapshot.data['logout'];
    if (logoutMensaje) {
      this.alerta = {
        mensaje: logoutMensaje,
        tipo: 'success'
      };
    }
  }

  autenticar() {
    console.log('Intentando autenticar con:', this.login);

    this.autenticacionService.autenticar(this.login).subscribe({
      next: (resultado) => {
        this.router.navigate(['/'])
      },
      error: (error) => {
        this.alerta = {
          mensaje: 'El usuario o la contraseña son incorrectos',
          tipo: 'danger'
        }
      }
    });
  }

}
