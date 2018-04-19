package es.ProyectoHibernate.repositorio;

import org.hibernate.Session;

import es.ProyectoHibernate.util.HibernateUtil;

public class RepositorioUsuario {
	public static void eliminarUsuario (final Integer idUsuario) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.getTransaction().begin();

			sesion.createQuery("delete Usuario where usu_id = :idUsuario ").setParameter("idUsuario", idUsuario).
			executeUpdate();
			
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
}
