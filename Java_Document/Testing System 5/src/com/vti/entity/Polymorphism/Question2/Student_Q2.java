package com.vti.entity.Polymorphism.Question2;

import java.util.Scanner;

public class Student_Q2 extends Person{
	private String MSV;
	private float  AVGMark;
	private String Email;
	private Scanner scanner = new Scanner(System.in);
	
	public float getAVGMark() {
		return AVGMark;
	}
	public void inputInfo() {
		super.inputInfo();
		System.out.print("Mã Sinh viên : ");
		this.MSV = scanner.nextLine();
		System.out.print("Điểm trung bình : ");
		this.AVGMark = Float.parseFloat(scanner.nextLine());
		System.out.print("Email : ");
		this.Email = scanner.nextLine();
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Mã Sinh viên : "+MSV);
		System.out.println("Điểm trung bình : "+AVGMark);
		System.out.println("Email : "+Email);
	}
}
