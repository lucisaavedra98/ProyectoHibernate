package es.ProyectoHibernate.pruebas;

import es.ProyectoHibernate.modelo.AtaquesPersonaje;
import es.ProyectoHibernate.modelo.EstadoCivil;
import es.ProyectoHibernate.modelo.Persona;
import es.ProyectoHibernate.modelo.Personaje;
import es.ProyectoHibernate.repositorio.RepositorioPersona;
import es.ProyectoHibernate.repositorio.RepositorioPersonaje;

public class Pruebas {

	public static void main(String[] args) {
		//System.out.println(crearPersona());
		//modificarPersona();
		//modificarPersona2();
		//modificarPersona3();
		//eliminarPersona();
		//System.out.println(crearPersonaje());
		//modificarPersonaje();
		eliminarPersonaje();
	}
	
	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Luciano");
		persona.setApellidos("Saavedra Conejo");
		persona.setEdad(19);
		persona.setDni("17481797A");
		persona.setEstadoCivil(EstadoCivil.SOLTERO);

		return RepositorioPersona.crearPersona(persona);
	}
	
	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Prueba");
	}
	
	private static void modificarPersona2() {
		RepositorioPersona.modificarPersona2(1, "Apellido prueba");
	}
	
	private static void modificarPersona3() {
		final Persona persona = new Persona();
		persona.setIdPersona(1);
		persona.setNombre("Luciano");
		persona.setApellidos("Saavedra Conejo");
		persona.setEdad(19);
		persona.setDni("17481797A");
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		
		RepositorioPersona.modificarPersona3(persona);
	}
	
	private static void eliminarPersona() {
		RepositorioPersona.eliminarPersona(9);
	}
	
	private static Integer crearPersonaje() {
		final Personaje personaje = new Personaje();
		personaje.setNombre("Ratchet");
		personaje.setAtributo("Roca");
		personaje.setPuntosSalud(2000);
		personaje.setPuntosExperiencia(5000);
		personaje.setAtaques(AtaquesPersonaje.MAGIA);

		return RepositorioPersonaje.crearPersonaje(personaje);
	}
	
	private static void modificarPersonaje() {
		final Personaje personaje = new Personaje();
		personaje.setIdPersonaje(2);
		personaje.setNombre("Ratchet");
		personaje.setAtributo("Roca");
		personaje.setPuntosSalud(1000);
		personaje.setPuntosExperiencia(5000);
		personaje.setAtaques(AtaquesPersonaje.MAGIA);
		
		RepositorioPersonaje.modificarPersonaje(personaje);
	}
	
	private static void eliminarPersonaje() {
		RepositorioPersonaje.eliminarPersonaje(2);
	}
}
