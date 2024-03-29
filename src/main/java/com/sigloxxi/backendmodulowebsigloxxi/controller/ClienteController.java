package com.sigloxxi.backendmodulowebsigloxxi.controller;

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

import com.sigloxxi.backendmodulowebsigloxxi.dao.ClienteDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Cliente;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
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
	
	/* Encontrar un cliente por correo*/
	@PersistenceUnit
	EntityManagerFactory emf;
	@GetMapping("/cliente/buscar/{correo}")
	public List getClientePorCorreo(@PathVariable(value="correo") String correo){
        EntityManager em = emf.createEntityManager();
        List arr_cust = em
                .createQuery("SELECT c FROM Cliente c WHERE correo = :correo")
                .setParameter("correo", correo)
                .getResultList();
        return arr_cust;
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
