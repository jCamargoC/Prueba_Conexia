package com.conexia.mejorcocina.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.conexia.mejorcocina.dto.ClienteDTO;
import com.conexia.mejorcocina.ejb.interfaces.IFacturaServicesLocal;

@Named
@ViewScoped
public class ReporteClientesController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IFacturaServicesLocal facturaServices;

	private List<ClienteDTO> reporte;

	@PostConstruct
	public void postConstruct() {
		reporte = facturaServices.facturadoMasCienMil();		
	}

	public List<ClienteDTO> getReporte() {
		return reporte;
	}

	public void setReporte(List<ClienteDTO> reporte) {
		this.reporte = reporte;
	}

}
