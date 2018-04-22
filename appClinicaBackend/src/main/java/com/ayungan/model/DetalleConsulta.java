package com.ayungan.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_consulta")
public class DetalleConsulta  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_detalle_consulta")
	private int idDetalleConsulta;

	@JsonIgnore()
	@ManyToOne()
	@JoinColumn(name = "id_consulta", nullable = false)
	//@JsonIgnoreProperties("detalleConsulta")//para q no haga recursivo
	private Consulta consulta;

	@Column(name = "diagnostico", nullable = false, length = 70)
	private String diagnostico;

	@Column(name = "tratamiento", nullable = false, length = 300)
	private String tratamiento;

	

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public int getIdDetalleConsulta() {
		return idDetalleConsulta;
	}

	public void setIdDetalleConsulta(int idDetalleConsulta) {
		this.idDetalleConsulta = idDetalleConsulta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
