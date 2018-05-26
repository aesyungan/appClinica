package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Consulta;
import com.ayungan.util.ConsultaListaExamen;
import com.ayungan.util.ConsultaResumen;
import com.ayungan.util.FiltroConsulta;;


public interface IConsultaService {

	Consulta registrar(ConsultaListaExamen item);

	void modificar(Consulta item);

	void eliminar(int idItem);

	Consulta listarId(int idItem);

	List<Consulta> listar();
	List<Consulta> buscar(FiltroConsulta filtro);

	List<Consulta> buscarfecha(FiltroConsulta filtro);
	List<ConsultaResumen> listarResumen();
	byte[] generarReporte() throws Exception ;

}
