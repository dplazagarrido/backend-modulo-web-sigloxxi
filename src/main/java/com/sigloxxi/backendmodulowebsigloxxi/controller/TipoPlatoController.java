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

import com.sigloxxi.backendmodulowebsigloxxi.dao.TipoPlatoDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Plato;
import com.sigloxxi.backendmodulowebsigloxxi.model.TipoPlato;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/sigloxxi")
public class TipoPlatoController {
	
	@Autowired
	TipoPlatoDAO tipoPlatoDAO;
	
	/* Guardar un Tipo Plato */
	@PostMapping("/tipoPlato")
	public TipoPlato createTipoPlato(@Valid @RequestBody TipoPlato tip) {
		return tipoPlatoDAO.save(tip);
	}
	
	/* Obtener todos los tipo platos */
	@GetMapping("/tipoPlato")
	public List<TipoPlato> getAllTipoPlato(){
		return tipoPlatoDAO.findAll();
	}
	
	/* Encontrar tipo plato por id */
	@GetMapping("/tipoPlato/{id}")
	public ResponseEntity<TipoPlato> getTipoPlatoById(@PathVariable(value="id") Long tipid){
		
		TipoPlato tip=tipoPlatoDAO.findOne(tipid);
		
		if(tip==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(tip);
		
	}
	
	/* Actualizar un tipo plato */
	@PutMapping("/tipoPlato/{id}")
	public ResponseEntity<TipoPlato> updateTipoPlato(@PathVariable(value="id") Long tipid, @Valid @RequestBody TipoPlato TipoPlatoDetails){
		
		TipoPlato tip=tipoPlatoDAO.findOne(tipid);
		if(tip==null) {
			return ResponseEntity.notFound().build();
		}
		
		tip.setId_tipo_plato(TipoPlatoDetails.getId_tipo_plato());
		tip.setDescripcion(TipoPlatoDetails.getDescripcion());
		
		TipoPlato updateTipoPlato = tipoPlatoDAO.save(tip);
		
		
		return ResponseEntity.ok().body(updateTipoPlato);
		
	}
	
	/* Eliminar tipo plato */
	@DeleteMapping("/tipoPlato/{id}")
	public ResponseEntity<TipoPlato> deleteTipoPlato(@PathVariable(value="id") Long tipid){
		
		TipoPlato tip=tipoPlatoDAO.findOne(tipid);
		
		if(tip==null) {
			return ResponseEntity.notFound().build();
		}
		
		tipoPlatoDAO.delete(tip);
		
		return ResponseEntity.ok().build();

		
	}

}
