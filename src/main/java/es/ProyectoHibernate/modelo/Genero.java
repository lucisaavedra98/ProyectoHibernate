package es.ProyectoHibernate.modelo;

import java.util.Arrays;

public enum Genero {

	MASCULINO("M"),FEMENINO("F");
	
	private String codigo;

	private Genero(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public static Genero getEnumerado(String valor) {
		if(valor=="M") {
			return MASCULINO;
		}
		if(valor=="F") {
			return FEMENINO;
		}
		else {
			return null;
		}
	}
}
