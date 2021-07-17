package com.vti.entity.Inheritance;

import java.util.Scanner;

public class Bao extends TaiLieu{
	byte NgayPhatHanh;
	private Scanner scanner;
	
	public byte getNgayPhatHanh() {
		return NgayPhatHanh;
	}
	public void setNgayPhatHanh(byte NgayPhatHanh) {
		this.NgayPhatHanh = NgayPhatHanh;
	}
	
	public void Input() {
		super.Input();
		scanner = new Scanner(System.in);
		System.out.print("Ngày Phát Hành : ");
		NgayPhatHanh = scanner.nextByte();
	}
	public void Output() {
		super.Output();
		System.out.println("Ngày Phát Hành : "+NgayPhatHanh);
	}
}
