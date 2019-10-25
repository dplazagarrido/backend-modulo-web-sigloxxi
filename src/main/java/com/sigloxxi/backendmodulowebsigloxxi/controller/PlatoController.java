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

import com.sigloxxi.backendmodulowebsigloxxi.dao.PlatoDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Plato;

@RestController
@RequestMapping("/sigloxxi")
public class PlatoController {
	
	@Autowired
	PlatoDAO platoDAO;
	
	/* Guardar un Plato */
	@PostMapping("/plato")
	public Plato createPlato(@Valid @RequestBody Plato pla) {
		return platoDAO.save(pla);
	}
	
	/* Obtener todos los platos */
	@GetMapping("/plato")
	public List<Plato> getAllPlato(){
		return platoDAO.findAll();
	}
	
	/* Encontrar plato por id */
	@GetMapping("/plato/{id}")
	public ResponseEntity<Plato> getPlatoById(@PathVariable(value="id") Long plaid){
		
		Plato pla=platoDAO.findOne(plaid);
		
		if(pla==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pla);
		
	}
	
	/* Actualizar un plato */
	@PutMapping("/plato/{id}")
	public ResponseEntity<Plato> updatePlato(@PathVariable(value="id") Long plaid, @Valid @RequestBody Plato PlaDetails){
		
		Plato pla=platoDAO.findOne(plaid);
		if(pla==null) {
			return ResponseEntity.notFound().build();
		}
		
		pla.setId_plato(PlaDetails.getId_plato());
		pla.setCosto(PlaDetails.getCosto());
		pla.setDescripcion(PlaDetails.getDescripcion());
		pla.setNombre(PlaDetails.getNombre());
		pla.setTiempo_preparación(PlaDetails.getTiempo_preparación());
		pla.setReceta_id_receta(PlaDetails.getReceta_id_receta());
		pla.setTipo_plato_id_tipo_plato(PlaDetails.getTipo_plato_id_tipo_plato());
		
		Plato updatePlato = platoDAO.save(pla);
		
		
		return ResponseEntity.ok().body(updatePlato);
		
	}
	
	/* Eliminar plato */
	@DeleteMapping("/plato/{id}")
	public ResponseEntity<Plato> deletePlato(@PathVariable(value="id") Long plaid){
		
		Plato pla=platoDAO.findOne(plaid);
		
		if(pla==null) {
			return ResponseEntity.notFound().build();
		}
		
		platoDAO.delete(pla);
		
		return ResponseEntity.ok().build();

		
	}

}
