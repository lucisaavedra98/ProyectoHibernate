package es.ProyectoHibernate.pruebas;

import java.util.List;

import es.ProyectoHibernate.modelo.Aficion;
import es.ProyectoHibernate.repositorio.RepositorioAficion;

public class PruebasCache {

	public static void main(String[] args) {
		consultarAficiones();
		consultarAficiones();
	}

	private static void consultarAficiones() {
		final List<Aficion> aficiones = RepositorioAficion.consultarAficiones();
		
		aficiones.stream().map(Aficion::getNombre).forEach(System.out::println);
	}
}
