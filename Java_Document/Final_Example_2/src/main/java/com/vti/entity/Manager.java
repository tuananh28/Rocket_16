package com.vti.entity;

public class Manager extends Account{
	private int expInYear;

	public Manager(String fullName, String email, String password, Category category, Role role, int expInYear) {
		super(fullName, email, password, category, role);
		this.expInYear = expInYear;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	
	
}
