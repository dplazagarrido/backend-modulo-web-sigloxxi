package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.Boleta;
import com.sigloxxi.backendmodulowebsigloxxi.repository.BoletaRepository;

@Service
public class BoletaDAO {

	@Autowired
	BoletaRepository boletaRepository;
	
	/* Guardar Boleta */
	
	public Boleta save (Boleta bol) {
		return  boletaRepository.save(bol);
	}
	
	/* Listar Boletas */
	
	public List<Boleta> findAll(){
		return boletaRepository.findAll();
	}
	
	/* Buscar Boleta */
	
	public Boleta findOne(Long bolid) {
		return boletaRepository.findById(bolid).orElse(null);
	}
	
	
	/* Eliminar Boleta */
	
	public void delete(Boleta bol) {
		boletaRepository.delete(bol);
	}
}
