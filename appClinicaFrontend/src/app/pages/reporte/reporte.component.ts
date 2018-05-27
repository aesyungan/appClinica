import { Component, OnInit } from '@angular/core';
import { ConsultaService } from '../../_services/consulta.service';
import { DomSanitizer } from '@angular/platform-browser';
import { Chart } from 'chart.js';
import { MatSnackBar } from '@angular/material';
@Component({
  selector: 'app-reporte',
  templateUrl: './reporte.component.html',
  styleUrls: ['./reporte.component.css']
})
export class ReporteComponent implements OnInit {

  chart: any;
  tipo: string;
  pdfSrc: string = '';
  selectedFiles: FileList;
  currentFileUpload: File;

  imagenData: any;
  imagenEstado: boolean = false;

  constructor( public snackBar: MatSnackBar,private consultaService: ConsultaService, private sanitization: DomSanitizer) { }

  ngOnInit() {
    this.tipo = "line";
    this.dibujar();
//LEE UNAIMAGEN CON ID 1 QUE ES UNA IMAGEN
    this.consultaService.leerArchivo().subscribe(data => {
      console.info(data);
      let x = this.convertir(data);
    });
  }
//convertit imagen
  convertir(data: any) {
    //transforma la data en una lectura de java script
    var reader = new FileReader();
    reader.readAsDataURL(data);    
    reader.onloadend = () => {
      let x = reader.result;      
      this.setear(x);
    }
  }

  setear(x: string) {
    //console.log(x);
    this.imagenData = this.sanitization.bypassSecurityTrustResourceUrl(x);
    this.imagenEstado = true;
  }
//end convertir imagen
  cambiar(tipo: string) {
    this.tipo = tipo;
    if (this.chart) {
      this.chart.destroy();
    }
    this.dibujar();
  }


  dibujar() {
    this.consultaService.listarResumen().subscribe(data => {
      console.log(data);
      let cantidad = data.map(res => res.cantidad);
      let cantidadN = data.map(res => res.cantidad + 1);
      let cantidadA = data.map(res => res.cantidad + 2);
      let fechas = data.map(res => res.fecha);
      console.log(cantidad);
      this.chart = new Chart('canvas', {
        type: this.tipo,
        data: {
          labels: fechas,
          datasets: [
            {
              label: 'Cantidad',
              data: cantidad,
              borderColor: "#3cba9f",
              fill: false,
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 0, 0.2)',
                'rgba(255, 159, 64, 0.2)'
              ],
            },
            {
              label: 'CantidadN',
              data: cantidadN,
              borderColor: "red",
              fill: false,
              backgroundColor: [
                'rgba(0, 99, 132, 0.2)',
                'rgba(54, 162, 0, 0.2)',
                'rgba(255, 0, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 0, 0, 0.2)',
                'rgba(255, 0, 64, 0.2)'
              ],
            },
            {
              label: 'CantidadA',
              data: cantidadA,
              borderColor: "blue",
              fill: false,
              backgroundColor: [
                'rgba(0, 99, 132, 0.2)',
                'rgba(54, 162, 0, 0.2)',
                'rgba(255, 0, 0, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 0, 0, 0.2)',
                'rgba(255, 0, 64, 0.2)'
              ],
            }
          ]
        },
        options: {
          legend: {
            display: false
          },
          scales: {
            xAxes: [{
              display: true
            }],
            yAxes: [{
              display: true
            }],
          }
        }
      });
    });
  }

  generarReporte(){
    this.consultaService.generarReporte().subscribe(data => {
      let reader = new FileReader();
      reader.onload = (e:any)=>{
        this.pdfSrc = e.target.result;
      }
      reader.readAsArrayBuffer(data);
    });
   
  }

  descargarReporte(){
    this.consultaService.generarReporte().subscribe(data => {
      const url = window.URL.createObjectURL(data);
      const a = document.createElement('a');
      a.setAttribute('style', 'display:none;');
      document.body.appendChild(a);
      a.href = url;
      a.download = 'archivo.pdf';
      a.click();
      return url;
    });
  }

  selectFile(event) {
    console.log(event.target.files);
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.currentFileUpload = this.selectedFiles.item(0)
    this.consultaService.guardarArchivo(this.currentFileUpload).subscribe(data => {
      console.log(data);
      let snackBarRef = this.snackBar.open("Correcto Upload", null, { duration: 2000 });
    });

    this.selectedFiles = undefined;
  }

  optenerArchivoPDF(){
     
    this.consultaService.leerArchivo().subscribe(data => {
      let reader = new FileReader();
      reader.onload = (e:any)=>{
        this.pdfSrc = e.target.result;
      }
      reader.readAsArrayBuffer(data);
    });
  }
}


