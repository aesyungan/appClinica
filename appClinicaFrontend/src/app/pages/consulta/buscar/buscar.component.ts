import { ConsultaService } from './../../../_services/consulta.service';
import { FiltroConsulta } from './../../../_model/filtroConsulta';

import { Consulta } from './../../../_model/consulta';
import { DialogoDetalleComponent } from './dialogo-detalle/dialogo-detalle.component';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog } from '@angular/material';


@Component({
  selector: 'app-buscar',
  templateUrl: './buscar.component.html',
  styleUrls: ['./buscar.component.css']
})
export class BuscarComponent implements OnInit {

  dataSource = new MatTableDataSource<Consulta>();
  form: FormGroup;
  displayedColumns = ['paciente', 'fecha', 'medico', 'especialidad', 'acciones'];
  //@ViewChild(MatPaginator) paginator: MatPaginator;
  //@ViewChild(MatSort) sort: MatSort;
  maxFecha: Date = new Date();

  constructor(private consultaService: ConsultaService, public dialog: MatDialog) {

    this.form = new FormGroup({
      'dni': new FormControl(''),
      'nombreCompleto': new FormControl(''),
      'fechaConsulta': new FormControl()
    });

    //this.dataSource.paginator = this.paginator;
    //this.dataSource.sort = this.sort;
  }

  ngOnInit() {

  }

  buscar() {
    let filtro = new FiltroConsulta(this.form.value['dni'], this.form.value['nombreCompleto'], this.form.value['fechaConsulta']);
    filtro.nombreCompleto = filtro.nombreCompleto.toLowerCase();
    
    if (filtro.fechaConsulta) {

      filtro.fechaConsulta.setHours(0);
      filtro.fechaConsulta.setMinutes(0);
      filtro.fechaConsulta.setSeconds(0);
      filtro.fechaConsulta.setMilliseconds(0);

      delete filtro.dni;
      delete filtro.nombreCompleto;

      this.consultaService.buscar(filtro).subscribe(data => {
        this.dataSource.data = data;
      });
    } else {
      delete filtro.fechaConsulta;
      if (filtro.dni.length == 0) {
        delete filtro.dni
      }
      if (filtro.nombreCompleto.length == 0) {
        delete filtro.nombreCompleto
      }

      this.consultaService.buscar(filtro).subscribe(data => {
        this.dataSource.data = data;

        //this.dataSource.paginator = this.paginator;
        //this.dataSource.sort = this.sort;
      });
    }
  }

  verDetalle(consulta: Consulta) {

    let dialogRef = this.dialog.open(DialogoDetalleComponent, {
      width: '100%',
      data: consulta
    });
  }

}

