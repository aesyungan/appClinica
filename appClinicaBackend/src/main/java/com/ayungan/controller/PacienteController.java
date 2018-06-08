package com.ayungan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.ayungan.model.Paciente;
import com.ayungan.service.IPacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private IPacienteService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> item = new ArrayList<>();
		try {
			item = service.listar();
			//end añade 100 datos
		} catch (Exception e) {
			return new ResponseEntity<List<Paciente>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Paciente>>(item, HttpStatus.OK);
	}
	@GetMapping(value = "/listarPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Paciente>> listarPage(Pageable pageable) {
		System.out.println("pagination details->");
		System.out.println(pageable);
		Page<Paciente> item = null;
		try {
			item = service.listarAllByPage(pageable);
		} catch (Exception e) {
			return new ResponseEntity<Page<Paciente>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Paciente>>(item, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> listarId(@PathVariable("id") Integer id) {
		Paciente item = new Paciente();
		try {
			item = service.listarId(id);
		} catch (Exception e) {
			return new ResponseEntity<Paciente>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Paciente>(item, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Paciente paciente) {
		int respuesta = 0;
		Paciente item = new Paciente();
		try {
			item = service.registrar(paciente);
			if (item != null) {
				respuesta = 1;
			}
		} catch (Exception e) {
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Paciente paciente) {
		int resultado = 0;
		try {
			service.modificar(paciente);
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
