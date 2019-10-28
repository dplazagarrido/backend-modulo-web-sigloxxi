package com.sigloxxi.backendmodulowebsigloxxi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="metodo_pago")
public class MetodoPago {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_metodo_pago;
	
	private String descripcion;

	public long getId_metodo_pago() {
		return id_metodo_pago;
	}

	public void setId_metodo_pago(long id_metodo_pago) {
		this.id_metodo_pago = id_metodo_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
