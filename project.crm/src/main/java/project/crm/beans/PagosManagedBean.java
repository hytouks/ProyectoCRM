package project.crm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import project.crm.esquema.Clientes;
import project.crm.esquema.Facturas;
import project.crm.esquema.Pagos;

@ManagedBean
@SessionScoped
public class PagosManagedBean {
	private Pagos pago = new Pagos();		
	private List<Pagos> pagos = new ArrayList<Pagos>();
	
	public Pagos getPago() {
		return pago;
	}

	public void setPago(Pagos pago) {
		this.pago = pago;
	}

	public List<Pagos> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pagos> pagos) {
		this.pagos = pagos;
	}

	public String mostrarPagos() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();
		
		Query<Pagos> q = session.createQuery("FROM Pagos");
		pagos = q.list();
		
		session.close();
		return "Pagos";
	}
	
	public void registrarPagos() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		session.save(pago);
		tx.commit();

		session.close();
	}


	public void actualizarPagos() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		String hql = "update pagos set idPagos = :id, factura = :factura, cliente_p = :cliente, monto = :monto where idPagos = :id";
		NativeQuery query = session.createSQLQuery(hql)
				.setParameter("id", this.pago.getIdPagos())
				.setParameter("factura", this.pago.getFactura())
				.setParameter("cliente", this.pago.getCliente_p())
				.setParameter("monto", this.pago.getMonto());
		query.executeUpdate();
		tx.commit();

		session.close();
	}

	public void eliminarPagos() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		pago = session.get(Pagos.class, pago.getIdPagos());
		session.delete(pago);
		tx.commit();

		session.close();
	}
}
