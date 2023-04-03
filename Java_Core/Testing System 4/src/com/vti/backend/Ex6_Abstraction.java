package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Abstraction.Question1.VietnamesePhone;
import com.vti.entity.Abstraction.Question2_3.Employee;
import com.vti.entity.Abstraction.Question2_3.Manager;
import com.vti.entity.Abstraction.Question2_3.Waiter;

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

	public void Question2_3() {
		while (true) {
			System.out.println("============MENU===========");
			System.out.println("\t 1.Add Employee.");
			System.out.println("\t 2.Add Manager.");
			System.out.println("\t 3.Add Waiter.");
			System.out.println("\t 4.Exit.");
			System.out.println("============================");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			int lc = scanner.nextInt();
			switch (lc) {
			case 1:
				System.out.print("Tên nhân viên : ");
				String eName = scanner.next();
				System.out.print("Salary Ratio : ");
				Double eSalary_Ratio = Double.parseDouble(scanner.nextLine());
				Employee employee = new Employee(eName, eSalary_Ratio);
				employee.displayInfor();
				break;
			case 2:
				System.out.print("Tên Quản lý : ");
				String mName = scanner.next();
				System.out.print("Salary Ratio : ");
				Double mSalary_Ratio = scanner.nextDouble();
				Manager manager = new Manager(mName, mSalary_Ratio);
				manager.displayInfor();
			case 3:
				System.out.print("Tên phục vụ : ");
				String wName = scanner.next();
				System.out.print("Salary Ratio : ");
				Double wSalary_Ratio = scanner.nextDouble();
				Waiter waiter = new Waiter(wName, wSalary_Ratio);
				waiter.displayInfor();
			case 4:
				return;
			default:
				System.out.println("Bạn nhập sai, mời nhập lại !");
				break;
			}
		}
	}
}
