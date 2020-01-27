package project.crm.esquema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPagos;
	
	private int factura;
	private int cliente_p;
	private double monto;
	
	public int getIdPagos() {
		return idPagos;
	}
	public void setIdPagos(int idPagos) {
		this.idPagos = idPagos;
	}
	public int getFactura() {
		return factura;
	}
	public void setFactura(int factura) {
		this.factura = factura;
	}
	public int getCliente_p() {
		return cliente_p;
	}
	public void setCliente_p(int cliente_p) {
		this.cliente_p = cliente_p;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
