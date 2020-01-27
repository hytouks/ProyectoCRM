package project.crm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


import project.crm.esquema.Facturas;

@ManagedBean
@SessionScoped
public class FacturasManagedBean {

	private Facturas factura = new Facturas();		
	private List<Facturas> facturas = new ArrayList<Facturas>();

	public Facturas getFactura() {
		return factura;
	}

	public void setFactura(Facturas factura) {
		this.factura = factura;
	}

	public List<Facturas> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Facturas> facturas) {
		this.facturas = facturas;
	}

	public String mostrarFacturas() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();
		
		Query<Facturas> q = session.createQuery("FROM Facturas");
		facturas = q.list();
		
		session.close();
		return "Facturas";
	}
	
	public void registrarFacturas() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		session.save(factura);
		tx.commit();

		session.close();
	}


	public void actualizarFacturas() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		String hql = "update facturas set idFacturas = :id, cliente_f = :cliente, tipo = :tipo, monto = :monto where idFacturas = :id";
		NativeQuery query = session.createSQLQuery(hql)
				.setParameter("id", this.factura.getIdFacturas())
				.setParameter("cliente", this.factura.getCliente_f())
				.setParameter("tipo", this.factura.getTipo())
				.setParameter("monto", this.factura.getMonto());
		query.executeUpdate();
		tx.commit();

		session.close();
	}

	public void eliminarFacturas() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		factura = session.get(Facturas.class, factura.getIdFacturas());
		session.delete(factura);
		tx.commit();

		session.close();
	}
}
