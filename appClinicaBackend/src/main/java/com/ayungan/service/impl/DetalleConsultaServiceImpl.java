package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IDetalleConsultaDAO;
import com.ayungan.model.DetalleConsulta;
import com.ayungan.service.IDetalleConsultaService;
@Controller
public class DetalleConsultaServiceImpl implements IDetalleConsultaService {
	@Autowired
	private IDetalleConsultaDAO dao;

	@Override
	public DetalleConsulta registrar(DetalleConsulta item) {
		// TODO Auto-generated method stub
		return dao.save(item);
	}

	@Override
	public void modificar(DetalleConsulta item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public DetalleConsulta listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<DetalleConsulta> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
