package com.ayungan.model;


import java.time.LocalDateTime;
import java.util.List;

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


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "consulta")
public class Consulta {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    
    @Column(name = "fecha")
	@JsonSerialize(using = ToStringSerializer.class) // para q tenga formato de mes año dia
	private LocalDateTime fecha;
    
  //consulta el compo como se llama al otro lado de la relacion

    @OneToMany(mappedBy = "consulta", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JsonIgnoreProperties("consulta")//para q no se haga recursivo 
    private List<DetalleConsulta> detalleConsulta;
    
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private Especialidad especialidad;
    
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    @ManyToOne
    private Medico medico;
    
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private Paciente paciente;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}

	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Consulta(Integer idConsulta, LocalDateTime fecha, List<DetalleConsulta> detalleConsulta,
			Especialidad especialidad, Medico medico, Paciente paciente) {
		super();
		this.idConsulta = idConsulta;
		this.fecha = fecha;
		this.detalleConsulta = detalleConsulta;
		this.especialidad = especialidad;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Consulta() {
		super();
	}

	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", fecha=" + fecha + ", detalleConsulta=" + detalleConsulta
				+ ", especialidad=" + especialidad + ", medico=" + medico + ", paciente=" + paciente + "]";
	}
    
    
    
	
	

}
