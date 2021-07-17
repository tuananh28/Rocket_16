package com.vti.entity.Inheritance.Question3;

import java.util.Scanner;

public class TaiLieu {
	int MaTaiLieu;
	String NXB;
	int SoBanPhatHanh;
	private Scanner scanner;
	
	public TaiLieu() {
		// TODO Auto-generated constructor stub
	}

	public int getMaTaiLieu() {
		return MaTaiLieu;
	}

	public void setMaTaiLieu(int maTaiLieu) {
		MaTaiLieu = maTaiLieu;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public int getSoBanPhatHanh() {
		return SoBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		SoBanPhatHanh = soBanPhatHanh;
	}
	public void Input() {
		scanner = new Scanner(System.in);
		System.out.print("Mã tài liệu : ");
		MaTaiLieu = Integer.parseInt(scanner.nextLine());
		System.out.print("Tên Nhà Xuất Bản : ");
		NXB = scanner.nextLine();
		System.out.print("Số bản phát hành : ");
		SoBanPhatHanh = Integer.parseInt(scanner.nextLine());
	}
	
	public void Output() {
		System.out.println("\nMã tài liệu : "+MaTaiLieu);
		System.out.println("Tên Nhà Xuất Bản : "+NXB);
		System.out.println("Số bản phát hành : "+SoBanPhatHanh);
	}
}
