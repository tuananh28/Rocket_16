package com.vti.entity;

public class NgayThangNam {
	public int ngay, thang, nam;

	public class GioPhutGiay {
		public int gio, phut, giay;

		public void xuatThongTin() {
			System.out.println("Ngày: " + ngay + " Tháng: " + thang + " Năm: " + nam);
			System.out.println("Giờ: " + gio + " Phút: " + phut + " Giây: " + giay);
		}
	}
}
