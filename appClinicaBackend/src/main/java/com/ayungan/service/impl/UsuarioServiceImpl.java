package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IUsuarioDAO;
import com.ayungan.model.Usuario;
import com.ayungan.service.IUsuarioService;
@Controller("userDetailsService")
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService {
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
//aqui es donde encuentra usuario por id 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return dao.findOneByUsername(username);
	}

}
