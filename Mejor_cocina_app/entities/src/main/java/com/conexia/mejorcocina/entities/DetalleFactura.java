package com.conexia.mejorcocina.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleFactura implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DetalleFacturaId detalleFacturaId;
	@ManyToOne
	@JoinColumn(name = "IdCocinero")
	private Cocinero cocinero;
	@Column(name = "Importe")
	private Double importe;
	@Column(name = "Plato")
	private String plato;

	public DetalleFacturaId getDetalleFacturaId() {
		return detalleFacturaId;
	}

	public void setDetalleFacturaId(DetalleFacturaId detalleFacturaId) {
		this.detalleFacturaId = detalleFacturaId;
	}

	public Cocinero getCocinero() {
		return cocinero;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}
}
