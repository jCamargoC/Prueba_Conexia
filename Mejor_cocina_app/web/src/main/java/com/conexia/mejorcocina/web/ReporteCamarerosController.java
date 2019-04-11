package com.conexia.mejorcocina.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.conexia.mejorcocina.dto.CamareroDTO;
import com.conexia.mejorcocina.ejb.interfaces.IFacturaServicesLocal;

@Named
@ViewScoped 
public class ReporteCamarerosController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IFacturaServicesLocal facturaServices;

	private List<CamareroDTO> reporte;

	@PostConstruct
	public void postConstruct() {
		reporte = facturaServices.totalFacturadoCamareros();
	}

	public List<CamareroDTO> getReporte() {
		return reporte;
	}

	public void setReporte(List<CamareroDTO> reporte) {
		this.reporte = reporte;
	}

}
