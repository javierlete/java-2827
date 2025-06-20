import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AutenticacionService } from '../servicios/autenticacion.service';

export const adminGuard: CanActivateFn = (route, state) => {
  const autenticacionService = inject(AutenticacionService);
  const esAdmin = autenticacionService.getClaim('rol') === 'ADMINISTRADOR';

  if (!esAdmin) {
    autenticacionService.logout();
    
    inject(Router).navigate(['/login']);
  }

  return esAdmin;
};
