package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.Ex2_Student;
import com.vti.ultis.ScannerUltis;

public class Ex2_Comparing {
	public static void Question1() {
		List<Ex2_Student> list = new ArrayList<Ex2_Student>();
		System.out.print("Số sinh viên cần nhập : ");
		int num = ScannerUltis.inputInt();
		for (int i = 0; i < num; i++) {
			System.out.println("Nhập thông tin Sinh Viên thứ"+(i+1));
			System.out.print("Họ và tên : ");
			String name = ScannerUltis.inputString();
			System.out.print("Ngày Sinh : ");
			LocalDate birthday = ScannerUltis.inputLocalDate();
			System.out.println("Nhập vào điểm : ");
			float mark = ScannerUltis.inputFloat();
			Ex2_Student ex2_Student = new Ex2_Student(name, birthday, mark);
			list.add(ex2_Student);
		}
		System.out.println("Danh sách sinh viên vừa nhập : ");
		for (Ex2_Student ex2_Student : list) {
			System.out.println(ex2_Student);
		}	
		while (true) {
			System.out.println("\t\t --- MENU --- \t\t");
			System.out.println("1. Comparable");
			System.out.println("2. Comparator");
			System.out.print("Nhập lựa chọn : ");
			int lc = ScannerUltis.inputInt();
			switch (lc) {
			case 1:
				Collections.sort(list);
				System.out.println("Danh sách sinh viên sau khi sắp xếp theo tên : ");
				for (Ex2_Student ex2_Student : list) {
					System.out.println(ex2_Student);
				}
				break;
			case 2:
				Collections.sort(list);
				System.out.println("Danh sách sinh viên sau khi sắp xếp theo tên, điểm, ngày sinh : ");
				for (Ex2_Student ex2_Student : list) {
					System.out.println(ex2_Student);
				}
				break;

			default:
				System.err.println("Mời nhập lại");
				break;
			}
		}
	}

}
