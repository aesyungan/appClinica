package com.ayungan.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ayungan.model.DetalleConsulta;
import com.ayungan.service.IDetalleConsultaService;

@RestController
@RequestMapping("/detalleConsulta")
public class DetalleConsultaController {
	@Autowired
	private IDetalleConsultaService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleConsulta>> listar(){
		List<DetalleConsulta> item = new ArrayList<>();
		try {
			item = service.listar();
		}catch(Exception e) {
			return new ResponseEntity<List<DetalleConsulta>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<DetalleConsulta>>(item, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetalleConsulta> listarId(@PathVariable("id") Integer id){
		DetalleConsulta item = new DetalleConsulta();
		try {
			item = service.listarId(id);
		}catch(Exception e) {
			return new ResponseEntity<DetalleConsulta>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<DetalleConsulta>(item, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetalleConsulta> registrar(@RequestBody DetalleConsulta DetalleConsulta) {
		DetalleConsulta item = new DetalleConsulta();
		try {
			item = service.registrar(DetalleConsulta);			
		} catch (Exception e) {
			return new ResponseEntity<DetalleConsulta>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<DetalleConsulta>(item, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody DetalleConsulta DetalleConsulta) {
		int resultado = 0;
		try {
			service.modificar(DetalleConsulta);
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
}
