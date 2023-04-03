package com.vti.entity;

public class Account {
	private int AccountID;
	private String FullName;
	private String Email;
	private String Password;
	private Category category;
	private Role role;

	public enum Category {
		MANAGER, EMPLOYEE
	}

	public enum Role {
		ADMIN, USER
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String fullName, String email, String password, Category category, Role role) {
		super();
		FullName = fullName;
		Email = email;
		Password = password;
		this.category = category;
		this.role = role;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
