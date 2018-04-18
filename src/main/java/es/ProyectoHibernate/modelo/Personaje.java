package es.ProyectoHibernate.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_PEJ")
public class Personaje implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "PEJ_ID")
	private int idPersonaje;

	@Column(name = "PEJ_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PEJ_ATR", nullable = false, length = 10)
	private String atributo;

	@Column(name = "PEJ_SAL", nullable = false)
	private Integer puntosSalud;

	@Column(name = "PEJ_EXP", nullable = false)
	private Integer puntosExperiencia;

	@Column(name = "PEJ_ATQ", nullable = false)
	@Enumerated
	private AtaquesPersonaje ataque;
	
	public Personaje() {
		
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public Integer getPuntosSalud() {
		return puntosSalud;
	}

	public void setPuntosSalud(Integer puntosSalud) {
		this.puntosSalud = puntosSalud;
	}

	public Integer getPuntosExperiencia() {
		return puntosExperiencia;
	}

	public void setPuntosExperiencia(Integer puntosExperiencia) {
		this.puntosExperiencia = puntosExperiencia;
	}

	public AtaquesPersonaje getAtaques() {
		return ataque;
	}

	public void setAtaques(AtaquesPersonaje ataques) {
		this.ataque = ataques;
	}
	
}
