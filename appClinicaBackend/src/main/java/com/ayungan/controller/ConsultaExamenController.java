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

import com.ayungan.model.ConsultaExamen;
import com.ayungan.service.IConsultaExamenService;

@RestController
@RequestMapping("/consultaExamen")
public class ConsultaExamenController {
	@Autowired
	private IConsultaExamenService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConsultaExamen>> listar() {
		List<ConsultaExamen> item = new ArrayList<>();
		try {
			item = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<ConsultaExamen>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<ConsultaExamen>>(item, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConsultaExamen>> listarId(@PathVariable("id") Integer id) {
		List<ConsultaExamen> item = new ArrayList<>();
		System.out.println("Listando consulta examen");
		try {
			item = service.listarExamenesPorConsulta(id);
			System.out.println(item.toString());
		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
			return new ResponseEntity<List<ConsultaExamen>>(item, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<ConsultaExamen>>(item, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody ConsultaExamen ConsultaExamen) {

		int resultado = 0;
		try {
			resultado = service.registrar(ConsultaExamen);

		} catch (Exception e) {
			System.out.println("error->" + e.getMessage());
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody ConsultaExamen ConsultaExamen) {
		int resultado = 0;
		try {
			service.modificar(ConsultaExamen);
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
