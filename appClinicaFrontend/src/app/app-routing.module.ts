import { PacienteEdicionComponent } from './pages/paciente/paciente-edicion/paciente-edicion.component';

import { PacienteComponent } from './pages/paciente/paciente.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'paciente', component: PacienteComponent, children:
      [
        { path: 'nuevo', component: PacienteEdicionComponent },
        { path: 'editar/:id', component: PacienteEdicionComponent },
      ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
