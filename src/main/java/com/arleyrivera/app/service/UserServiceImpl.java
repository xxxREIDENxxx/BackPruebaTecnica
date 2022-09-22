package com.arleyrivera.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arleyrivera.app.entity.User;
import com.arleyrivera.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository rolRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		
		return rolRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> FindAll(Pageable pageable) {
		
		return rolRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		
		return rolRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		
		return rolRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		rolRepository.deleteById(id);
		
	}

	@Override
	public List<User> findByNameAndPassword( String username, String password) {
		return  rolRepository.findByNameAndPassword( username, password);
		
	}
	
	
}
