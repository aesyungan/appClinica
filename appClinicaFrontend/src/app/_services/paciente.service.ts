import { Paciente } from './../_model/paciente';
import { Injectable, Host } from '@angular/core';
import { HOST } from '../_shared/var.constant';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PacienteService {
  url: string = `${HOST}/paciente`;
  constructor(private _http: HttpClient) {

    /*
    let p = new Paciente();
    p.idPaciente = 1;
    p.nombres = "alex";
    p.apellidos = "yungan";
    p.dni = "0604950725";
    p.direccion = "Roma -viena";
    p.telefono = "0322121";
    p.email = "carlos@hotmail.es";
    this.pacientes.push(p);
    */
  }
  public getListarPacietnes() {
    return this._http.get<Paciente[]>(`${this.url}/listar`);
  }

}
