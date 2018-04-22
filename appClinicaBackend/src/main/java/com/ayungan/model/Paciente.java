package com.ayungan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private int idPaciente;
	@Column(name = "nombres", nullable = true, length = 255)
	private String nombres;
	@Column(name = "apellidos", nullable = true, length = 255)
	private String apellidos;
	@Column(name = "dni", nullable = true, length = 11)
	private String dni;
	@Column(name = "direccion", nullable = true, length = 255)
	private String direccion;
	@Column(name = "telefono", nullable = true, length = 255)
	private String telefono;
	@Column(name = "email", nullable = true, length = 255)
	private String email;

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Paciente(int idPaciente, String nombres, String apellidos, String dni, String direccion, String telefono,
			String email) {
		super();
		this.idPaciente = idPaciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public Paciente() {
		super();
	}

}
