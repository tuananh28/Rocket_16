package com.vti.entity;

public class Employee extends Account{
	private ProSkill proSkill;
	
	public enum ProSkill{
		DEV,TEST,JAVA,SQL
	}
	public Employee(String fullName, String email, String password, Category category, ProSkill proSkill) {
		super(fullName, email, password, category);
		this.proSkill = proSkill;
	}
	public ProSkill getProSkill() {
		return proSkill;
	}
	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}
	

}
