package com.vti.test;

import java.util.List;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;

public class EmployeeProgram {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();
		System.out.println("---------------- GET ALL EmployeeS ----------------");
		List<Employee> list = repository.getAllEmployees();
		for (Employee Employee : list) {
			System.out.println(Employee);
		}
//		System.out.println("---------------- CREATE EmployeeS -----------------");
//		Employee Employee= new Employee();
//		Employee.setEmail("tuananh@gmail.com");
//		Employee.setUserName("tuananhbui");
//		Employee.setFirstName("Bùi");
//		Employee.setLastName("Tuấn Anh");
//		Employee.setCreateDate(null);
//		repository.createEmployee(Employee);
	}
}