
package com.hibernatehelloworld.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="email")
	public String email;;
	@Column(name="password")
	public String password;
	public Admin( ) {}
	public Admin( String email,String password) {
		this.email=email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
