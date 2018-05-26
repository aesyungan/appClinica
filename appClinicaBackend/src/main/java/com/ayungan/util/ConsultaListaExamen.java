package com.ayungan.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ayungan.model.Consulta;
import com.ayungan.model.Examen;
@Component
public class ConsultaListaExamen {

	private Consulta consulta;
	private List<Examen> lstExamen;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Examen> getExamens() {
		return lstExamen;
	}

	public void setExamens(List<Examen> examens) {
		this.lstExamen = examens;
	}

}
