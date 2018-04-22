package com.ayungan.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IConsultaDAO;
import com.ayungan.dao.IConsultaExamenDAO;
import com.ayungan.dao.IExamenDAO;
import com.ayungan.model.Consulta;
import com.ayungan.service.IConsultaService;
import com.ayungan.util.ConsultaListaExamen;;

@Controller
public class ConsultaServiceImpl implements IConsultaService {
	@Autowired
	private IConsultaDAO dao;
	@Autowired
	private IConsultaExamenDAO daoCExamen;

	@Override
	@Transactional
	public Consulta registrar(ConsultaListaExamen item) {
		Consulta c = new Consulta();
		try {
			// TODO Auto-generated method stub
			
			item.getConsulta().getDetalleConsulta().forEach(x -> {
				x.setConsulta(item.getConsulta());
			});// asignamos por que e pusimos json ignore y por lo cual no mateo
			c = dao.save(item.getConsulta());// se crea la consulta y luego se inserta
			int id =c.getIdConsulta();
			item.getExamens().forEach(x -> {	
				System.out.println("idconsulta:"+id+"idExamen:"+x.getIdExamen());
				daoCExamen.registrar(id, x.getIdExamen());
			});
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error->"+e.getMessage());
		}
		
		return c;
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
