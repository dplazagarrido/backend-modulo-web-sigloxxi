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

import com.sigloxxi.backendmodulowebsigloxxi.dao.MesaDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Mesa;

@RestController
@RequestMapping("/sigloxxi")
public class MesaController {
	
	@Autowired
	MesaDAO mesaDAO;
	
	/* Guardar Mesa*/
	@PostMapping("/mesa")
	public Mesa createMesa(@Valid @RequestBody Mesa mes) {
		return mesaDAO.save(mes);
	}
	
	/* Obtener todas las mesas */
	@GetMapping("/mesa")
	public List<Mesa> getAllMesa(){
		return mesaDAO.findAll();
	}
	
	/* Encontrar mesa por id */
	@GetMapping("/mesa/{id}")
	public ResponseEntity<Mesa> getMesaById(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mes);
		
	}
	
	/* Actualizar una mesa */
	@PutMapping("/mesa/{id}")
	public ResponseEntity<Mesa> updateCliente(@PathVariable(value="id") Long mesid, @Valid @RequestBody Mesa MesDetails){
		
		Mesa mes=mesaDAO.findOne(mesid);
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
				
		mes.setNumero(mes.getNumero());
		mes.setEstado(mes.getEstado());
		mes.setCantidad_personas(mes.getCantidad_personas());
		
		Mesa updateMesa=mesaDAO.save(mes);
		
		
		return ResponseEntity.ok().body(updateMesa);
		
	}
	
	
	/* Eliminar mesa */
	@DeleteMapping("/mesa/{id}")
	public ResponseEntity<Mesa> deleteMesa(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
		
		mesaDAO.delete(mes);
		
		return ResponseEntity.ok().build();

		
	}

}
