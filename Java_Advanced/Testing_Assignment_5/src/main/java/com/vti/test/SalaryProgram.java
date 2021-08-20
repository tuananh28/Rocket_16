package com.vti.test;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.repository.SalaryRepository;

public class SalaryProgram {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();
		System.out.println("--------------- GET ALL SALARIES ---------------");
		List<Salary> list = repository.getAllSalaries();
		for (Salary salary : list) {
			System.out.println(salary);
		}
		System.out.println("--------------- CREATE SALARIES ---------------");
		Salary salary = new Salary();
		salary.setName(SalaryName.PM);
		repository.createSalary(salary);
	}
}
