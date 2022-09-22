package com.arleyrivera.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "users")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1032891694200732795L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50, nullable=false)
	private String username;
	
	@Column(length = 50, nullable=false)
	private String name;
	
	@Column(length = 50, nullable=false)
	private String password;
	
	private Boolean rol;
	@OneToMany(mappedBy="user")
	private List<Pedido> pedidos;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRol() {
		return rol;
	}

	public void setRol(Boolean rol) {
		this.rol = rol;
	}
	@JsonIgnore
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
