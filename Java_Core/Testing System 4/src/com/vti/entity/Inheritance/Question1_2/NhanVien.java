package com.vti.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class NhanVien extends CanBo{
	String CongViec;
	private Scanner scanner;
	
	public String getCongViec() {
		return CongViec;
	}

	public void setCongViec(String congViec) {
		CongViec = congViec;
	}
	
	public void Input() {
		super.Input();
		System.out.print("Công Việc : ");
		scanner = new Scanner(System.in);
		CongViec = scanner.nextLine();
	}
	public void Output() {
		super.Output();
		System.out.println("Công Việc : "+CongViec);
	}
}
