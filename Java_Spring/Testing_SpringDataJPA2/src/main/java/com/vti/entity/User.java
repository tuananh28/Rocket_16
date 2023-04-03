package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`User`")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`username`", nullable = false, length = 50, unique = true)
	private String userName;

	@Column(name = "`email`", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "`password`", nullable = false, length = 800)
	private String password;

	@Column(name = "`firstName`", nullable = false, length = 50)
	private String firstName;

	@Column(name = "`lastName`", nullable = false, length = 50)
	private String lastName;

	@Formula("concat(firstName, ' ', lastName)")
	private String fullName;

	@Column(name = "role", nullable = false)
	private String role;

	public User() {
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getRole() {
		return role;
	}

}