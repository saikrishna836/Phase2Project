
package com.hibernatehelloworld.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users1")

public class User {
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
	@Column(name="email",unique=true)
	public String email;;
	@Column(name="password")
	public String password;
	@Column(name="firstname")
	public String firstname;
	@Column(name="lastname")
	public String lastname;
	public User(String email, String password, String firstname, String lastname) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public User( ) {}
	public User( String email,String password) {
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
