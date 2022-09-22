package com.arleyrivera.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.arleyrivera.app.entity.User;


public interface UserService {
	
	public Iterable<User> findAll();
	
	public Page<User> FindAll(Pageable pageable);

	public Optional<User> findById(Long id);
	
	public User save(User rol);
	
	public void deleteById(Long id);
	
	public List<User> findByNameAndPassword(String username, String password);
}
