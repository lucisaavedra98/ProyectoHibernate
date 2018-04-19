package es.ProyectoHibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "DetallePersona")
@Table(name = "A_DET")
public class DetallesPersona {

	@Id
	@GeneratedValue
	@Column(name = "DET_ID")
	private int idDetallePersona;
	
	@Column(name = "DET_HIJ", nullable = false)
	private boolean tieneHijos;
	
	@Column(name = "DET_DEP", nullable = false)
	private boolean practicaDeporte;
	
	@Column(name = "DET_MAS", nullable = false)
	private boolean tieneMascotas;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detalle_id")
    private Persona persona;
	
	public DetallesPersona() {
		
	}

	public DetallesPersona(boolean tieneHijos, boolean practicaDeporte, boolean tieneMascotas) {
		super();
		this.tieneHijos = tieneHijos;
		this.practicaDeporte = practicaDeporte;
		this.tieneMascotas = tieneMascotas;
	}

	public int getIdDetallePersona() {
		return idDetallePersona;
	}

	public void setIdDetallePersona(int idDetallePersona) {
		this.idDetallePersona = idDetallePersona;
	}

	public boolean isTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public boolean isPracticaDeporte() {
		return practicaDeporte;
	}

	public void setPracticaDeporte(boolean practicaDeporte) {
		this.practicaDeporte = practicaDeporte;
	}

	public boolean isTieneMascotas() {
		return tieneMascotas;
	}

	public void setTieneMascotas(boolean tieneMascotas) {
		this.tieneMascotas = tieneMascotas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
