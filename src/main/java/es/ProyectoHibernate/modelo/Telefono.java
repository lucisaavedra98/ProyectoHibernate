package es.ProyectoHibernate.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "Telefono")
@Table(name = "A_TEL")
public class Telefono implements Serializable{
	@Id
	@GeneratedValue(
		        strategy = GenerationType.SEQUENCE,
		        generator = "sequence-generator"
		    )
	@SequenceGenerator(
		        name = "sequence-generator",
		        sequenceName = "sequenciaDeTelefonos",
		        initialValue=1,
		        allocationSize = 1
		    )
	@Column(name = "TEL_ID", nullable = false, unique=true)
	private int idTelefono;

	@Column(name = "TEL_NUM", nullable = false)
	private String numero;

	@ManyToOne
	private Persona persona;
	
	public Telefono() {
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
