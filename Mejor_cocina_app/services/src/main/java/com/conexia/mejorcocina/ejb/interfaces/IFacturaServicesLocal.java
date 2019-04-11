package com.conexia.mejorcocina.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.conexia.mejorcocina.dto.CamareroDTO;
import com.conexia.mejorcocina.dto.ClienteDTO;
import com.conexia.mejorcocina.entities.DetalleFactura;
import com.conexia.mejorcocina.entities.Factura;

@Local
public interface IFacturaServicesLocal {

	public void crearFactura(Factura factura, List<DetalleFactura> detalles);
	
	public List<CamareroDTO> totalFacturadoCamareros();
	
	public List<ClienteDTO> facturadoMasCienMil();
}
