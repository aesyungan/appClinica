package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Consulta;
import com.ayungan.util.ConsultaListaExamen;;


public interface IConsultaService {

	Consulta registrar(ConsultaListaExamen item);

	void modificar(Consulta item);

	void eliminar(int idItem);

	Consulta listarId(int idItem);

	List<Consulta> listar();

}
