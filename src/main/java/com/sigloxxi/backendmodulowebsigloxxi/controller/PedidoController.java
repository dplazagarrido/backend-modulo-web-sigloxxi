package com.sigloxxi.backendmodulowebsigloxxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigloxxi.backendmodulowebsigloxxi.dao.PedidoDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Pedido;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/sigloxxi")
public class PedidoController {
	
	@Autowired
	PedidoDAO pedidoDAO;
	
	/* Guardar un Pedido */
	@PostMapping("/pedido")
	public Pedido createPedido(@Valid @RequestBody Pedido ped) {
		return pedidoDAO.save(ped);
	}
	
	/* Obtener todos los pedidos */
	@GetMapping("/pedido")
	public List<Pedido> getAllPedido(){
		return pedidoDAO.findAll();
	}
	
	/* Encontrar cliente por id */
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable(value="id") Long pedid){
		
		Pedido ped=pedidoDAO.findOne(pedid);
		
		if(ped==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ped);
		
	}
	
	
	/* Actualizar un pedido */
	@PutMapping("/pedido/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable(value="id") Long pedid, @Valid @RequestBody Pedido PedDetails){
		
		Pedido ped=pedidoDAO.findOne(pedid);
		if(ped==null) {
			return ResponseEntity.notFound().build();
		}
		
		ped.setHora_pedido(PedDetails.getHora_pedido());
		ped.setMesa_id_mesa(PedDetails.getMesa_id_mesa());
		ped.setCliente_id_cliente(PedDetails.getCliente_id_cliente());
		
		Pedido updatePedido = pedidoDAO.save(ped);
		
		
		return ResponseEntity.ok().body(updatePedido);
		
	}
	
	/* Eliminar pedido */
	@DeleteMapping("/pedido/{id}")
	public ResponseEntity<Pedido> deletePedido(@PathVariable(value="id") Long pedid){
		
		Pedido ped=pedidoDAO.findOne(pedid);
		
		if(ped==null) {
			return ResponseEntity.notFound().build();
		}
		
		pedidoDAO.delete(ped);
		
		return ResponseEntity.ok().build();

		
	}





}
