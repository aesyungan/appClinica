import { GuardService } from './_services/guard.service';
import { LoginComponent } from './login/login.component';
import { PacienteEdicionComponent } from './pages/paciente/paciente-edicion/paciente-edicion.component';

import { PacienteComponent } from './pages/paciente/paciente.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'paciente',
    component: PacienteComponent,
    canActivate:[GuardService],
    children:
      [
        { path: 'nuevo', component: PacienteEdicionComponent },
        { path: 'editar/:id', component: PacienteEdicionComponent },
      ]
  },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [GuardService]
})
export class AppRoutingModule { }
