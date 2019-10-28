package com.sigloxxi.backendmodulowebsigloxxi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="boleta")

public class Boleta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_boleta;
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date fecha;
	
	private long total;
	
	private long metodo_pago_id_metodo_pago;
	
	private long pedido_id_pedido;

	public long getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(long id_boleta) {
		this.id_boleta = id_boleta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getMetodo_pago_id_metodo_pago() {
		return metodo_pago_id_metodo_pago;
	}

	public void setMetodo_pago_id_metodo_pago(long metodo_pago_id_metodo_pago) {
		this.metodo_pago_id_metodo_pago = metodo_pago_id_metodo_pago;
	}

	public long getPedido_id_pedido() {
		return pedido_id_pedido;
	}

	public void setPedido_id_pedido(long pedido_id_pedido) {
		this.pedido_id_pedido = pedido_id_pedido;
	}
	
	

}
