package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Especialidad;


public interface IEspecialidadService {

	Especialidad registrar(Especialidad item);

	void modificar(Especialidad item);

	void eliminar(int idItem);

	Especialidad listarId(int idItem);

	List<Especialidad> listar();

}
