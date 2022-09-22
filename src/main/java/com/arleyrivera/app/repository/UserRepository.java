package com.arleyrivera.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arleyrivera.app.entity.User;

@Repository("rolRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	public List<User> findByNameAndPassword(String username, String password);
	
	/*@Query("select u from User u where u.rol = true")
	public List<User> getDistributor(); */
}
