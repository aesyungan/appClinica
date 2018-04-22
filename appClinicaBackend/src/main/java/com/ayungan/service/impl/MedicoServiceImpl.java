package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IMedicoDAO;
import com.ayungan.model.Medico;
import com.ayungan.service.IMedicoService;
@Controller
public class MedicoServiceImpl implements IMedicoService {
	@Autowired
	private IMedicoDAO dao;

	@Override
	public Medico registrar(Medico item) {
		// TODO Auto-generated method stub
		return dao.save(item);
	}

	@Override
	public void modificar(Medico item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public Medico listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<Medico> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
