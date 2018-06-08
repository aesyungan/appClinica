package com.ayungan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examen")
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_examen")
	private int idExamen;
	@Column(name = "nombre", nullable = true, length = 255)
	private String nombre;
	@Column(name = "descripcion", nullable = true, length = 255)
	private String descripcion;
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Examen(int idExamen, String nombre, String descripcion) {
		super();
		this.idExamen = idExamen;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Examen() {
		super();
	}

}
