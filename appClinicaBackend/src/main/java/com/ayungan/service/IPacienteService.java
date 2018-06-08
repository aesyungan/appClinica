package com.ayungan.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ayungan.model.Paciente;

public interface IPacienteService {

	Paciente registrar(Paciente paciente);

	void modificar(Paciente paciente);

	void eliminar(int idPaciente);

	Paciente listarId(int idPaciente);

	List<Paciente> listar();
	Page<Paciente> listarAllByPage(Pageable pageable);

}
