package com.sigloxxi.backendmodulowebsigloxxi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
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

import com.sigloxxi.backendmodulowebsigloxxi.dao.PlatoDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Mesa;
import com.sigloxxi.backendmodulowebsigloxxi.model.Plato;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
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
	
	
	/* Mostrar los platos segun categorias*/
	@PersistenceUnit
	EntityManagerFactory emf;
	@GetMapping("/plato/categoria/{categoria}")
	public List getPlatosCategoria(@PathVariable(value="categoria") String categoria){
        EntityManager em = emf.createEntityManager();
        List arr_cust = em
                .createQuery("select p from Plato p join TipoPlato tp on (p.tipo_plato_id_tipo_plato = tp.id_tipo_plato) where tp.descripcion = :categoria")
                .setParameter("categoria", categoria)
                .getResultList();
        return arr_cust;
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
		pla.setTiempo_preparacion(PlaDetails.getTiempo_preparacion());
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
