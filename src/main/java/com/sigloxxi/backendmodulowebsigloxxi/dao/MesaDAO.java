package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.Mesa;
import com.sigloxxi.backendmodulowebsigloxxi.repository.MesaRepository;

@Service
public class MesaDAO {

	@Autowired
	MesaRepository mesaRepository;
	
	
	/* Guardar Mesa*/
	public Mesa save (Mesa mes) {
		return mesaRepository.save(mes);
	}
	
	/* Listar Mesas */
	public List<Mesa> findAll(){
		return mesaRepository.findAll();
	}
	
	/* Buscar una Mesa */
	public Mesa findOne(Long mesid) {
		return mesaRepository.findById(mesid).orElse(null);
	}
	
	/* Eliminar Mesa */
	
	public void delete(Mesa mes) {
		mesaRepository.delete(mes);
	}
	
	
	
}
