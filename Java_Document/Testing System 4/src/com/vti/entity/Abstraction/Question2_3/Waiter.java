package com.vti.entity.Abstraction.Question2_3;

public class Waiter extends User {

	public Waiter(String Name, double Salary_Ratio) {
		super(Name, Salary_Ratio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double CalculatePay() {
		return Salary_Ratio * 220;
	}

}
