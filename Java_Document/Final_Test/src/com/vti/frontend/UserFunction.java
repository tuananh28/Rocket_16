package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.entity.Employee.ProSkill;
import ultis.ScannerUltis;

public class UserFunction {
	private UserController userController;

	public UserFunction() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		userController = new UserController();
	}

	public void getListUser() throws ClassNotFoundException, SQLException {
		List<User> listUser = new ArrayList<User>();
		listUser = userController.getListUser();
		System.out.println("---------------------| Danh sách User |--------------------");
		String leftAlignFormat = "| %-2d | %-23s | %-26s |%n";
		System.out.format("+-----------------------------------------------------------+%n");
		System.out.format("| ID |         FullName        |           Email            |%n");
		System.out.format("+-----------------------------------------------------------+%n");
		for (User user : listUser) {
			System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail());
		}
		System.out.format("+-----------------------------------------------------------+%n");
	}

	public void getUserByUserID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập UserID: ");
		int id = ScannerUltis.inputIntPositive();
		List<User> listUser = new ArrayList<User>();
		listUser = userController.getUserByUserID(id);
		String leftAlignFormat = "| %-2d | %-23s | %-26s |%n";
		System.out.format("+-----------------------------------------------------------+%n");
		System.out.format("| ID |         FullName        |           Email            |%n");
		System.out.format("+-----------------------------------------------------------+%n");
		for (User user : listUser) {
			System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail());
		}
		System.out.format("+-----------------------------------------------------------+%n");
	}

	public void deleteUserByUserID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập UserID cần xóa: ");
		int id = ScannerUltis.inputIntPositive();
		if (userController.deleteUserByUserID(id)) {
			System.out.println("Xóa thành công UserID " + id + ". ");
		} else {
			System.out.println("Xóa không thành công. Mời bạn kiểm tra lại. ");
		}
	}

	public void getLoginAdmin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập Email: ");
		String emailAdmin = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password: ");
		String passwordAdmin = ScannerUltis.inputString();
		if (userController.isLoginAdmin(emailAdmin, passwordAdmin)) {
			System.out.println("Tài khoản " + emailAdmin + " đăng nhập thành công. Chúc bạn có một ngày vui vẻ. ");
			System.out.println("Xin chào Admin. ");
			System.out.println("Mời bạn nhập FullName: ");
			String newFullName = ScannerUltis.inputString();
			System.out.println("Mời bạn nhập Email: ");
			String newEmail = ScannerUltis.inputEmail();
			if (userController.isEmailIfExist(newEmail)) {
				System.out.println("Email đã tồn tại. ");
				return;
			}
			ProSkill proSkill = getProSkill();
			if (userController.createUserEmployee(newFullName, newEmail, proSkill)) {
				System.out
						.println("Tạo thành công. \nTài khoản của bạn là: \nEmail: " + newEmail + "\nPassword: 123456");
			} else {
				System.out.println("Tạo không thành công. Mời bạn kiểm tra lại. ");
			}
		}
	}

	private ProSkill getProSkill() {
		while (true) {
			String leftAlignFormat = "| %-43s |%n";
			System.out.format("+---------------------------------------------+%n");
			System.out.format("|                 Choose please               |%n");
			System.out.format("+---------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. DEV ");
			System.out.format(leftAlignFormat, "2. TEST ");
			System.out.format(leftAlignFormat, "3. JAVA ");
			System.out.format(leftAlignFormat, "4. SQL ");
			System.out.format("+---------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return ProSkill.DEV;
			case 2:
				return ProSkill.TEST;
			case 3:
				return ProSkill.JAVA;
			case 4:
				return ProSkill.SQL;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn nhập lại: ");
				break;
			}
		}
	}

	public void getLoginEmployee() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập Email: ");
		String emailEmployee = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password: ");
		String passwordEmployee = ScannerUltis.inputPassword();
		if (userController.isLoginEmployee(emailEmployee, passwordEmployee)) {
			System.out.println("Tài khoản " + emailEmployee + " đăng nhập thành công. ");
		} else {
			System.out.println("Đăng nhập thất bại. Xin vui lòng kiểm tra lại. ");
		}
	}
}
