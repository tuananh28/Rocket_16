package com.vti.backend;

import com.vti.entity.Employees;
import com.vti.entity.Ex3_Student;
import com.vti.entity.Phone;

public class Ex3_Generic {
	public Ex3_Student<Integer> student1;
	public Ex3_Student<Float> student2;
	public Ex3_Student<Double> student3;

	private <T> void print(T a) {
		System.out.println(a);
	}

	private <T> void printArray(T[] a) {
		for (T x : a) {
			System.out.println(x);
		}
	}

	public void Question1() {
		student1 = new Ex3_Student<Integer>(1, "Tuấn Anh");

		student2 = new Ex3_Student<Float>(2.0f, "Tuấn Anh");

		student3 = new Ex3_Student<Double>(3.0, "Tuấn Anh");

	}

	public void Question2() {
		print(student1);
		print(student2);
		print(student3);
		print(1);
		print(2f);
		print(3d);
	}

	public void Question4() {
		Integer[] arrIntegers = { 0, 1, 2, 3, 4, 5 };
		Float[] arrFloats = { 5f, 7.5f, 9.9f };
		Double[] arrDoubles = { 2.8, 6.6, 9.6 };

		printArray(arrIntegers);
		printArray(arrFloats);
		printArray(arrDoubles);
	}

	public void Question5() {
		Integer[] salaryEmployee1 = { 1000, 1500, 2000 };
		Employees<Integer> employees = new Employees<Integer>("Tuấn Anh", salaryEmployee1);

		Float[] salaryEmployee2 = { 1000f, 1500f, 2000f };
		Employees<Float> employees2 = new Employees<Float>("Hoa Mai", salaryEmployee2);

		Double[] salaryEmployee3 = { 1000d, 1.500d, 2000d };
		Employees<Double> employees3 = new Employees<Double>("Ngọc Diễn", salaryEmployee3);

		print(employees);
		System.out.println("tháng lương cuối cùng của Employee 1 là : " + salaryEmployee1[salaryEmployee1.length - 1]);

		print(employees2);
		System.out.println("tháng lương cuối cùng của Employee 2 là : " + salaryEmployee2[salaryEmployee2.length - 1]);

		print(employees3);
		System.out.println("tháng lương cuối cùng của Employee 3 là : " + salaryEmployee3[salaryEmployee3.length - 1]);
	}
	
	public void Question6() {
		MyMap<Integer, String> student = new MyMap<Integer, String>(1, "Tuấn Anh");
		System.out.println("Thông tin sinh viên khởi tạo: " +student);
		System.out.println("Lấy value trong MyMap : "+student.getValue());
		System.out.println("Lấy key trong MyMap : "+student.getKey());
		
	}
	public void Question7() {
		//key là email
		Phone<String, String> phone1 = new Phone<String, String>("tuananh28@gmail.com", "0868 102 848");
		System.out.println("Thông tin Phone thứ 1"+phone1);
		System.out.println("Lấy SĐT trong Phone 1 : "+phone1.getPhoneNumber());
		System.out.println("Lấy Key trong Phone 1 : "+phone1.getKey());
		
		//key là số thứ tự
		Phone<Integer, String> phone2 = new Phone<Integer, String>(1, "0868 102 848");
		System.out.println("Thông tin Phone thứ 2"+phone2);
		System.out.println("Lấy SĐT trong Phone 2 : "+phone2.getPhoneNumber());
		System.out.println("Lấy Key trong Phone 2 : "+phone2.getKey());
		
		//key là tên của người sử dụng
		Phone<String, String> phone3 = new Phone<String, String>("Tuấn Anh", "0868 102 848");
		System.out.println("Thông tin Phone thứ 3"+phone3);
		System.out.println("Lấy SĐT trong Phone 3 : "+phone3.getPhoneNumber());
		System.out.println("Lấy Key trong Phone 3 : "+phone3.getKey());
	}
}
