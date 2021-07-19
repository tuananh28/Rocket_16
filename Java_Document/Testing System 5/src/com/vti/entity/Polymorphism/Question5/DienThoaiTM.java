package com.vti.entity.Polymorphism.Question5;

public class DienThoaiTM extends Dienthoai{

	@Override
	public void TanCong() {
		System.out.println("Sợ hỏng không dám ném");
		
	}
	public void Sudung3G() {
		System.out.println("Sử dụng 3G...");
	}
	
	public void Chuphinh() {
		System.out.println("Chụp hình...");
	}
}
