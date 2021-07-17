package com.vti.entity.Inheritance.Question3;

import java.util.Scanner;

public class Sach extends TaiLieu{
	String TenTG;
	int SoTrang;
	private Scanner scanner;
	public String getTenTG() {
		return TenTG;
	}
	public void setTenTG(String tenTG) {
		TenTG = tenTG;
	}
	public int getSoTrang() {
		return SoTrang;
	}
	public void setSoTrang(int soTrang) {
		SoTrang = soTrang;
	}
	
	public void Input() {
		super.Input();
		scanner = new Scanner(System.in);
		System.out.print("Tên Tác Giả : ");
		TenTG = scanner.nextLine();
		System.out.print("Số trang : ");
		SoTrang =  Integer.parseInt(scanner.nextLine());
	}
	public void Output() {
		super.Output();
		System.out.println("Tên Tác Giả : "+TenTG);
		System.out.println("Số trang : "+SoTrang);
	}
}
