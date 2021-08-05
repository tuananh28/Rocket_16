package com.vti.entity;

public class User {	
	private int id;
	private String FullName;
	private String Email;
	private String Password;
	private Category category;
	
	public enum Category {
		ADMIN,EMPLOYEE
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String FullName) {
		this.FullName = FullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
