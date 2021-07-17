package com.vti.entity.Inheritance.Question3;

import java.util.Scanner;

public class TapChi extends TaiLieu{
	int SoPhatHanh;
	byte ThangPhatHanh;
	private Scanner scanner;
	public int getSoPhatHanh() {
		return SoPhatHanh;
	}
	public void setSoPhatHanh(int soPhatHanh) {
		SoPhatHanh = soPhatHanh;
	}
	public byte getThangPhatHanh() {
		return ThangPhatHanh;
	}
	public void setThangPhatHanh(Byte thangPhatHanh) {
		ThangPhatHanh = thangPhatHanh;
	}
	
	public void Input() {
		super.Input();
		scanner = new Scanner(System.in);
		System.out.print("Số phát hành : ");
		SoPhatHanh = Integer.parseInt(scanner.nextLine());
		System.out.print("Tháng Phát Hành : ");
		ThangPhatHanh = scanner.nextByte();	
	}
	public void Output() {
		super.Output();
		System.out.println("Số phát hành : "+SoPhatHanh);
		System.out.println("Tháng Phát Hành : "+ThangPhatHanh);
	}
}
