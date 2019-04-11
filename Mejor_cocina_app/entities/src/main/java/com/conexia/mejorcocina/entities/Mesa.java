package com.conexia.mejorcocina.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "Mesa.GetAll",query = "select mesa from Mesa mesa")})
public class Mesa implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdMesa")
	private Long id;
	@Column(name = "NumMaxComensales")
	private Integer numMaxComensales;
	@OneToMany(mappedBy = "mesa")
	private List<Factura> facturas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumMaxComensales() {
		return numMaxComensales;
	}

	public void setNumMaxComensales(Integer numMaxComensales) {
		this.numMaxComensales = numMaxComensales;
	}

}
