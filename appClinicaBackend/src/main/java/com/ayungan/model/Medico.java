package com.ayungan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private int idMedico;
	@Column(name = "nombres", nullable = true, length = 255)
	private String nombres;
	@Column(name = "apellidos", nullable = true, length = 255)
	private String apellidos;
	@Column(name = "cmp", nullable = true, length = 255)
	private String cmp;

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Medico(int idMedico, String nombres, String apellidos, String cmp) {
		super();
		this.idMedico = idMedico;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cmp = cmp;
	}

	public Medico() {
		super();
	}

}
