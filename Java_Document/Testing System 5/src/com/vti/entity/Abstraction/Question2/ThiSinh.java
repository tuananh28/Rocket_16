package com.vti.entity.Abstraction.Question2;

import java.util.Scanner;

public class ThiSinh{
	private String Sbd;
	private String Hoten;
	private String Diachi;
	private int Uutien;
	private Khoi khoi;
	private Scanner scanner;
	
	public String getSbd() {
		return Sbd;
	}


	public void setSbd(String sbd) {
		Sbd = sbd;
	}


	public String getHoten() {
		return Hoten;
	}


	public void setHoten(String hoten) {
		Hoten = hoten;
	}


	public String getDiachi() {
		return Diachi;
	}


	public void setDiachi(String diachi) {
		Diachi = diachi;
	}


	public int getUutien() {
		return Uutien;
	}


	public void setUutien(int uutien) {
		Uutien = uutien;
	}

	public void Input() {
		scanner = new Scanner(System.in);
		System.out.print("Số báo danh : ");
		Sbd = scanner.nextLine();
		System.out.print("Họ Tên : ");
		Hoten = scanner.nextLine();
		System.out.print("Địa chỉ : ");
		Diachi = scanner.nextLine();
		System.out.print("Mức ưu tiên : ");
		Uutien = Integer.parseInt(scanner.nextLine());
		System.out.print("Khối thi : ");
		khoi = new Khoi();
		khoi.setKhoithi(scanner.nextLine());
	}
	
	public void Output() {
		System.out.println("\nSố báo danh : "+Sbd);
		System.out.println("Họ Tên : "+Hoten);
		System.out.println("Địa chỉ : "+Diachi);
		System.out.println("Mức ưu tiên : "+Uutien);
		System.out.println("Khối thi :"+khoi.getKhoithi());
		System.out.println("Môn thi : "+khoi.getMonthi());
	}


	@Override
	public String toString() {
		return "\nSố báo danh : " + Sbd + 
				"\nHọ tên :" + Hoten + 
				"\nĐịa chỉ : " + Diachi + 
				"\nƯu tiên : " + Uutien + 
				"\nKhối thi : "+ khoi.getKhoithi() + 
				"\nMôn thi : "+khoi.getMonthi()+"";
	}
	
}
