package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.Pedido;
import com.sigloxxi.backendmodulowebsigloxxi.repository.PedidoRepository;


@Service
public class PedidoDAO {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	/* Guardar Pedido */
	public Pedido save (Pedido ped) {
		return pedidoRepository.save(ped);
	}
	
	/* Listar Pedidos */
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	/* Buscar Pedido */
	public Pedido findOne(long pedid) {
		return pedidoRepository.findById(pedid).orElse(null);
		
	}
	
	/* Eliminar Pedido */
	public void delete(Pedido ped) {
		pedidoRepository.delete(ped);
	}
	
	

}
