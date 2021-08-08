package com.vti.entity;

public class Employee extends Account{
	private int ProSkill;

	public Employee(String fullName, String email, String password, Category category, Role role, int proSkill) {
		super(fullName, email, password, category, role);
		ProSkill = proSkill;
	}

	public int getProSkill() {
		return ProSkill;
	}

	public void setProSkill(int proSkill) {
		ProSkill = proSkill;
	}
	
}
