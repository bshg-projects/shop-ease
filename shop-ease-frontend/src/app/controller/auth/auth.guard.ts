import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {TokenService} from "src/app/controller/auth/services/token.service";

export const authGuard: CanActivateFn = (route, state) => {
  const rout = inject(Router)
  const tokenService = inject(TokenService);

  if (tokenService.isLoggedIn())
    return true
  else {
    rout.navigate(["login"]).then()
    return false
  }
};
