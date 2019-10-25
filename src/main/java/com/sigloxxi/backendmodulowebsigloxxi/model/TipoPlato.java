package com.sigloxxi.backendmodulowebsigloxxi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_plato")
public class TipoPlato {
	
	@Id
	private long id_tipo_plato;
	
	private String descripcion;

	public long getId_tipo_plato() {
		return id_tipo_plato;
	}

	public void setId_tipo_plato(long id_tipo_plato) {
		this.id_tipo_plato = id_tipo_plato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
