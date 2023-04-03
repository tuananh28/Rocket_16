package com.vti.entity.Polymorphism.Question5;

public abstract class Dienthoai implements VuKhi{
	
	public void Nghe() {
		System.out.println("Đang nghe....");
	} 
	
	public void Goi() {
		System.out.println("Đang gọi....");
	} 
	public void GuiTinNhan() {
		System.out.println("Đang gửi tin nhắn....");
	} 
	public void NhanTinNhan() {
		System.out.println("Nhận tin nhắn....");
	} 
}
