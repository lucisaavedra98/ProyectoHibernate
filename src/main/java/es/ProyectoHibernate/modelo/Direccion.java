package es.ProyectoHibernate.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="A_DIR")
@Entity(name="DireccionPersona")
public class Direccion implements Serializable{
	
	@Id
	@GeneratedValue
    @Column(name="DIR_ID")
	private int idDireccion;
	
	@Column(name = "DIR_PRO")
	private String provincia;
	
	@Column(name = "DIR_COD")
	private String codigoPostal;
	
	@Column(name = "DIR_CAL", nullable = false)
	private String calle;
	
	@Column(name = "DIR_NUM")
	private Integer numero;
	
	@Column(name = "DIR_BLO")
	private Integer bloque;
	
	@Column(name = "DIR_PLA")
	private Integer planta;
	
	@Column(name = "DIR_PUE")
	private String puerta;
	
	@ManyToMany(mappedBy = "direcciones")
	private static List<Persona> propietarios = new ArrayList<>();
	 
	 public Direccion() {
		 
	 }

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public List<Persona> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(List<Persona> propietarios) {
		this.propietarios = propietarios;
	}
}
