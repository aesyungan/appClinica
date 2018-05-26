package com.ayungan.service;

import java.util.List;

import com.ayungan.model.ConsultaExamen;;


public interface IConsultaExamenService {

	int registrar(ConsultaExamen item);

	void modificar(ConsultaExamen item);

	void eliminar(int idItem);

	ConsultaExamen listarId(int idItem);
	List<ConsultaExamen> listarExamenesPorConsulta(int idItem);

	List<ConsultaExamen> listar();

}
