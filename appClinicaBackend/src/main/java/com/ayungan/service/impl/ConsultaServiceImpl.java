package com.ayungan.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import com.ayungan.dao.IConsultaDAO;
import com.ayungan.dao.IConsultaExamenDAO;
import com.ayungan.model.Consulta;
import com.ayungan.service.IConsultaService;
import com.ayungan.util.ConsultaListaExamen;
import com.ayungan.util.ConsultaResumen;
import com.ayungan.util.FiltroConsulta;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	@Override
	public List<Consulta> buscar(FiltroConsulta filtro) {
		return  dao.buscar(filtro.getDni(), filtro.getNombreCompleto());
	}

	@Override
	public List<Consulta> buscarfecha(FiltroConsulta filtro) {
		LocalDateTime fechaSgte = filtro.getFechaConsulta().plusDays(1);
		System.out.println(fechaSgte.toString());
		return dao.buscarPorFecha(filtro.getFechaConsulta(), fechaSgte);
	}

	@Override
	public List<ConsultaResumen> listarResumen() {
		// TODO Auto-generated method stub
		List<ConsultaResumen> consulta = new ArrayList<>();
		dao.listarResumen(1).forEach( x -> {
			ConsultaResumen cr = new ConsultaResumen();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consulta.add(cr);
		});
		return consulta;
	
	}

	@Override
	public byte[] generarReporte() throws Exception {
		File file = new ClassPathResource("/reports/consultas.jasper").getFile();

		JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
		return JasperExportManager.exportReportToPdf(print);	
	}

}
