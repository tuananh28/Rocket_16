package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;
import com.vti.entity.Car.Engine;
import com.vti.entity.NgayThangNam;
import com.vti.entity.NgayThangNam.GioPhutGiay;
import com.vti.entity.OuterClass;

public class Ex3_InnerClass {
	public static void Question1() {
		CPU cpu = new CPU(800);
		CPU.Processor processor = cpu.new Processor(8, "Intel");
		CPU.Ram ram = cpu.new Ram(16, "SamSung");
		System.out.println("Khởi tạo CPU --- > OK");

		System.out.println("In thông tin Processor : ");
		System.out.println("Cache Processor : " + processor.getCache());
		System.out.println("Clock Speed Ram : " + ram.getClockSpeed());
	}

	public static void Question2() {
		Car car = new Car("Mazda", "8WD");
		Engine engine = car.new Engine("Crysler");

		System.out.println("Engine Type : " + engine);
	}

	public static void Question3() {
		OuterClass outerClass = new OuterClass();
		outerClass.show();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.show();
	}

	public static void Question4() {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;
		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 30;
		time.xuatThongTin();
	}
}
