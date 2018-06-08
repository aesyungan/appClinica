package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IExamenDAO;
import com.ayungan.model.Examen;
import com.ayungan.service.IExamenService;
@Controller
public class ExamenServiceImpl implements IExamenService {
	@Autowired
	private IExamenDAO dao;

	@Override
	public Examen registrar(Examen item) {
		// TODO Auto-generated method stub
		return dao.save(item);
	}

	@Override
	public void modificar(Examen item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public Examen listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<Examen> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
