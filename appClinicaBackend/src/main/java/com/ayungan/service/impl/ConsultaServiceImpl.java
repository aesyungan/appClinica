package com.ayungan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IConsultaDAO;
import com.ayungan.model.Consulta;
import com.ayungan.service.IConsultaService;;
@Controller
public class ConsultaServiceImpl implements IConsultaService {
	@Autowired
	private IConsultaDAO dao;

	@Override
	public Consulta registrar(Consulta item) {
		// TODO Auto-generated method stub
		item.getDetalleConsulta().forEach(x ->{
			x.setConsulta(item);
		});
		return dao.save(item);
	}

	@Override
	public void modificar(Consulta item) {
		// TODO Auto-generated method stub
		dao.save(item);

	}

	@Override
	public void eliminar(int idItem) {
		dao.deleteById(idItem);
	}

	@Override
	public Consulta listarId(int idItem) {
		// TODO Auto-generated method stub
		return dao.findById(idItem).get();
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
