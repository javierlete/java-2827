import { inject } from '@angular/core';
import { ResolveFn } from '@angular/router';
import { AutenticacionService } from '../servicios/autenticacion.service';

export const logoutResolver: ResolveFn<string> = (route, state) => {
  const autenticacionService = inject(AutenticacionService);

  autenticacionService.logout();
  
  return "Se ha cerrado la sesión correctamente.";
};
