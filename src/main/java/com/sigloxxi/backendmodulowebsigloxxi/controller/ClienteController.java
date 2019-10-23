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

import com.sigloxxi.backendmodulowebsigloxxi.dao.ClienteDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Cliente;

@RestController
@RequestMapping("/sigloxxi")
public class ClienteController {
	
	@Autowired
	ClienteDAO clienteDAO;
	
	/* Guardar un cliente */
	@PostMapping("/cliente")
	public Cliente createCliente(@Valid @RequestBody Cliente cli) {
		return clienteDAO.save(cli);
	}
	
	/* Obtener todos los clientes */
	@GetMapping("/cliente")
	public List<Cliente> getAllCliente(){
		return clienteDAO.findAll();
	}
	
	 /* Encontrar cliente por id */
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value="id") Long cliid){
		
		Cliente cli=clienteDAO.findOne(cliid);
		
		if(cli==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cli);
		
	}
	
	/* Actualizar un cliente */
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value="id") Long cliid, @Valid @RequestBody Cliente CliDetails){
		
		Cliente cli=clienteDAO.findOne(cliid);
		if(cli==null) {
			return ResponseEntity.notFound().build();
		}
		
		cli.setNombre(CliDetails.getNombre());
		cli.setAp_paterno(CliDetails.getAp_paterno());
		cli.setAp_materno(CliDetails.getAp_materno());
		
		Cliente updateCliente=clienteDAO.save(cli);
		
		
		return ResponseEntity.ok().body(updateCliente);
		
	}
	
	/* Eliminar cliente */
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable(value="id") Long cliid){
		
		Cliente cli=clienteDAO.findOne(cliid);
		
		if(cli==null) {
			return ResponseEntity.notFound().build();
		}
		
		clienteDAO.delete(cli);
		
		return ResponseEntity.ok().build();

		
	}
	

}
