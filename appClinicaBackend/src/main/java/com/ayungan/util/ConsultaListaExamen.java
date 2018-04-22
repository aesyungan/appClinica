package com.ayungan.util;

import java.util.List;

import com.ayungan.model.Consulta;
import com.ayungan.model.Examen;

public class ConsultaListaExamen {

	private Consulta consulta;
	private List<Examen> examens;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

}
