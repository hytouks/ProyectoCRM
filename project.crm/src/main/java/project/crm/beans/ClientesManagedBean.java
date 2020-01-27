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

@ManagedBean
@SessionScoped
public class ClientesManagedBean {

	private Clientes cliente = new Clientes();
	private List<Clientes> clientes = new ArrayList<Clientes>();

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	public String mostrarClientes() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Query<Clientes> q = session.createQuery("FROM Clientes");
		clientes = q.list();

		session.close();
		return "Clientes";
	}

	public String home() {
		return "index";
	}

	public void registrarClientes() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		session.save(cliente);
		tx.commit();

		session.close();
	}


	public void actualizarClientes() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		String hql = "update clientes set idClientes = :id, razonSocial = :razonSocial, cuit = :cuit, direccion = :direccion where idClientes = :id";
		NativeQuery query = session.createSQLQuery(hql)
				.setParameter("id", this.cliente.getIdClientes())
				.setParameter("razonSocial", this.cliente.getRazonSocial())
				.setParameter("cuit", this.cliente.getCuit())
				.setParameter("direccion", this.cliente.getDireccion());
		query.executeUpdate();
		tx.commit();

		session.close();
	}

	public void eliminarClientes() {
		Session session = HibernateUtil.getInstance().getSeF().openSession();

		Transaction tx = session.beginTransaction();
		cliente = session.get(Clientes.class, cliente.getIdClientes());
		session.delete(cliente);
		tx.commit();

		session.close();
	}

}
