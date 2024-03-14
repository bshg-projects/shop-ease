import {HttpErrorResponse, HttpInterceptorFn} from '@angular/common/http';
import {catchError, throwError} from "rxjs";
import {inject} from "@angular/core";
import {Router} from "@angular/router";
import {TokenService} from "src/app/controller/auth/services/token.service";

export const interceptors: HttpInterceptorFn = (req, next) => {
  const tokenService = inject(TokenService);

  if (req.url.includes("login")) return next(req);

  const token = tokenService.getToken() as string;

  if (token != null) {
    let tokenizedReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    })
    return next(tokenizedReq);
  }

  return next(req);
};

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  let router = inject(Router)
  const tokenService = inject(TokenService);

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      if (router.url.startsWith("/dashboard")) {
        if (error.status === 404) {
          router.navigateByUrl('/not-found').then();
        } else if (error.status === 403) {
          router.navigateByUrl('/access-denied').then();
        } else if (error.status === 401) {
          tokenService.clearToken()
          router.navigateByUrl('/login').then();
        }
      }

      return throwError(() => error);
    })
  );
}
