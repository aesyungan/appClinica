package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IConsultaExamenDAO;
import com.ayungan.model.ConsultaExamen;
import com.ayungan.service.IConsultaExamenService;;
@Controller
public class ConsultaExamenServiceImpl implements IConsultaExamenService {
	@Autowired
	private IConsultaExamenDAO dao;

	@Override
	public int registrar(ConsultaExamen item) {
		// TODO Auto-generated method stub
	
		//return dao.save(item);
		return dao.registrar(item.getConsulta().getIdConsulta(), item.getExamen().getIdExamen());
	}

	@Override
	public void modificar(ConsultaExamen item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public ConsultaExamen listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<ConsultaExamen> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(int idItem) {
		// TODO Auto-generated method stub
		return dao.listarExamenesPorConsulta(idItem);
	}

}
