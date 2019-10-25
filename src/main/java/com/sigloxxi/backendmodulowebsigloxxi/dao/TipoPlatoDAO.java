package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.TipoPlato;
import com.sigloxxi.backendmodulowebsigloxxi.repository.TipoPlatoRepository;

@Service
public class TipoPlatoDAO {
	
	@Autowired
	TipoPlatoRepository tipoPlatoRepository;
	
	/* Guardar un Tipo Plato */
	public TipoPlato save (TipoPlato tip) {
		return tipoPlatoRepository.save(tip);
	}
	
	/* Listar Tipo Platos */
	public List<TipoPlato> findAll(){
		return tipoPlatoRepository.findAll();
	}
	/* Buscar TIpo Plato */
	public TipoPlato findOne(long tipid) {
		return tipoPlatoRepository.findById(tipid).orElse(null);
		
	}
	
	/* Eliminar Tipo Plato */
	public void delete(TipoPlato tip) {
		tipoPlatoRepository.delete(tip);
	}

}
