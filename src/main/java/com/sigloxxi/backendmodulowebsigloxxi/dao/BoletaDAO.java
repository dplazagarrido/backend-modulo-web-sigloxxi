package com.sigloxxi.backendmodulowebsigloxxi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	/* Calcular el total de la boleta*/
	@PersistenceUnit
	EntityManagerFactory emf;
	public List calcularTotal(Long id_pedido){
        EntityManager em = emf.createEntityManager();
        List arr_cust = em
                .createQuery("SELECT SUM(dp.valor * dp.cantidad) AS TOTAL FROM DetallePedido dp WHERE pedido_id_pedido = :id_pedido")
                .setParameter("id_pedido", id_pedido)
                .getResultList();
        return arr_cust;
	}
}
