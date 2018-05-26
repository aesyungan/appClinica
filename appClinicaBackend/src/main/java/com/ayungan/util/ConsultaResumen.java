package com.ayungan.util;

public class ConsultaResumen {

	private Integer cantidad;
	private String fecha;

	public ConsultaResumen() {

	}

	public ConsultaResumen(Integer cantidad, String fecha) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
