package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.Plato;
import com.sigloxxi.backendmodulowebsigloxxi.repository.PlatoRepository;

@Service
public class PlatoDAO {

	@Autowired
	PlatoRepository platoRepository;
	
	/* Guardar un Plato */
	public Plato save (Plato pla) {
		return platoRepository.save(pla);
	}
	
	/* Listar Platos */
	public List<Plato> findAll(){
		return platoRepository.findAll();
	}
	/* Buscar Plato */
	public Plato findOne(long plaid) {
		return platoRepository.findById(plaid).orElse(null);
		
	}
	
	/* Eliminar Plato */
	public void delete(Plato pla) {
		platoRepository.delete(pla);
	}
}
