package com.conexia.mejorcocina.dto;

public class CamareroDTO {

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String mes;

	private Double facturado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Double getFacturado() {
		return facturado;
	}

	public void setFacturado(Double facturado) {
		this.facturado = facturado;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre+" "+this.apellido1+" "+this.apellido2+"->"+this.mes+"->"+this.nombre;
	}
}
