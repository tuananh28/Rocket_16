package com.vti.backend;

import java.util.Scanner;


import com.vti.entity.Abstraction.Question1.VietnamesePhone;


public class Ex6_Abstraction {

	Scanner scanner = new Scanner(System.in);

	public void Question1() {

		int lc;
		VietnamesePhone vnPhone = new VietnamesePhone();
		while (true) {
			System.out.println("==============MENU=============");
			System.out.println("\t  1. InsertContact.");
			System.out.println("\t  2. RemoveContact.");
			System.out.println("\t  3. UpdateContact.");
			System.out.println("\t  4. SreachContact.");
			System.out.println("\t  5. PrintContact.");
			System.out.println("===============================");
			System.out.print("Đưa ra lựa chọn : ");
			lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.print("Nhập vào tên Liên Hệ : ");
				String name = scanner.next();
				System.out.print("Nhập vào số điện thoại : ");
				String phone = scanner.next();
				vnPhone.insertContact(name, phone);
				break;
			case 2:
				System.out.print("Nhập vào tên Liên Hiện Cần Xóa : ");
				String RemoveName = scanner.next();
				vnPhone.removeContact(RemoveName);
			case 3:
				System.out.print("Nhập tên cần Update : ");
				String nameUpdate = scanner.next();
				System.out.print("Nhập số Phone mới : ");
				String newPhone = scanner.next();
				vnPhone.updateContact(nameUpdate, newPhone);
				System.out.println("Kết quả: ");
				vnPhone.searchContact(nameUpdate);
				break;
			case 4:
				System.out.println("Nhập vào tên Contact cần tìm kiếm: ");
				String searchName = scanner.next();
				vnPhone.searchContact(searchName);
				break;
			case 5:
				vnPhone.printContact();
				return;
			default:
				System.out.println("Bạn nhập sai,Mời nhập lại !");
				break;
			}
		}
	}
}
