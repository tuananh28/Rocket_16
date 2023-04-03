package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Ex2_Polymorphism;

public class Frontend_Polymorphism {
	public static void main(String[] args) {
		Ex2_Polymorphism ex2 = new Ex2_Polymorphism();
		while (true) {

			System.out.println("===============Mời bạn chọn chức năng cần sử dụng===============");
			System.out.println("===            1. Question 1                                 ===");
			System.out.println("===            2. Question 2                                 ===");
			System.out.println("===            3. Question 3                                 ===");
			System.out.println("===            4. Question 4                                 ===");
			System.out.println("===            5. Question 5                                 ===");
			System.out.println("===            6. Exit                                       ===");
			System.out.println("================================================================");
			System.out.print("Mời bạn chọn chức năng: ");
			@SuppressWarnings("resource")
			int choose = new Scanner(System.in).nextInt();
			switch (choose) {
			case 1:
				ex2.Question1();
				break;
			case 2:
				ex2.Question2();
				break;
			case 3:
				ex2.Question3();
				break;
			case 4:
				ex2.Question4();
				break;
			case 5:
				ex2.Question5();
				break;
			case 6:
				System.out.println("Bạn đã thoát khỏi chương trình. ");
				return;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn nhập lại: ");
				break;
			}
		}
	}
}
