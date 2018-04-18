package es.ProyectoHibernate.repositorio;

import org.hibernate.Session;

import es.ProyectoHibernate.modelo.Persona;
import es.ProyectoHibernate.modelo.Personaje;
import es.ProyectoHibernate.util.HibernateUtil;

public class RepositorioPersonaje {
	public static Integer crearPersonaje(final Personaje personaje) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final Integer idPersonaje = (Integer) sesion.save(personaje);

			sesion.getTransaction().commit();
			
			return idPersonaje;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el personaje "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
	
	public static void modificarPersonaje(final Personaje personaje) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.saveOrUpdate(personaje);
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando el personaje"+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
	
	public static void eliminarPersonaje (final Integer idPersonaje) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.createQuery("delete Personaje where pej_id= :idPersonaje ").setParameter("idPersonaje", idPersonaje).
			executeUpdate();
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando la persona "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
}
