package com.arleyrivera.app.service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arleyrivera.app.entity.Pedido;


public interface PedidoService {
	public Iterable<Pedido> findAll();
	
	public Page<Pedido> FindAll(Pageable pageable);
	
	public Iterable<Pedido> findPedidoForUser(Long id);
	
	public Iterable<Pedido> getFecha(LocalDate inicial ,LocalDate finalizar);
	
	public Iterable<Pedido> getEstado(Boolean estado); 

	public Optional<Pedido> findById(Long id);
	
	public Pedido save(Pedido rol);
	
	public void deleteById(Long id);
}
