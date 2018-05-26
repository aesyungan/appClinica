import { Component } from '@angular/core';
import { LoginService } from './_services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  constructor(public loginService: LoginService) {
    console.log('%c App Clinica', 'font-weight: bold; font-size: 40px;color: #FF0000; text-shadow: 3px 3px 0 #FA5858 , 6px 6px 0 #FBEFF2');
    console.log('%c¡DETENTE!', 'color: red; font-size: 30px; font-weight: bold;');
   
  }

}
