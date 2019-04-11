package com.conexia.mejorcocina.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.conexia.mejorcocina.common.Constantes;
import com.conexia.mejorcocina.dto.CamareroDTO;
import com.conexia.mejorcocina.dto.ClienteDTO;
import com.conexia.mejorcocina.ejb.interfaces.IFacturaServicesLocal;
import com.conexia.mejorcocina.entities.DetalleFactura;
import com.conexia.mejorcocina.entities.DetalleFacturaId;
import com.conexia.mejorcocina.entities.Factura;

@Stateless
public class FacturaServicesEJB implements IFacturaServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public void crearFactura(Factura factura, List<DetalleFactura> detalles) {
		entityManager.persist(factura);
		Long l = 1l;
		for (DetalleFactura detalleFactura : detalles) {
			DetalleFacturaId detalleFacturaId = new DetalleFacturaId();
			detalleFacturaId.setFactura(factura);
			detalleFacturaId.setIdDetalleFactura(l);
			detalleFactura.setDetalleFacturaId(detalleFacturaId);
			entityManager.persist(detalleFactura);
			l++;
		}
	}

	public List<ClienteDTO> facturadoMasCienMil() {
		String queryString = Constantes.CLIENTES_REPORT_QUERY;
		Query query = entityManager.createNativeQuery(queryString);
		List<ClienteDTO> result = new ArrayList<ClienteDTO>();
		List list = query.getResultList();
		for (Object object : list) {
			Object[] row = (Object[]) object;
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setNombre(row[0] != null ? row[0].toString() : "");
			clienteDTO.setApellido1(row[1] != null ? row[1].toString() : "");
			clienteDTO.setApellido2(row[2] != null ? row[2].toString() : "");
			clienteDTO.setFacturado(row[3] != null ? (Double) row[3] : 0);
			result.add(clienteDTO);
		}
		return result;
	}

	public List<CamareroDTO> totalFacturadoCamareros() {
		String queryString = Constantes.CAMAREROS_REPORT_QUERY;
		Query query = entityManager.createNativeQuery(queryString);
		List<CamareroDTO> reporte = new ArrayList<CamareroDTO>();
		List result = query.getResultList();
		for (Object object : result) {
			Object[] list = (Object[]) object;
			CamareroDTO camareroDTO = new CamareroDTO();
			camareroDTO.setNombre(list[0] != null ? list[0].toString() : "");
			camareroDTO.setApellido1(list[1] != null ? list[1].toString() : "");
			camareroDTO.setApellido2(list[2] != null ? list[2].toString() : "");
			camareroDTO.setMes(list[3] != null ? list[3].toString() : "N/A");
			camareroDTO.setFacturado(list[4] != null ? (Double) list[4] : 0);
			reporte.add(camareroDTO);
		}
		return reporte;
	}

}
