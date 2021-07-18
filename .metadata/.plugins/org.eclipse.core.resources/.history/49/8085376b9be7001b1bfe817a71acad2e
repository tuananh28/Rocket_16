package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Polymorphism.Question1.Student;

public class Ex2_Polymorphism {
	Random random = new Random();
	ArrayList<Student> list = new ArrayList<Student>();

	private void initStudent() {
		for (int i = 0; i < 10; i++) {
			Student st = new Student("Student " + (i + 1), random.nextInt(3) + 1);
			list.add(st);
		}
	}

	Scanner scanner = new Scanner(System.in);

	public void Question1() {
		while (true) {
			System.out.println("\t\t MENU \t\t");
			System.out.println("\t 1.Tạo 10 học sinh, chia thành 3 nhóm.");
			System.out.println("\t 2.Kêu gọi cả lớp điểm danh.");
			System.out.println("\t 3.Gọi nhóm 1 đi học bài.");
			System.out.println("\t 4.Gọi nhóm 2 đi dọn vệ sinh.");
			System.out.println("\t 5.Thoát.");
			System.out.println("\t\t\t ========= \t\t\t");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			int n = scanner.nextInt();
			switch (n) {
			case 1:
				initStudent();
				System.out.println("Tạo thành công 10 Sinh viên");
				break;
			case 2:
				System.out.println("Cả lớp điểm danh: ");
				for (Student student : list) {
					student.DiemDanh();
				}
				break;
			case 3:
				System.out.println("Nhóm 1 đi học bài: ");
				for (Student student : list) {
					if (student.getGroup() == 1) {
						student.HocBai();
					}
				}
				break;
			case 4:
				System.out.println("Nhóm 2 đi dọn vệ sinh: ");
				for (Student student : list) {
					if (student.getGroup() == 2) {
						student.DonVeSinh();
					}
				}
				break;
			case 5:
				System.out.println("Thoát chương trình !");
				return;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại : ");
				break;
			}
		}
	}
}
