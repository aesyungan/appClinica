package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Medico;


public interface IMedicoService {

	Medico registrar(Medico item);

	void modificar(Medico item);

	void eliminar(int idItem);

	Medico listarId(int idItem);

	List<Medico> listar();

}
