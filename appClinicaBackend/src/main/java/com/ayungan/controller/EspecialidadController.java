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

import com.ayungan.model.Especialidad;
import com.ayungan.service.IEspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
	@Autowired
	private IEspecialidadService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Especialidad>> listar(){
		List<Especialidad> item = new ArrayList<>();
		try {
			item = service.listar();
		}catch(Exception e) {
			return new ResponseEntity<List<Especialidad>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Especialidad>>(item, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Especialidad> listarId(@PathVariable("id") Integer id){
		Especialidad item = new Especialidad();
		try {
			item = service.listarId(id);
		}catch(Exception e) {
			return new ResponseEntity<Especialidad>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Especialidad>(item, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Especialidad> registrar(@RequestBody Especialidad Especialidad) {
		Especialidad item = new Especialidad();
		try {
			item = service.registrar(Especialidad);			
		} catch (Exception e) {
			return new ResponseEntity<Especialidad>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Especialidad>(item, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Especialidad Especialidad) {
		int resultado = 0;
		try {
			service.modificar(Especialidad);
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
