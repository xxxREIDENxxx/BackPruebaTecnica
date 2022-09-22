package com.arleyrivera.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arleyrivera.app.entity.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	public List<Pedido> findByUser_id (Long id);
	
	//public List<Pedido> findByLocalDate (LocalDate date);
	
	//@Query("select u from Pedidos u where u.fecha >= fechaIncio And fechaFinal <= ")
	//public List<Pedido> getDistributor(); 
}
