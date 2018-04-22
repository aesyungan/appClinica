package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Consulta;;


public interface IConsultaService {

	Consulta registrar(Consulta item);

	void modificar(Consulta item);

	void eliminar(int idItem);

	Consulta listarId(int idItem);

	List<Consulta> listar();

}
