package com.ayungan.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Especialidad idEspecialidad;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    @ManyToOne
    private Medico idMedico;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private Paciente idPaciente;
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
	public Especialidad getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Especialidad idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public Medico getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}
	public Paciente getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Consulta(Integer idConsulta, LocalDateTime fecha, List<DetalleConsulta> detalleConsulta,
			Especialidad idEspecialidad, Medico idMedico, Paciente idPaciente) {
		super();
		this.idConsulta = idConsulta;
		this.fecha = fecha;
		this.detalleConsulta = detalleConsulta;
		this.idEspecialidad = idEspecialidad;
		this.idMedico = idMedico;
		this.idPaciente = idPaciente;
	}
	public Consulta() {
		super();
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }
    
	
	

}
