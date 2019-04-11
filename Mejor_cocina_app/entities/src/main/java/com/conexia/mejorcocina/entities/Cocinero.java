package com.conexia.mejorcocina.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "Cocinero.GetAll",query = "select cocinero from Cocinero cocinero")})
public class Cocinero extends Persona{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "cocinero")
	private List<DetalleFactura> detallesFactura;

	public List<DetalleFactura> getDetallesFactura() {
		return detallesFactura;
	}

	public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}
}
