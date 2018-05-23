import { GuardService } from './_services/guard.service';
import { LoginComponent } from './login/login.component';
import { PacienteEdicionComponent } from './pages/paciente/paciente-edicion/paciente-edicion.component';

import { PacienteComponent } from './pages/paciente/paciente.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EspecialidadComponent } from './pages/especialidad/especialidad.component';
import { EspecialidadEdicionComponent } from './pages/especialidad/especialidad-edicion/especialidad-edicion.component';
import { ExamenEdicionComponent } from './pages/examen/examen-edicion/examen-edicion.component';
import { ExamenComponent } from './pages/examen/examen.component';
import { Not403Component } from './pages/not403/not403.component';
import { ConsultaComponent } from './pages/consulta/consulta.component';
import { EspecialComponent } from './pages/consulta/especial/especial.component';
import { BuscarComponent } from './pages/consulta/buscar/buscar.component';
import { MedicoComponent } from './pages/medico/medico.component';


const routes: Routes = [
  { path: 'not-403', component: Not403Component },
  { path: 'consulta', component: ConsultaComponent, canActivate: [GuardService] },
  { path: 'consulta-especial', component: EspecialComponent, canActivate: [GuardService] },
  { path: 'buscar', component: BuscarComponent, canActivate: [GuardService] },
  { path: 'medico', component: MedicoComponent, canActivate: [GuardService] },
  {
      path: 'especialidad', component: EspecialidadComponent, children: [
          { path: 'nuevo', component: EspecialidadEdicionComponent },
          { path: 'edicion/:id', component: EspecialidadEdicionComponent }
      ], canActivate: [GuardService]
  },
  {
      path: 'examen', component: ExamenComponent, children: [
          { path: 'nuevo', component: ExamenEdicionComponent },
          { path: 'edicion/:id', component: ExamenEdicionComponent }
      ], canActivate: [GuardService]
  },
  {
      path: 'paciente', component: PacienteComponent, children: [
          { path: 'nuevo', component: PacienteEdicionComponent },
          { path: 'edicion/:id', component: PacienteEdicionComponent }
      ], canActivate: [GuardService]
  },
  //{ path: 'perfil', component: PerfilComponent, canActivate: [GuardService] },
  //{ path: 'reporte', component: ReporteComponent, canActivate: [GuardService] },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [GuardService]
})
export class AppRoutingModule { }
