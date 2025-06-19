import { HttpInterceptorFn } from '@angular/common/http';

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {
  const token = localStorage.getItem('token');
  
  if (!token) {
    return next(req);
  }

  const conToken = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + localStorage.getItem('token'))
  });
  
  return next(conToken);
};
