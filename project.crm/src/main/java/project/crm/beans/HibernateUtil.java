package project.crm.beans;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	
	private SessionFactory sf;
	private static HibernateUtil instance;
	
	public HibernateUtil() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.buildMetadata();
		
		sf = metadata.buildSessionFactory();
	}
	
	public SessionFactory getSeF() {
		return sf;
	}
	
	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		
		return instance;
	}
	
	public void closeSeF() {
		instance.getSeF().close();
	}
}
