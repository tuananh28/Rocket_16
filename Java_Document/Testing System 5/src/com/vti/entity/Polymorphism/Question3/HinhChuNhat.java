package com.vti.entity.Polymorphism.Question3;

import java.util.Scanner;

public class HinhChuNhat {
	private float canha;
	private float canhb;
	private Scanner scanner = new Scanner(System.in);
	public Float tinhChuVi() {
		return 2*(getCanha()+ canhb);
	}
	public Float tinhDienTich() {
		return getCanha() * canhb;
	}
	
	public HinhChuNhat (Float canha, Float canhb) {
		super();
		this.setCanha(canha);
		this.canhb = canhb;
	}
	public HinhChuNhat() {
		// TODO Auto-generated constructor stub
	}
	public void input() {
		System.out.print("Nhập cạnh a : ");
		setCanha(scanner.nextFloat());
		System.out.print("Nhập cạnh b : ");
		canhb = scanner.nextFloat();
	}
	
	public void output() {
		System.out.println("Chu vi Hình Chữ Nhật là : "+tinhChuVi());
		System.out.println("Diện tích Hình Chữ Nhật là : "+tinhDienTich());
	}
	public float getCanha() {
		return canha;
	}
	public void setCanha(float canha) {
		this.canha = canha;
	}
}
