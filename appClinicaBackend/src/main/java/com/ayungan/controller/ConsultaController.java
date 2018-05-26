package com.ayungan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ayungan.model.Archivo;
import com.ayungan.model.Consulta;
import com.ayungan.service.IArchivoService;
import com.ayungan.service.IConsultaService;
import com.ayungan.util.ConsultaListaExamen;
import com.ayungan.util.ConsultaResumen;
import com.ayungan.util.FiltroConsulta;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	@Autowired
	private IConsultaService service;
	@Autowired
	private IArchivoService serviceArchivo;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consulta>> listar() {
		List<Consulta> item = new ArrayList<>();
		try {
			item = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Consulta>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Consulta>>(item, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consulta> listarId(@PathVariable("id") Integer id) {
		Consulta item = new Consulta();
		try {
			item = service.listarId(id);
		} catch (Exception e) {
			return new ResponseEntity<Consulta>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Consulta>(item, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consulta> registrar(@RequestBody ConsultaListaExamen Consulta) {
		Consulta item = new Consulta();
		try {
			item = service.registrar(Consulta);
		} catch (Exception e) {
			System.out.println("error->" + e.getMessage());
			return new ResponseEntity<Consulta>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Consulta>(item, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Consulta Consulta) {
		int resultado = 0;
		try {
			service.modificar(Consulta);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@PostMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consulta>> buscar(@RequestBody FiltroConsulta filtro) {
		List<Consulta> consultas = new ArrayList<>();

		if (filtro != null) {
			if (filtro.getFechaConsulta() != null) {
				System.out.println("buscando por fecha");
				consultas = service.buscarfecha(filtro);
			} else {
				consultas = service.buscar(filtro);
			}
			System.out.println(consultas.size());
			consultas.forEach(x -> {
				System.out.println(x.toString());
			});
		}

		return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/listarResumen", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConsultaResumen>> listarResumen() {
		List<ConsultaResumen> consultas = new ArrayList<>();
		try {
			consultas = service.listarResumen();
		} catch (Exception e) {
			return new ResponseEntity<List<ConsultaResumen>>(consultas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<ConsultaResumen>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		try {
			data = service.generarReporte();
		} catch (Exception e) {
			return new ResponseEntity<byte[]>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

	@PostMapping(value = "/guardarArchivo")
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("file") MultipartFile file) throws IOException {

		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setValue(file.getBytes());
		 rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {

		byte[] arr = null;
		arr=serviceArchivo.leerArchivo(idArchivo);

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}
}
