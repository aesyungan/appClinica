import { TOKEN_NAME } from './../_shared/var.constant';
import { LoginService } from './../_services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario: string;
  contrasena: string;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  iniciarSesion() {
    this.loginService.login(this.usuario, this.contrasena).subscribe(data => {      
      
      if (data) {
        console.log(data);
        let token = JSON.stringify(data);
        sessionStorage.setItem(TOKEN_NAME, token);
        this.router.navigate(['paciente']);
      }
    });
  }

  cerrarSesion() {    
    sessionStorage.clear();
    this.router.navigate(['login']);
  }
}