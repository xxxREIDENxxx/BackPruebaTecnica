package com.arleyrivera.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.arleyrivera.app.entity.User;
import com.arleyrivera.app.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/api/rol")
public class UserController {
	
	@Autowired
	private UserService rolService;
	
	// Create a new user
	@PostMapping(path = "/guardar")
	public ResponseEntity<?> create (@RequestBody User rol){
		return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol));
	}

	//Read an user
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long rolId){
		Optional<User> oUser = rolService.findById(rolId);
			
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(oUser);
		}
	
	//Update an user
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long  rolId){
		Optional<User> user = rolService.findById(rolId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		user.get().setUsername(userDetails.getUsername());
		user.get().setName(userDetails.getName());
		user.get().setPassword(userDetails.getPassword());
		user.get().setRol(userDetails.getRol());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(user.get()));
	}
		
	//delete an User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long userId){
		if(!rolService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		rolService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	//Read all User
	@GetMapping
	public List <User> readAll () {
		
		List<User> users = StreamSupport
				.stream(rolService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;			
	}
	
	//login an User
	@PostMapping(path = "/login")
	public User login(@RequestBody User usuario){
		
		List<User> usuarios = rolService.findByNameAndPassword(usuario.getUsername(), usuario.getPassword());
				
		if(!usuarios.isEmpty()) {
			return usuarios.get(0);
		}
		return null;
	}
	
}
