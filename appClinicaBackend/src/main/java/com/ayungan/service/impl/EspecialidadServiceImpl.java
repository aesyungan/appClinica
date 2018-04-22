package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IEspecialidadDAO;
import com.ayungan.model.Especialidad;
import com.ayungan.service.IEspecialidadService;
@Controller
public class EspecialidadServiceImpl implements IEspecialidadService {
	@Autowired
	private IEspecialidadDAO dao;

	@Override
	public Especialidad registrar(Especialidad item) {
		// TODO Auto-generated method stub
		return dao.save(item);
	}

	@Override
	public void modificar(Especialidad item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public Especialidad listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<Especialidad> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
