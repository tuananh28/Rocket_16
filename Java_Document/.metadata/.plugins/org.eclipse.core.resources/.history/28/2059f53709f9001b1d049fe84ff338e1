package com.vti.entity;

public class Employee extends User{
	private ProSkill proSkill;
	public enum ProSkill {
		DEV,TEST,JAVA,SQL
	}
	public Employee(String fullName, String email, String password, Role role, ProSkill proSkill) {
		super(fullName, email, password, Role.EMPLOYEE);
		this.proSkill = proSkill;
	}
	public ProSkill getProSkill() {
		return proSkill;
	}
	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}
	
	
}
