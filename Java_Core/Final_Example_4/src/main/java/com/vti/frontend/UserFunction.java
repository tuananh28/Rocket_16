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

	public void Login() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập Email: ");
		String userNameString = ScannerUltis.inputEmail();
		System.out.println("Nhập Password: ");
		String passwString = ScannerUltis.inputPassword();
		userController.Login(userNameString, passwString);

	}

	public void getCreateUser() throws ClassNotFoundException, SQLException {
		List<User> uList = new ArrayList<User>();
		uList = userController.getListUser();
		if (uList != null) {
			System.out.println("-- Thêm thông tin User ---");
			System.out.print("FullName : ");
			String newName = ScannerUltis.inputString();
			System.out.print("Email : ");
			String newEmail = ScannerUltis.inputEmail();
			if (userController.isEmailExist(newEmail)) {
				System.err.println("Email này đã tồn tại !");
				return;
			}
			System.out.println("ProSkill : ");
			ProSkill proSkill = getProSkill();
			userController.createEmployee(newName, newEmail, proSkill);
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

	public void getListUser() throws ClassNotFoundException, SQLException {
		List<User> uList = new ArrayList<User>();
		uList = userController.getListUser();
		if (uList != null) {
			System.out.printf("%-15s %-25s %-25s\n", "ID", "Fullname", "Email");
			for (User user : uList) {
				System.out.printf("%-15s %-25s %-25s\n", user.getUserID(), user.getFullName(), user.getEmail());
			}
		}
	}

	public void getUserByID() throws ClassNotFoundException, SQLException {
		System.out.print("Mời bạn nhập UserID : ");
		int id = ScannerUltis.inputIntPositive();
		List<User> listUser = new ArrayList<User>();
		listUser = userController.getListUserByID(id);
		System.out.printf("%-15s %-25s %-25s\n", "ID", "Fullname", "Email");
		for (User user : listUser) {
			System.out.printf("%-15s %-25s %-25s\n", user.getUserID(), user.getFullName(), user.getEmail());
		}
	}

	public void getDeleteUserByID() throws ClassNotFoundException, SQLException {
		List<User> uList = new ArrayList<User>();
		uList = userController.getListUser();
		if (uList != null) {
			System.out.println("Mời bạn nhập UserID cần xóa: ");
			int id = ScannerUltis.inputIntPositive();
			userController.deleteUserByID(id);

		}
	}
}
