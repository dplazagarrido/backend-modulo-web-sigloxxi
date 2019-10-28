package com.sigloxxi.backendmodulowebsigloxxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigloxxi.backendmodulowebsigloxxi.dao.MetodoPagoDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.MetodoPago;

@RestController
@RequestMapping("/sigloxxi-")
public class MetodoPagoController {
	
	@Autowired
	MetodoPagoDAO metodoPagoDAO;
	
	/* Guardar un Metodo Pago */
	@PostMapping("/metodoPago")
	public MetodoPago createMetodoPago(@Valid @RequestBody MetodoPago met) {
		return metodoPagoDAO.save(met);
	}
	
	/* Obtener todos los metodos pago */
	@GetMapping("/metodoPago")
	public List<MetodoPago> getAllMetodoPago(){
		return metodoPagoDAO.findAll();
	}
	
	/* Encontrar metodo de pago por id */
	@GetMapping("/metodoPago/{id}")
	public ResponseEntity<MetodoPago> getMetodoPagoById(@PathVariable(value="id") Long metid){
		
		MetodoPago met=metodoPagoDAO.findOne(metid);
		
		if(met==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(met);
		
	}
	
	
	/* Actualizar un metodo de pago */
	@PutMapping("/metodoPago/{id}")
	public ResponseEntity<MetodoPago> updateMetodoPago(@PathVariable(value="id") Long metid, @Valid @RequestBody MetodoPago MetDetails){
		
		MetodoPago met=metodoPagoDAO.findOne(metid);
		if(met==null) {
			return ResponseEntity.notFound().build();
		}
		
		met.setId_metodo_pago(MetDetails.getId_metodo_pago());
		met.setDescripcion(MetDetails.getDescripcion());
		
		MetodoPago updateMetodoPago = metodoPagoDAO.save(met);
		
		
		return ResponseEntity.ok().body(updateMetodoPago);
		
	}
	
	/* Eliminar metodo de pago */
	@DeleteMapping("/metodoPago/{id}")
	public ResponseEntity<MetodoPago> deleteMetodoPago(@PathVariable(value="id") Long metid){
		
		MetodoPago met=metodoPagoDAO.findOne(metid);
		
		if(met==null) {
			return ResponseEntity.notFound().build();
		}
		
		metodoPagoDAO.delete(met);
		
		return ResponseEntity.ok().build();

		
	}


}
