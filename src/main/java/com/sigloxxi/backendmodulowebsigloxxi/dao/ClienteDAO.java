package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigloxxi.backendmodulowebsigloxxi.model.Cliente;
import com.sigloxxi.backendmodulowebsigloxxi.repository.ClienteRepository;


@Service
public class ClienteDAO {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	/* Guardar un Cliente */
	
	public Cliente save (Cliente cli) {
		return  clienteRepository.save(cli);
	}
	
	/* Listar Clientes */
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	/* Buscar un Cliente */
	
	public Cliente findOne(Long cliid) {
		return clienteRepository.findById(cliid).orElse(null);
	}
	
	
	/* Eliminar un Cliente */
	
	public void delete(Cliente cli) {
		clienteRepository.delete(cli);
	}
	
	

}
