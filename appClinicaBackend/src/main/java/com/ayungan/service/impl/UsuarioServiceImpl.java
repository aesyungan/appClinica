package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IUsuarioDAO;
import com.ayungan.model.Usuario;
import com.ayungan.service.IUsuarioService;
@Controller
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDAO dao;

	@Override
	public Usuario registrar(Usuario item) {
		// TODO Auto-generated method stub
		return dao.save(item);
	}

	@Override
	public void modificar(Usuario item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public Usuario listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
