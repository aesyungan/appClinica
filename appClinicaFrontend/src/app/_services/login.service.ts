import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { HOST, TOKEN_AUTH_USERNAME, TOKEN_AUTH_PASSWORD, TOKEN_NAME } from './../_shared/var.constant';
import * as decode from 'jwt-decode';//decodifica el tokeen para q nos de nombre de usuario tiempo de vida etc 

@Injectable()
export class LoginService {

  private url: string = `${HOST}/oauth/token`;

  constructor(private http: HttpClient, private router: Router) {
  }

  login(usuario: string, contrasena: string) {
    //la contraseña de usuario 
    const body = `grant_type=password&username=${encodeURIComponent(usuario)}&password=${encodeURIComponent(contrasena)}`;

    return this.http.post(this.url, body, {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8').set('Authorization', 'Basic ' + btoa(TOKEN_AUTH_USERNAME + ':' + TOKEN_AUTH_PASSWORD))
    });
    //return true;
  }

  estaLogeado() {
    let token = sessionStorage.getItem(TOKEN_NAME);
    return token != null;
  }

  cerrarSesion() {
    sessionStorage.clear();
    this.router.navigate(['login']);
  }


}