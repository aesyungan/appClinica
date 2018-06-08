package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Examen;



public interface IExamenService {

	Examen registrar(Examen item);

	void modificar(Examen item);

	void eliminar(int idItem);

	Examen listarId(int idItem);

	List<Examen> listar();

}
