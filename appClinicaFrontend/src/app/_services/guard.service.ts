import { LoginService } from './login.service';
import { TOKEN_NAME } from './../_shared/var.constant';
import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { tokenNotExpired } from 'angular2-jwt';

@Injectable()
export class GuardService implements CanActivate {

  constructor(private loginService: LoginService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let token = JSON.parse(sessionStorage.getItem(TOKEN_NAME));//recupera el toquen 
    if (token != null) {
      let access_token = token.access_token;

      let rpta = this.loginService.estaLogeado();
      if (!rpta) {
        sessionStorage.clear();
        this.router.navigate(['/login']);
        return false;
      } else {
        if (tokenNotExpired(TOKEN_NAME, access_token)) {
          return true;//si no expira
        } else {
          sessionStorage.clear();
          this.router.navigate(['/login']);
          return false;
        }
      }
    } else {
      sessionStorage.clear();
      this.router.navigate(['/login']);
      return false;
    }
  }

}
