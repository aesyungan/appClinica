package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Paciente;

public interface IPacienteService {

	Paciente registrar(Paciente paciente);

	void modificar(Paciente paciente);

	void eliminar(int idPaciente);

	Paciente listarId(int idPaciente);

	List<Paciente> listar();

}
