import { PacienteService } from './../../_services/paciente.service';

import { Paciente } from './../../_model/paciente';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css'],


})
export class PacienteComponent implements OnInit {
  cantidad: number;
  lista: Paciente[] = [];
  displayedColumns = ['id', 'nombres', 'apellidos', 'dni', 'direccion', 'accion'];
  dataSource: MatTableDataSource<Paciente>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private _pacienteService: PacienteService, public snackBar: MatSnackBar) { }

  ngOnInit() {
    /* this._pacienteService.getListarPacietnes().subscribe(data => {
       this.lista = data;
       this.dataSource.data = this.lista;
       this.dataSource.data = this.dataSource.data.slice();
     });*/
    this.dataSource = new MatTableDataSource(this.lista);
    this.cargarDatos(0, 5);
    this._pacienteService.pacienteCambio.subscribe(data => {
      console.log("cargando in editing");
      console.log(data);
      this.lista = JSON.parse(JSON.stringify(data)).content;
      this.cantidad = JSON.parse(JSON.stringify(data)).totalElements;
      this.dataSource = new MatTableDataSource(this.lista);
    });
    this._pacienteService.mensaje.subscribe((data: string) => {
      let snackBarRef = this.snackBar.open(data, null, { duration: 2000 });
    });
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
  //mostrar mas
  mostrarMas(event: any) {
    console.log(event);
    this.cargarDatos(event.pageIndex, event.pageSize);

  }
  cargarDatos(page: number, size: number) {
    this._pacienteService.getListarPacietnesPage(page, size).subscribe(data => {
      console.log(data);
      this.lista = JSON.parse(JSON.stringify(data)).content;
      this.cantidad = JSON.parse(JSON.stringify(data)).totalElements;
      this.dataSource = new MatTableDataSource(this.lista);
      //this.dataSource.data = this.dataSource.data.slice();
    });
  }

  eliminar(item: Paciente) {
    this._pacienteService.eliminar(item).subscribe(data => {
    
      if (data === 1) {
        //elimina este item
        this.dataSource.data = this.dataSource.data.filter(i => i !== item);
        // this.dataSource.data.splice(1, 1);
        this.dataSource.data = this.dataSource.data.slice();
        this._pacienteService.mensaje.next("se elimino");

      } else {
        this._pacienteService.mensaje.next("No se elimino");
      }
    });
  }

}
