package es.ProyectoHibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.ProyectoHibernate.modelo.Aficion;
import es.ProyectoHibernate.modelo.EstadoCivil;
import es.ProyectoHibernate.modelo.Persona;
import es.ProyectoHibernate.util.HibernateUtil;

public class RepositorioAficion {
	public static List<Aficion> consultarAficiones () {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();
			
			return sesion.createQuery("from Aficion").setCacheable(true).list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error al obtener registros "+e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
}
