package com.ayungan.service;

import java.util.List;

import com.ayungan.model.DetalleConsulta;


public interface IDetalleConsultaService {

	DetalleConsulta registrar(DetalleConsulta item);

	void modificar(DetalleConsulta item);

	void eliminar(int idItem);

	DetalleConsulta listarId(int idItem);

	List<DetalleConsulta> listar();

}
