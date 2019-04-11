package com.conexia.mejorcocina.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.conexia.mejorcocina.ejb.interfaces.IFacturaServicesLocal;
import com.conexia.mejorcocina.ejb.interfaces.IObjectsServicesLocal;
import com.conexia.mejorcocina.entities.Camarero;
import com.conexia.mejorcocina.entities.Cliente;
import com.conexia.mejorcocina.entities.Cocinero;
import com.conexia.mejorcocina.entities.DetalleFactura;
import com.conexia.mejorcocina.entities.Factura;
import com.conexia.mejorcocina.entities.Mesa;

@Named
@ViewScoped
public class MainController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IObjectsServicesLocal objectServices;
	@Inject
	private IFacturaServicesLocal facturasServices;

	private List<Cliente> clientes;

	private List<Mesa> mesas;

	private List<Camarero> camareros;

	private List<Cocinero> cocineros;

	private Cliente clienteSeleccionado;
	private Mesa mesaSeleccionada;
	private Camarero camareroSeleccionado;
	private Cocinero cocineroSeleccionado;

	private List<DetalleFactura> detalles;

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	private Factura factura;

	private String plato;

	private Double importe;

	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}

	public Mesa getMesaSeleccionada() {
		return mesaSeleccionada;
	}

	public void setMesaSeleccionada(Mesa mesaSeleccionada) {
		this.mesaSeleccionada = mesaSeleccionada;
	}

	public Camarero getCamareroSeleccionado() {
		return camareroSeleccionado;
	}

	public void setCamareroSeleccionado(Camarero camareroSeleccionado) {
		this.camareroSeleccionado = camareroSeleccionado;
	}

	public Cocinero getCocineroSeleccionado() {
		return cocineroSeleccionado;
	}

	public void setCocineroSeleccionado(Cocinero cocineroSeleccionado) {
		this.cocineroSeleccionado = cocineroSeleccionado;
	}

	@PostConstruct
	public void postConstruct() {
		detalles = new ArrayList<DetalleFactura>();
		factura = new Factura();
		factura.setFechaFactura(new Date());
		clientes = objectServices.getAll(Cliente.class);
		mesas = objectServices.getAll(Mesa.class);
		camareros = objectServices.getAll(Camarero.class);
		cocineros = objectServices.getAll(Cocinero.class);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public List<Camarero> getCamareros() {
		return camareros;
	}

	public void setCamareros(List<Camarero> camareros) {
		this.camareros = camareros;
	}

	public List<Cocinero> getCocineros() {
		return cocineros;
	}

	public void setCocineros(List<Cocinero> cocineros) {
		this.cocineros = cocineros;
	}

	public IObjectsServicesLocal getObjectServices() {
		return objectServices;
	}

	public void setObjectServices(IObjectsServicesLocal objectServices) {
		this.objectServices = objectServices;
	}

	public IFacturaServicesLocal getFacturasServices() {
		return facturasServices;
	}

	public void setFacturasServices(IFacturaServicesLocal facturasServices) {
		this.facturasServices = facturasServices;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public void agregarDetalle() {
		DetalleFactura detalle = new DetalleFactura();
		FacesContext context = FacesContext.getCurrentInstance();
		if (cocineroSeleccionado == null) {

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Debe Seleccionar un cocinero para el detalle"));
			return;
		}
		if (importe == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El importe es obligatorio"));
			return;
		}
		if (plato == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El plato es obligatorio"));
			return;
		}
		detalle.setCocinero(cocineroSeleccionado);
		detalle.setPlato(plato);
		detalle.setImporte(importe);

		detalles.add(detalle);
		cocineroSeleccionado = null;
		plato = null;
		importe = null;

	}

	public String guardarFactura() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (clienteSeleccionado == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Debe Seleccionar un cliente para la factura"));
			return "";
		}
		if (mesaSeleccionada == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Debe Seleccionar una mesa para la factura"));
			return "";
		}
		if (camareroSeleccionado == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Debe Seleccionar un camarero para la factura"));
			return "";
		}

		factura.setCamarero(camareroSeleccionado);
		factura.setCliente(clienteSeleccionado);
		factura.setMesa(mesaSeleccionada);
		facturasServices.crearFactura(factura, detalles);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Factura creada correctamente"));
		factura = new Factura();
		factura.setFechaFactura(new Date());
		detalles = new ArrayList<DetalleFactura>();
		clienteSeleccionado = null;
		mesaSeleccionada = null;
		camareroSeleccionado = null;
		return "home";
	}
}
