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

import com.sigloxxi.backendmodulowebsigloxxi.dao.DetallePedidoDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.DetallePedido;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/sigloxxi")
public class DetallePedidoController {
	
	@Autowired
	DetallePedidoDAO detallePedidoDAO;
	
	/* Guardar un Detalle Pedido */
	@PostMapping("/detallePedido")
	public DetallePedido createDetallePedido(@Valid @RequestBody DetallePedido det)
	{
		return detallePedidoDAO.save(det);
	}
	
	/* Obtener todos los detalle pedido */
	@GetMapping("/detallePedido")
	public List<DetallePedido> getAllDetallePedido(){
		return detallePedidoDAO.findAll();
	}
	
	/* Encontrar Detalle Pedido por id */
	@GetMapping("/detallePedido/{id}")
	public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable(value="id") Long detid){
		
		DetallePedido det=detallePedidoDAO.findOne(detid);
		
		if(det==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(det);
		
	}
	
	/* Actualizar Detalle Pedido*/
	@PutMapping("/detallePedido/{id}")
	public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable(value="id") Long detid, @Valid @RequestBody DetallePedido DetallePedidoDetails){
		
		DetallePedido det=detallePedidoDAO.findOne(detid);
		if(det==null) {
			return ResponseEntity.notFound().build();
		}
		
		det.setCantidad(DetallePedidoDetails.getCantidad());
		det.setValor(DetallePedidoDetails.getValor());
		det.setPedido_id_pedido(DetallePedidoDetails.getPedido_id_pedido());
		det.setPlato_id_plato(DetallePedidoDetails.getPlato_id_plato());
		
		DetallePedido updateDetallePedido=detallePedidoDAO.save(det);
		
		
		return ResponseEntity.ok().body(updateDetallePedido);
		
	}
	
	/* Eliminar Detalle Pedido */
	@DeleteMapping("/detallePedido/{id}")
	public ResponseEntity<DetallePedido> deleteDetallePedido(@PathVariable(value="id") Long detid){
		
		DetallePedido det=detallePedidoDAO.findOne(detid);
		
		if(det==null) {
			return ResponseEntity.notFound().build();
		}
		
		detallePedidoDAO.delete(det);
		
		return ResponseEntity.ok().build();

		
	}
	
	
	

}
