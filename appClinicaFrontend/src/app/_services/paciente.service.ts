import { Paciente } from './../_model/paciente';
import { Injectable, Host } from '@angular/core';
import { HOST, TOKEN_NAME } from '../_shared/var.constant';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class PacienteService {
  url: string = `${HOST}/paciente`;
  pacienteCambio = new Subject<Paciente[]>();//programacion reactiva
  mensaje = new Subject<string>();
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
    let access_token = JSON.parse(sessionStorage.getItem(TOKEN_NAME)).access_token;//recupera solo el access token
    return this._http.get<Paciente[]>(`${this.url}/listar`,
    {//7envia token en el header
      headers: new HttpHeaders().set('Authorization', `bearer ${access_token}`).set('Content-Type', 'application/json')
    }
  );

  }
  public getPacientePorId(id: number) {
    let access_token = JSON.parse(sessionStorage.getItem(TOKEN_NAME)).access_token;//recupera solo el access token
    return this._http.get<Paciente>(`${this.url}/listar/${id}`,
      {//7envia token en el header
        headers: new HttpHeaders().set('Authorization', `bearer ${access_token}`).set('Content-Type', 'application/json')
      }
    );
  }
  public getListarPacietnesPage(numPage: number, size: number) {
    let access_token = JSON.parse(sessionStorage.getItem(TOKEN_NAME)).access_token;//recupera solo el access token
    return this._http.get<Paciente[]>(`${this.url}/listarPage?page=${numPage}&size=${size}&sort=idPaciente`, { headers: new HttpHeaders().set('Authorization', `bearer ${access_token}`).set('Content-Type', 'application/json') });
    //&sort=idPaciente ordena decendentemente
  }
  registrar(paciente: Paciente) {
    let access_token = JSON.parse(sessionStorage.getItem(TOKEN_NAME)).access_token;//recupera solo el access token
    return this._http.post(`${this.url}/registrar`, paciente,
      {
        headers: new HttpHeaders().set('Authorization', `bearer ${access_token}`).set('Content-Type', 'application/json')
      }
    );
  }

  modificar(paciente: Paciente) {
    let access_token = JSON.parse(sessionStorage.getItem(TOKEN_NAME)).access_token;//recupera solo el access token
    return this._http.put(`${this.url}/actualizar`, paciente,
      {
        headers: new HttpHeaders().set('Authorization', `bearer ${access_token}`).set('Content-Type', 'application/json')
      }
    );
  }

  eliminar(paciente: Paciente) {
    let access_token = JSON.parse(sessionStorage.getItem(TOKEN_NAME)).access_token;//recupera solo el access token
    return this._http.delete(`${this.url}/eliminar/${paciente.idPaciente}`,
      {
        headers: new HttpHeaders().set('Authorization', `bearer ${access_token}`).set('Content-Type', 'application/json')
      });
  }
}
