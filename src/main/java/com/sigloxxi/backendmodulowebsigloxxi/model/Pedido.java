package com.sigloxxi.backendmodulowebsigloxxi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Pedido")

public class Pedido {

	@Id
	private long id_pedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date hora_pedido;
	
	private long mesa_id_mesa;
	
	private long cliente_id_cliente;

	
	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getHora_pedido() {
		return hora_pedido;
	}

	public void setHora_pedido(Date hora_pedido) {
		this.hora_pedido = hora_pedido;
	}

	public long getMesa_id_mesa() {
		return mesa_id_mesa;
	}

	public void setMesa_id_mesa(long mesa_id_mesa) {
		this.mesa_id_mesa = mesa_id_mesa;
	}

	public long getCliente_id_cliente() {
		return cliente_id_cliente;
	}

	public void setCliente_id_cliente(long cliente_id_cliente) {
		this.cliente_id_cliente = cliente_id_cliente;
	}
	
	
	
	
}
