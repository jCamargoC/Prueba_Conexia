package com.conexia.mejorcocina.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "Camarero.GetAll",query = "select camarero from Camarero camarero")})
public class Camarero extends Persona{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "camarero")
	private List<Factura> facturas;

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
}
