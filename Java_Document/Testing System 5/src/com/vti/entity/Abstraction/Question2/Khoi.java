package com.vti.entity.Abstraction.Question2;


public class Khoi{
	private String Khoithi;
	private String Monthi;
	
	public String getMonthi() {
		if (Khoithi.equals("A")) {
			Monthi = "Toán, Lý, Hóa";
		}else if (Khoithi.equals("B")) {
			Monthi = "Toán, Hóa, Sinh";
		}else if (Khoithi.equals("C")) {
			Monthi = "Văn, Sử, Địa";
		}else {
			System.out.println("Không có khối thi này !");
		}
		return Monthi;
	}

	public String getKhoithi() {
		return Khoithi;
	}

	public void setKhoithi(String khoithi) {
		Khoithi = khoithi;
	}

	public void setMonthi(String monthi) {
		Monthi = monthi;
	}	
}
