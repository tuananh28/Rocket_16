package com.vti.entity.Abstraction.Question2_3;

public abstract class User {
	private String Name;
	double	Salary_Ratio;
	
	public User(String Name, double Salary_Ratio) {
		this.Name = Name;
		this.Salary_Ratio = Salary_Ratio;
	}
	
	public abstract Double CalculatePay();
	
	public void displayInfor() {
		System.out.println("Name : "+Name);
		System.out.println("Salary Ratio : "+Salary_Ratio);
		System.out.println("CalculatePay : "+CalculatePay());
	}
}
