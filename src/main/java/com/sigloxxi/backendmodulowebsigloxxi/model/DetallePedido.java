package com.sigloxxi.backendmodulowebsigloxxi.model;

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
@Table(name="detalle_pedido")

public class DetallePedido {

	private long valor;
	
	@Id
	private long pedido_id_pedido;
	
	private long plato_id_plato;
	
	private long cantidad;
	
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	public long getPedido_id_pedido() {
		return pedido_id_pedido;
	}
	public void setPedido_id_pedido(long pedido_id_pedido) {
		this.pedido_id_pedido = pedido_id_pedido;
	}
	public long getPlato_id_plato() {
		return plato_id_plato;
	}
	public void setPlato_id_plato(long plato_id_plato) {
		this.plato_id_plato = plato_id_plato;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
