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
	
	@Query(value = "select * from pedidos u where u.fecha BETWEEN :inicial and :finalizar", nativeQuery = true)
	public List<Pedido> getFecha(LocalDate inicial, LocalDate finalizar); 
	
	@Query(value = "select * from pedidos u where u.estado = :estado ", nativeQuery = true)
	public List<Pedido> getEstado(Boolean estado); 
	
	//select * from pedidos u where u.fecha >= :inicial AND u.fecha <= :finalizar
	//public List<Pedido> findAllByFechaLessThanEqualAndFechaGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);
}
