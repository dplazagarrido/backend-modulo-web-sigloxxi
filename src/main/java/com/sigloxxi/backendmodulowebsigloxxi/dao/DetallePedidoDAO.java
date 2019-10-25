package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.DetallePedido;
import com.sigloxxi.backendmodulowebsigloxxi.repository.DetallePedidoRepository;

@Service
public class DetallePedidoDAO {
	
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	
	/* Guardar Detalle Pedido */
	public DetallePedido save (DetallePedido det)
	{
		return detallePedidoRepository.save(det);
	}
	
	/* Listar Detalles Pedidos */
	public List<DetallePedido> findAll()
	{
		return detallePedidoRepository.findAll();
	}
	
	/* Buscar Detalles Pedido */
	public DetallePedido findOne(Long detid)
	{
		return detallePedidoRepository.findById(detid).orElse(null);
	}
	
	
	/* Eliminar Detalle Pedido */
	public void delete(DetallePedido det)
	{
		detallePedidoRepository.delete(det);
	}
	
	

	
}
