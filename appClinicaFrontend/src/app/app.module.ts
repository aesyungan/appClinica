import { ConsultaService } from './_services/consulta.service';
import { ConsultaComponent } from './pages/consulta/consulta.component';
import { ExamenService } from './_services/examen.service';
import { LoginService } from './_services/login.service';
import { PacienteEdicionComponent } from './pages/paciente/paciente-edicion/paciente-edicion.component';
import { PacienteService } from './_services/paciente.service';
import { MaterialModule } from './material/material.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { PacienteComponent } from './pages/paciente/paciente.component';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { EspecialidadComponent } from './pages/especialidad/especialidad.component';
import { EspecialidadService } from './_services/especialidad.service';
import { MedicoService } from './_services/medico.service';
import { EspecialidadEdicionComponent } from './pages/especialidad/especialidad-edicion/especialidad-edicion.component';
import { ExamenEdicionComponent } from './pages/examen/examen-edicion/examen-edicion.component';
import { ExamenComponent } from './pages/examen/examen.component';
import { MedicoComponent } from './pages/medico/medico.component';
import { DialogoComponent } from './pages/medico/dialogo/dialogo.component';
import { BuscarComponent } from './pages/consulta/buscar/buscar.component';
import { EspecialComponent } from './pages/consulta/especial/especial.component';
import { DialogoDetalleComponent } from './pages/consulta/buscar/dialogo-detalle/dialogo-detalle.component';
import { Not403Component } from './pages/not403/not403.component';
import { MAT_DATE_LOCALE } from '@angular/material';
import { GuardService } from './_services/guard.service';



@NgModule({
  declarations: [
    AppComponent,
    PacienteComponent,
    PacienteEdicionComponent,
    LoginComponent,
    EspecialidadComponent,
    EspecialidadEdicionComponent,
    ExamenComponent,
    ExamenEdicionComponent,
    MedicoComponent,
    DialogoComponent,
    ConsultaComponent,
    BuscarComponent,
    DialogoDetalleComponent,
    EspecialComponent,
    Not403Component
  ],
  entryComponents: [DialogoComponent, DialogoDetalleComponent],//mostrar dialogo
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [PacienteService, LoginService, MedicoService, ExamenService, EspecialidadService, ConsultaService, GuardService,
    { provide: MAT_DATE_LOCALE, useValue: 'es-ES' },],
  bootstrap: [AppComponent]
})
export class AppModule { }
