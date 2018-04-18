package es.ProyectoHibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory miFactoria = construirSessionFactory();
	
	private static final SessionFactory construirSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Se ha obtenido un error obteniendo la factoria de sessiones: "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static SessionFactory getMiFactoria() {
		return miFactoria;
	}
}
