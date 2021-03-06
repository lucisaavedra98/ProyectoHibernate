package es.ProyectoHibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.ProyectoHibernate.modelo.EstadoCivil;
import es.ProyectoHibernate.modelo.Persona;
import es.ProyectoHibernate.modelo.Cliente;
import es.ProyectoHibernate.util.HibernateUtil;

public class RepositorioPersona extends RepositorioUsuario{

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

			sesion.createQuery("Update Persona set per_ape = :apellidos where usu_id = :identificador").
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
	
	public static void eliminarPersona (final Integer idUsuario) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Usuario Usu where Usu.idUsuario = :idUsuario ").setParameter("idUsuario", idUsuario).
			uniqueResult();
			
			sesion.delete(personaBBDD);
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error al eliminar el usuario "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
	
	public static Persona consultar (Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			Persona persona = (Persona) sesion.createQuery("from Usuario Usu where Usu.idUsuario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();
			persona.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getNumero()));
			
			return persona;

		} catch (Exception e) {
			System.out.println("Se ha producido un error al obtener registros "+e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
	
	public static List<Persona> consultar (String nombre,String apellidos,String dni,EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final StringBuilder sb = new StringBuilder("from Persona where 1=1 ");
			if (nombre!= null && !nombre.isEmpty()) { 
				sb.append(" and PER_NOM like :nombre ");
			}
			if (apellidos!=null && !apellidos.isEmpty()) {
				sb.append(" and PER_APE LIKE :apellidos ");
			}
			if (dni!=null && !dni.isEmpty()) {
				sb.append(" and PER_DNI = :dni ");
			}
			if (estadoCivil != null) {
				sb.append(" and PER_ECV = :estadoCivil ");
			}			
			
			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());
			if(nombre!= null && !nombre.isEmpty()) {
			consulta.setParameter("nombre", nombre);
			}
			if(apellidos!=null && !apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
				}
			if(dni!=null && !dni.isEmpty()) {
				consulta.setParameter("dni", dni);
				}
			if(estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
				}
			
			return consulta.list();

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
