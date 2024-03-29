package com.sigloxxi.backendmodulowebsigloxxi.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="mesa")

public class Mesa {
	
	@Id
	@SequenceGenerator(name= "MESA_SEQ", sequenceName = "mesa_id_mesa_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MESA_SEQ")
	private long id_mesa;
	
	
	private long numero;
	
	
	private char estado; 
	
	
	private long cantidad_personas;

	public long getId_mesa() {
		return id_mesa;
	}

	public void setId_mesa(long id_mesa) {
		this.id_mesa = id_mesa;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public long getCantidad_personas() {
		return cantidad_personas;
	}

	public void setCantidad_personas(long cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}
	
	

}
