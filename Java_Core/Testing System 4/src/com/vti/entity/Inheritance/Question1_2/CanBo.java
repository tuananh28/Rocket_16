package com.vti.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class CanBo {
	private String Hoten;
	private byte Tuoi;
	private String gioiTinh;
	private String DiaChi;
	private Scanner sc;

	public CanBo() {
	}

	public String getHoten() {
		return Hoten;
	}

	public int getTuoi() {
		return Tuoi;
	}
	
	public String getgioiTinh() {
		return gioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void Input() {
		sc = new Scanner(System.in);
		System.out.print("Họ tên : ");
		Hoten = sc.nextLine();
		System.out.print("Tuổi : ");
		Tuoi = Byte.parseByte(sc.nextLine());
		System.out.print("Giới Tính : ");
		gioiTinh = sc.nextLine();
		System.out.print("Địa Chỉ : ");
		DiaChi = sc.nextLine();
	}

	public void Output() {
		System.out.println("\nHọ tên : " + Hoten);
		System.out.println("Tuổi : " + Tuoi);
		System.out.println("Giới Tính : " + gioiTinh);
		System.out.println("Địa Chỉ : " + DiaChi);
	}

}
