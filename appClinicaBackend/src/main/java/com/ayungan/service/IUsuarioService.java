package com.ayungan.service;

import java.util.List;

import com.ayungan.model.Usuario;

public interface IUsuarioService {

	Usuario registrar(Usuario item);

	void modificar(Usuario item);

	void eliminar(int idItem);

	Usuario listarId(int idItem);

	List<Usuario> listar();

}
