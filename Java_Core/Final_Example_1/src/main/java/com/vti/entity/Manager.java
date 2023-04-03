package com.vti.entity;

public class Manager extends Account{
	private int expIntYear;
	public Manager(String fullName, String email, String password, Category category, int expIntYear) {
		super(fullName, email, password, category);
		this.expIntYear = expIntYear;
		// TODO Auto-generated constructor stub
		
	}
	public int getExpIntYear() {
		return expIntYear;
	}
	public void setExpIntYear(int expIntYear) {
		this.expIntYear = expIntYear;
	}

}
