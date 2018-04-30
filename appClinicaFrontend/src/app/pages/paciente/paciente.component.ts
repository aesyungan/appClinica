import { PacienteService } from './../../_services/paciente.service';

import { Paciente } from './../../_model/paciente';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css'],


})
export class PacienteComponent implements OnInit {
  lista: Paciente[] = [];
  displayedColumns = ['nombres', 'apellidos', 'dni', 'direccion', 'accion'];
  dataSource: MatTableDataSource<Paciente>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private _pacienteService: PacienteService) { }

  ngOnInit() {
    this._pacienteService.getListarPacietnes().subscribe(data => {
      this.lista = data;
      this.dataSource.data = this.lista;  
      this.dataSource.data = this.dataSource.data.slice();
    });
    this.dataSource = new MatTableDataSource(this.lista);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}
