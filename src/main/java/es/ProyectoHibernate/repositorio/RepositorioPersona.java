package es.ProyectoHibernate.repositorio;

import org.hibernate.Session;

import es.ProyectoHibernate.modelo.Persona;
import es.ProyectoHibernate.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();
			
			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
	
	public static void modificarPersona(final Integer idPersona,final String nombre) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where PER_ID = :idPersona").
			setParameter("idPersona", idPersona).uniqueResult();
			personaBBDD.setNombre(nombre);
			
			
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
	
	public static void modificarPersona2(final Integer idPersona,final String apellidos) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.createQuery("Update Persona set per_ape = :apellidos where per_id = :identificador").
			setParameter("apellidos", apellidos).setParameter("identificador", idPersona).executeUpdate();

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
	
	public static void modificarPersona3(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.saveOrUpdate(persona);
			
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
	
	public static void eliminarPersona (final Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.createQuery("delete Persona where per_id= :idPersona ").setParameter("idPersona", idPersona).
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
