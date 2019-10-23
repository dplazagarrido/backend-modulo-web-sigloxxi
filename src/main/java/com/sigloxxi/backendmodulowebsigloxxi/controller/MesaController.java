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

import com.sigloxxi.backendmodulowebsigloxxi.dao.MesaDAO;
import com.sigloxxi.backendmodulowebsigloxxi.model.Mesa;

@RestController
@RequestMapping("/sigloxxi")
public class MesaController {
	
	@Autowired
	MesaDAO mesaDAO;
	
	/* Guardar Mesa*/
	@PostMapping("/mesa")
	public Mesa createMesa(@Valid @RequestBody Mesa mes) {
		return mesaDAO.save(mes);
	}
	
	/* Obtener todas las mesas */
	@GetMapping("/mesa")
	public List<Mesa> getAllMesa(){
		return mesaDAO.findAll();
	}
	
	/* Encontrar mesa por id */
	@GetMapping("/mesa/{id}")
	public ResponseEntity<Mesa> getMesaById(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mes);
		
	}
	
	/* Actualizar una mesa */
	@PutMapping("/mesa/{id}")
	public ResponseEntity<Mesa> updateMesa(@PathVariable(value="id") Long mesid, @Valid @RequestBody Mesa MesDetails){
		
		Mesa mes=mesaDAO.findOne(mesid);
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
				
		mes.setNumero(MesDetails.getNumero());
		mes.setEstado(MesDetails.getEstado());
		mes.setCantidad_personas(MesDetails.getCantidad_personas());
		
		Mesa updateMesa=mesaDAO.save(mes);
		
		
		return ResponseEntity.ok().body(updateMesa);
		
	}
	
	
	/* Eliminar mesa */
	@DeleteMapping("/mesa/{id}")
	public ResponseEntity<Mesa> deleteMesa(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
		
		mesaDAO.delete(mes);
		
		return ResponseEntity.ok().build();

		
	}
	
	/* Cambiar estado de mesa disponible */
	@PostMapping("/mesa/d/{id}")
	public ResponseEntity<Mesa> updateEstadoMesaDisponible(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
				
		mes.setEstado('L');
		
		Mesa updateMesa=mesaDAO.save(mes);
		
		
		return ResponseEntity.ok().body(updateMesa);
		
	}
	
	/* Cambiar estado de mesa Ocupada */
	@PostMapping("/mesa/o/{id}")
	public ResponseEntity<Mesa> updateEstadoMesaOcupada(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
				
		mes.setNumero(mes.getNumero());
		mes.setEstado('O');
		mes.setCantidad_personas(mes.getCantidad_personas());
		
		Mesa updateMesa=mesaDAO.save(mes);
		
		
		return ResponseEntity.ok().body(updateMesa);
		
	}
	
	/* Cambiar estado de mesa en Mantencion */
	@PostMapping("/mesa/m/{id}")
	public ResponseEntity<Mesa> updateEstadoMesaMantencion(@PathVariable(value="id") Long mesid){
		
		Mesa mes=mesaDAO.findOne(mesid);
		if(mes==null) {
			return ResponseEntity.notFound().build();
		}
				
		mes.setNumero(mes.getNumero());
		mes.setEstado('M');
		mes.setCantidad_personas(mes.getCantidad_personas());
		
		Mesa updateMesa=mesaDAO.save(mes);
		
		
		return ResponseEntity.ok().body(updateMesa);
		
	}
	
	/* Encontrar mesa por id  (CAMBIA EL ESTADO DE TODAS LAS MESAS QUE CUMPLEN ESE REQUISITO)*/ 
	
	@GetMapping("/mesa/asignar/{cantidad}")
	public ResponseEntity<Mesa> getMesaDisponible(@PathVariable(value="cantidad") Long cantidad){
		
		Mesa asignarMesa = null;
		
		
		
		for (Mesa mesa : mesaDAO.findAll()) {
			
			if(mesa.getCantidad_personas() >= cantidad && mesa.getEstado() =='L')
			{
				mesa = mesaDAO.findOne(mesa.getId_mesa());
				mesa.setEstado('O');
				asignarMesa = mesaDAO.save(mesa);
				

			}
			break;
		}
			
		
		return ResponseEntity.ok().body(asignarMesa);

	}
}


	


