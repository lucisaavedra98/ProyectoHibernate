package es.ProyectoHibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.ProyectoHibernate.modelo.EstadoCivil;
import es.ProyectoHibernate.modelo.Cliente;
import es.ProyectoHibernate.util.HibernateUtil;

public class RepositorioCliente extends RepositorioUsuario {
	public static Integer crearCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final Integer idPersona = (Integer) sesion.save(cliente);

			sesion.getTransaction().commit();
			
			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el cliente "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}	

	public static void modificarCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.saveOrUpdate(cliente);
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error modificando el cliente"+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			sesion.close();
		}
	}
	
	public static List<Cliente> consultar (String nombre,String apellidos,String dni,EstadoCivil estadoCivil,String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			final StringBuilder sb = new StringBuilder("from Cliente where 1=1 ");
			
			if (nombre!= null && !nombre.isEmpty()) { 
				sb.append(" and CLI_NOM like :nombre ");
			}
			if (apellidos!=null && !apellidos.isEmpty()) {
				sb.append(" and CLI_APE LIKE :apellidos ");
			}
			if (dni!=null && !dni.isEmpty()) {
				sb.append(" and CLI_DNI = :dni ");
			}
			if (estadoCivil != null) {
				sb.append(" and CLI_ECV = :estadoCivil ");
			}
			if (login!= null && !login.isEmpty()) { 
				sb.append(" and USU_LOG = :login ");
			}
			
			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());
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
			if(login!= null && !login.isEmpty()) {
				consulta.setParameter("login", login);
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
