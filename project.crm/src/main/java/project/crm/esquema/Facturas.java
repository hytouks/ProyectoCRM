package project.crm.esquema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facturas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFacturas;
	
	private int cliente_f;
	private String tipo;
	private double monto;
	
	public int getIdFacturas() {
		return idFacturas;
	}
	public void setIdFacturas(int idFacturas) {
		this.idFacturas = idFacturas;
	}
	public int getCliente_f() {
		return cliente_f;
	}
	public void setCliente_f(int cliente_f) {
		this.cliente_f = cliente_f;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
