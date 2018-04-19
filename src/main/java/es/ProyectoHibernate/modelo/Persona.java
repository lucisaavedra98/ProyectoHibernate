package es.ProyectoHibernate.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Persona")
@Table(name = "A_PER")
public class Persona extends Usuario{

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Direccion> direcciones = new ArrayList<>();
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Telefono> telefonos = new HashSet();
	
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DetallesPersona detalles;
	
	public Persona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	public DetallesPersona getDetalles() {
		return detalles;
	}

	public void setDetalles(DetallesPersona detalles) {
		this.detalles = detalles;
	}

	public void agregarDireccion(Direccion direccion) {
        direcciones.add( direccion );
        direccion.getPropietarios().add(this);
    }

    public void eliminarDirecciones() {
        direcciones.removeAll(getDirecciones());
    }

    public void agregarTelefono(Telefono telefono) {
        telefonos.add(telefono);
        telefono.setPersona( this );
    }

    public void eliminarTelefonos() {
        telefonos.removeAll(getTelefonos());
    }
    
    public void agregarDetalles(DetallesPersona detalles) {
        detalles.setPersona( this );
        this.detalles = detalles;
    }
}
