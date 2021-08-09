package com.vti.entity;

public class User {
	private int UserID;
	private String FullName;
	private String Email;
	private	String Password;
	private Role role;
	
	public enum Role{
		ADMIN, EMPLOYEE
	}

	public User(String fullName, String email, String password, Role role) {
		super();
		FullName = fullName;
		Email = email;
		Password = password;
		this.role = role;
	}

	public User() {
		// TODO Auto-generated constructor stub
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
}
