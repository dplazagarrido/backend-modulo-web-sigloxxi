package com.sigloxxi.backendmodulowebsigloxxi.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="cliente")

public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_cliente;
	

	private String nombre;
	
	private String ap_paterno;

	
	private String ap_materno;

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	
	
	
	
	
	

}
