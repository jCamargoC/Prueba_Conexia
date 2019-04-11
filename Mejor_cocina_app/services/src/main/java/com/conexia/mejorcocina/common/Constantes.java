package com.conexia.mejorcocina.common;

public class Constantes {

	public static final String GET_ALL_SUFFIX = "GetAll";
	public static final String GET_ONE_SUFFIX = "GetOne";
	public static final String CLIENTES_REPORT_QUERY = "select cam.nombre,cam.apellido1,cam.apellido2,sum(det.importe) as facturado from mejorcocina.cliente cam left join mejorcocina.factura fac on cam.id=fac.IdCliente left join mejorcocina.detallefactura det on fac.IdFactura=det.IdFactura group by cam.nombre,cam.apellido1,cam.apellido2 having sum(det.importe) >100000 order by cam.nombre,cam.apellido1,cam.apellido2;";
	public static final String CAMAREROS_REPORT_QUERY = "select cam.nombre,cam.apellido1,cam.apellido2,DATE_FORMAT(fac.FechaFactura,'%M/%Y') mes,sum(det.importe) facturado from mejorcocina.camarero cam left join mejorcocina.factura fac on cam.id=fac.IdCamarero left join mejorcocina.detallefactura det on fac.IdFactura=det.IdFactura group by cam.nombre,cam.apellido1,cam.apellido2,mes order by cam.nombre,cam.apellido1,cam.apellido2,mes;";
}
