package com.sigloxxi.backendmodulowebsigloxxi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plato")
public class Plato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_plato;
	
	private String nombre;
	
	private long tiempo_preparación;
	
	private long costo;
	
	private String descripcion;
	
	private long receta_id_receta;
	
	private long tipo_plato_id_tipo_plato;

	public long getId_plato() {
		return id_plato;
	}

	public void setId_plato(long id_plato) {
		this.id_plato = id_plato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTiempo_preparación() {
		return tiempo_preparación;
	}

	public void setTiempo_preparación(long tiempo_preparación) {
		this.tiempo_preparación = tiempo_preparación;
	}

	public long getCosto() {
		return costo;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getReceta_id_receta() {
		return receta_id_receta;
	}

	public void setReceta_id_receta(long receta_id_receta) {
		this.receta_id_receta = receta_id_receta;
	}

	public long getTipo_plato_id_tipo_plato() {
		return tipo_plato_id_tipo_plato;
	}

	public void setTipo_plato_id_tipo_plato(long tipo_plato_id_tipo_plato) {
		this.tipo_plato_id_tipo_plato = tipo_plato_id_tipo_plato;
	}

	
}
