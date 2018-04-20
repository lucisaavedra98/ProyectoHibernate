package es.ProyectoHibernate.pruebas;

import java.util.Date;
import java.util.List;

import es.ProyectoHibernate.modelo.Aficion;
import es.ProyectoHibernate.modelo.AtaquesPersonaje;
import es.ProyectoHibernate.modelo.EstadoCivil;
import es.ProyectoHibernate.modelo.Genero;
import es.ProyectoHibernate.modelo.Persona;
import es.ProyectoHibernate.modelo.Cliente;
import es.ProyectoHibernate.modelo.DetallesPersona;
import es.ProyectoHibernate.modelo.Direccion;
import es.ProyectoHibernate.modelo.Personaje;
import es.ProyectoHibernate.modelo.Telefono;
import es.ProyectoHibernate.repositorio.RepositorioCliente;
import es.ProyectoHibernate.repositorio.RepositorioPersona;
import es.ProyectoHibernate.repositorio.RepositorioPersonaje;
import es.ProyectoHibernate.repositorio.RepositorioUsuario;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(crearPersona("17281797A","usuario"));
		//System.out.println(crearPersona("17381797B","usuario2"));
//		System.out.println(crearCliente("17281797A","usu"));
//		System.out.println(crearCliente("27281797B","usu2"));
		consultarPersona(1);
		//eliminar(1);
		//modificarPersona();
		//modificarPersona2();
		//modificarPersona3();
		//modificarCliente();
		//consultarPersona("Luciano","Saavedra Conejo","17481797A",EstadoCivil.SOLTERO);
		//System.out.println(crearPersonaje());
		//modificarPersonaje();
		//eliminarPersonaje();
	}
	
	private static Integer crearPersona(String dni,String login) {
		final Persona persona = new Persona();
		persona.setNombre("Luciano");
		persona.setApellidos("Saavedra Conejo");
		persona.setEdad(19);
		persona.setDni(dni);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setLogin(login);
		persona.setPassword("usuario");
		persona.setFechaAlta(new Date());
		persona.setGenero(Genero.MASCULINO);
		final Direccion direccion = new Direccion();
		direccion.setBloque(1);
		direccion.setCalle("San Pablo");
		direccion.setCodigoPostal("41569");
		direccion.setNumero(17);
		direccion.setPlanta(2);
		direccion.setProvincia("Sevilla");
		direccion.setPuerta("1");
		
		final Direccion direccion2 = new Direccion();
		direccion2.setBloque(2);
		direccion2.setCalle("Cristobal Colon");
		
		final Telefono telefono1 = new Telefono();
		telefono1.setNumero("658132265");
		
		final Telefono telefono2 = new Telefono();
		telefono2.setNumero("17218312");
		
		final DetallesPersona detalles= new DetallesPersona(true,true,true);
		
		persona.agregarDireccion(direccion);
		persona.agregarDireccion(direccion2);
		persona.agregarTelefono(telefono1);
		persona.agregarTelefono(telefono2);
		persona.agregarDetalles(detalles);
		
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
		persona.setIdUsuario(1);
		persona.setNombre("Luchiano");
		persona.setApellidos("Saavedra Conejo");
		persona.setEdad(19);
		persona.setDni("12345678D");
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setLogin("usuarioModificado");
		persona.setPassword("usuario");
		persona.setFechaAlta(new Date());
		
		RepositorioPersona.modificarPersona3(persona);
	}

	private static void eliminar(Integer idUsuario) {
		RepositorioPersona.eliminarPersona(idUsuario);
	}
	
	private static void consultarPersona(String nombre,String apellidos,String dni,EstadoCivil estadoCivil) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre,apellidos,dni,estadoCivil);
		System.out.println(personas.size());
	}
	
	private static void consultarPersona(Integer idPersona) {
		final Persona personaEncontrada = RepositorioPersona.consultar(idPersona);
		
		//personaEncontrada.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getNumero()));
	}
	
	private static Integer crearCliente(String dni, String login) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Luciano");
		cliente.setApellidos("Saavedra Conejo");
		cliente.setEdad(19);
		cliente.setDni(dni);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setLogin(login);
		cliente.setPassword("usuario2");
		cliente.setFechaAlta(new Date());

		return RepositorioCliente.crearCliente(cliente);
	}

	private static void modificarCliente() {
		final Cliente cliente = new Cliente();
		cliente.setIdUsuario(1);
		cliente.setNombre("Luciano");
		cliente.setApellidos("Saavedra Conejo");
		cliente.setEdad(19);
		cliente.setDni("9876543A");
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setLogin("clienteModificado");
		cliente.setPassword("usuario2");
		cliente.setFechaAlta(new Date());
		
		RepositorioCliente.modificarCliente(cliente);;
	}
	
	private static void consultarCliente(String nombre,String apellidos,String dni,EstadoCivil estadoCivil,String login) {
		final List<Cliente> personas = RepositorioCliente.consultar(nombre, apellidos, dni, estadoCivil,login);
		System.out.println(personas.size());
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
