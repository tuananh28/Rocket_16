package com.vti.entity;

public class Account {
	private int ID;
	private	String FullName;
	private String Email;
	private	String Password;
	private	Category category;
	//private int dem = 0;
	
	public enum Category{
		MANAGER, EMPLOYEE
	}
	public Account(String fullName, String email, String password, Category category) {
		super();
		FullName = fullName;
		Email = email;
		Password = password;
		this.category = category;
	}
	public Account() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	@Override
	public String toString() {
		return "Account [ID=" + ID + ", FullName=" + FullName + ", Email=" + Email + ", Password=" + Password
				+ ", category=" + category + "]";
	}
	
}
