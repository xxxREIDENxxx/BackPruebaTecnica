package com.arleyrivera.app.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arleyrivera.app.entity.Pedido;
import com.arleyrivera.app.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedido> findAll() {
		
		return pedidoRepository.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedido> findPedidoForUser(Long id){
		return pedidoRepository.findByUser_id(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedido> getFecha(LocalDate inicial, LocalDate finalizar) {
		
		return pedidoRepository.getFecha(inicial, finalizar );
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedido> getEstado(Boolean estado){
		return pedidoRepository.getEstado(estado );
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pedido> FindAll(Pageable pageable) {
		
		return pedidoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findById(Long id) {
		
		return pedidoRepository.findById(id);
	}

	@Override
	@Transactional
	public Pedido save(Pedido rol) {
		
		return pedidoRepository.save(rol);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		pedidoRepository.deleteById(id);
		
	}
	

}
