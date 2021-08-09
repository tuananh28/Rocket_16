package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.Ultis.ScannerUltis;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Employee.ProSkill;
import com.vti.entity.User;

public class UserFunction {
	UserController userController;

	public UserFunction() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		userController = new UserController();
	}

	public void getLoginAdmin() throws ClassNotFoundException, SQLException {
		System.out.print("Mời bạn nhập Email : ");
		String emailAD = ScannerUltis.inputEmail();
		System.out.print("Mời bạn nhập Password : ");
		String passwordAD = ScannerUltis.inputPassword();
		if (userController.isLoginAdmin(emailAD, passwordAD)) {
			System.out.println("Xin chào Admin , chúc bạn ngày mới tốt lành !");
			System.out.println("-- Thêm thông tin User ---");
			System.out.print("FullName : ");
			String newName = ScannerUltis.inputString();
			System.out.print("Email : ");
			String newEmail = ScannerUltis.inputEmail();
			if (userController.isEmailExist(newEmail)) {
				System.err.println("Email này đã tồn tại !");
			}
			System.out.println("ProSkill : ");
			ProSkill proSkill = getProSkill();
			if (userController.createEmployee(newName, newEmail, proSkill)) {
				System.out.println("Create Success !!");
			} else {
				System.out.println("Create False !!");
			}
		}
	}

	private ProSkill getProSkill() {
		while (true) {
			System.out.println("1.DEV");
			System.out.println("2.TEST");
			System.out.println("3.JAVA");
			System.out.println("4.SQL");
			System.out.print("Mời bạn chọn Proskill : ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				return ProSkill.DEV;
			case 2:
				return ProSkill.TEST;
			case 3:
				return ProSkill.JAVA;
			case 4:
				return ProSkill.SQL;
			default:
				System.err.println("Nhập lại !");
				break;
			}
		}
	}

	public void getLoginUser() throws ClassNotFoundException, SQLException {
		System.out.print("Mời bạn nhập Email : ");
		String emailAD = ScannerUltis.inputEmail();
		System.out.print("Mời bạn nhập Password : ");
		String passwordAD = ScannerUltis.inputPassword();
		if (userController.isLoginAdmin(emailAD, passwordAD)) {
			System.out.println("Xin chào bạn " + emailAD + ", chúc bạn ngày mới tốt lành !");
		}
	}
	public void getListUser() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<User>();
		list = userController.getListUser();
		System.out.println("---------------------| Danh sách User |--------------------");
		String leftAlignFormat = "| %-2d | %-23s | %-26s | %-15s |%n";
		System.out.format("+---------------------------------------------------------------------------+%n");
		System.out.format("| ID |         FullName        |           Email            |	  Role	   |%n");
		System.out.format("+---------------------------------------------------------------------------+%n");
		for (User user : list) {
			System.out.format(leftAlignFormat, user.getUserID(), user.getFullName(), user.getEmail(), user.getRole());
		}
		System.out.format("+---------------------------------------------------------------------------+%n");
	}
	public void getUserByID() throws ClassNotFoundException, SQLException {
		System.out.print("Nhập ID User bạn cần tìm : ");
		int id = ScannerUltis.inputInt();
		List<User> list = new ArrayList<User>();
		list = userController.getUserByID(id);
		System.out.println("---------------------| Danh sách User |--------------------");
		String leftAlignFormat = "| %-2d | %-23s | %-26s | %-15s |%n";
		System.out.format("+---------------------------------------------------------------------------+%n");
		System.out.format("| ID |         FullName        |           Email            |	  Role	   |%n");
		System.out.format("+---------------------------------------------------------------------------+%n");
		for (User user : list) {
			System.out.format(leftAlignFormat, user.getUserID(), user.getFullName(), user.getEmail(), user.getRole());
		}
		System.out.format("+---------------------------------------------------------------------------+%n");
	}
	public void getDeleteUserByID() throws ClassNotFoundException, SQLException {
		System.out.print("Nhập ID User bạn cần xóa : ");
		int id = ScannerUltis.inputInt();
		if (userController.deleteUserByID(id)) {
			System.out.println("Delete Success!!");
		} else {
			System.out.println("Delete False !!");
		}
		
	}
}
