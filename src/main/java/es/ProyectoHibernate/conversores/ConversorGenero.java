package es.ProyectoHibernate.conversores;

import javax.persistence.AttributeConverter;

import es.ProyectoHibernate.modelo.*;

public class ConversorGenero implements AttributeConverter<Genero, String> {

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String valor) {
		return Genero.getEnumerado(valor);
	}
}
