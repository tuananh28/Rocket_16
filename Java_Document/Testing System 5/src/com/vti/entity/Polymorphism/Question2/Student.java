package com.vti.entity.Polymorphism.Question2;

import java.util.Scanner;

public class Student extends Person{
	private String MSV;
	private float  AVGMark;
	private String Email;
	private Scanner scanner;
	
	public void inputInfo() {
		super.inputInfo();
		System.out.println("Mã Sinh viên : ");
		MSV = scanner.nextLine();
		System.out.println("Điểm trung bình : ");
		AVGMark = scanner.nextFloat();
		System.out.println("Email : ");
		Email = scanner.nextLine();
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Mã Sinh viên : "+MSV);
		System.out.println("Điểm trung bình : "+AVGMark);
		System.out.println("Email : "+Email);
	}
	
	public boolean Scholarship() {
		return AVGMark > 8.0 ? true : false;
	}
}
