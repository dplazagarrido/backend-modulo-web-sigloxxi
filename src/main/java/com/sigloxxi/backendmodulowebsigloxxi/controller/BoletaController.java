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

import com.sigloxxi.backendmodulowebsigloxxi.dao.BoletaDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Boleta;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/sigloxxi")
public class BoletaController {
	
	@Autowired
	BoletaDAO boletaDAO;
	
	/* Guardar Boleta */
	@PostMapping("/boleta")
	public Boleta createBoleta(@Valid @RequestBody Boleta bol) {
		return boletaDAO.save(bol);
	}
	
	/* Obtener todos las boletas */
	@GetMapping("/boleta")
	public List<Boleta> getAllBoleta(){
		return boletaDAO.findAll();
	}
	
	 /* Encontrar boleta por id */
	@GetMapping("/boleta/{id}")
	public ResponseEntity<Boleta> getBoletaById(@PathVariable(value="id") Long bolid){
		
		Boleta bol=boletaDAO.findOne(bolid);
		
		if(bol==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bol);
		
	}
	
	/* Actualizar una boleta */
	@PutMapping("/boleta/{id}")
	public ResponseEntity<Boleta> updateBoleta(@PathVariable(value="id") Long bolid, @Valid @RequestBody Boleta BolDetails){
		
		Boleta bol=boletaDAO.findOne(bolid);
		if(bol==null) {
			return ResponseEntity.notFound().build();
		}
		
		bol.setId_boleta(BolDetails.getId_boleta());
		bol.setFecha(BolDetails.getFecha());
		bol.setTotal(BolDetails.getTotal());
		bol.setMetodo_pago_id_metodo_pago(BolDetails.getMetodo_pago_id_metodo_pago());
		bol.setPedido_id_pedido(BolDetails.getPedido_id_pedido());
		
		Boleta updateBoleta=boletaDAO.save(bol);
		
		
		return ResponseEntity.ok().body(updateBoleta);
		
	}
	
	/* Eliminar boleta */
	@DeleteMapping("/boleta/{id}")
	public ResponseEntity<Boleta> deleteBoleta(@PathVariable(value="id") Long bolid){
		
		Boleta bol=boletaDAO.findOne(bolid);
		
		if(bol==null) {
			return ResponseEntity.notFound().build();
		}
		
		boletaDAO.delete(bol);
		
		return ResponseEntity.ok().build();

		
	}

}
