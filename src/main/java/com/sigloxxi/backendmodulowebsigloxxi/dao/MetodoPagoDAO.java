package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.MetodoPago;
import com.sigloxxi.backendmodulowebsigloxxi.repository.MetodoPagoRepository;

@Service
public class MetodoPagoDAO {

	@Autowired
	MetodoPagoRepository metodoPagoRepository;
	
	/* Guardar Metodo Pago */
	public MetodoPago save (MetodoPago met) {
		return metodoPagoRepository.save(met);
	}
	
	/* Listar Metodo Pago */
	public List<MetodoPago> findAll(){
		return metodoPagoRepository.findAll();
	}
	
	/* Buscar Metodo Pago */
	public MetodoPago findOne(long metid) {
		return metodoPagoRepository.findById(metid).orElse(null);
		
	}
	
	/* Eliminar Metodo Pago */
	public void delete(MetodoPago met) {
		metodoPagoRepository.delete(met);
	}
}
