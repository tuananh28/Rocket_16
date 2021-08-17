package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.Ultis.ScannerUltis;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.backend.presentationlayer.Iview;
import com.vti.entity.Account;

public class AccountFuction implements Iview {
	AccountController accountController;
	public String Email;
	public String Password;

	public AccountFuction() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		accountController = new AccountController(this);
	}

	public void getLogin() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.print("Mời bạn nhập Email : ");
		Email = ScannerUltis.inputEmail();
		System.out.print("Mời bạn nhập Password : ");
		Password = ScannerUltis.inputPassword();
		accountController.isLogin(Email, Password);
	}

	public void getLoginAdmin() throws ClassNotFoundException, SQLException {
		System.out.println("Xin chào Admin, Chúc bạn ngày mới tốt lành ");
		while (true) {
			System.out.println("\t\t --- \t\t");
			System.out.println("1.Create User");
			System.out.println("2.Get List User");
			System.out.println("3.Delete User");
			System.out.println("4.Change Password");
			System.out.println("5.Log Out");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				System.out.println(" -- Thêm thông tin User -- ");
				System.out.print("FullName : ");
				String newName = ScannerUltis.inputString();
				System.out.print("Email : ");
				String newEmail = ScannerUltis.inputEmail();
				if (accountController.isEmailIfExists(newEmail)) {
					System.out.println("Email này đã tồn tại");
					break;
				}
				if (accountController.createAccountByAdmin(newName, newEmail)) {
					System.out.println("Thêm tài khoản thành công !!!");
					System.out.println("Thông tin tài khoản vừa tạo là : " + " FullName : " + newName + " Email : "
							+ newEmail + " Password : 123456");
					break;
				} else {
					System.err.println("Thêm tài khoản không thành công, vui lòng thử lại !");
					return;
				}
			case 2:
				System.out.print("Nhập tên Project : ");
				String name = ScannerUltis.inputString();
				List<Account> accounts = new ArrayList<Account>();
				accounts = accountController.getListMemberByProjectName(name);
				System.out.println("-----------------------------------------------------------------");
				System.out.printf("| %-10s | %-25s | %-20s | \n", "AccountID", " FullName", " Email");
				System.out.println("-----------------------------------------------------------------");
				for (Account account : accounts) {
					System.out.printf("| %-10s | %-25s | %-20s | \n", account.getAccountID(), account.getFullName(),
							account.getEmail());
					System.out.println("-----------------------------------------------------------------");
				}
				break;
			case 3:
				System.out.print("Mời bạn nhập AccountID cần xóa : ");
				int idDel = ScannerUltis.inputInt();
				if (accountController.deleteAccountByAdmin(idDel)) {
					System.out.println("Xóa thành công AccountID " + idDel);
				} else {
					System.err.println("Không thể xóa AccountID " + idDel);
				}
				break;
			case 4:
				while (true) {
					System.out.print("Nhập Password mới : ");
					String passwordNew = ScannerUltis.inputPassword();
					passwordNew = ScannerUltis.toMD5(passwordNew);
					if (passwordNew.equals(Password)) {
						System.out.println("Nhập mật khẩu khác ban đầu mới được bạn nhé !");
						continue;
					} else if (accountController.updateAccount(Email, passwordNew)) {
						System.out.println("Cập nhật Password mới thành Công !!");
						accountController.logout();
						System.out.println("Mời bạn đăng nhập lại .");
						return;
					} else {
						System.out.println("Update Fail !!");
					}
					break;
				}
			case 5:
				accountController.logout();
				System.out.println("Đăng xuất thành công");
				return;
			default:
				System.err.println("Thử lại ! ");
				break;
			}
		}
	}

	public void getLoginUser() throws ClassNotFoundException, SQLException {
		System.out.println(" chúc bạn ngày mới làm việc vui vẻ ");
		while (true) {
			System.out.println("\t\t --- \t\t");
			System.out.println("1.Keep Working");
			System.out.println("2.Change Password");
			System.out.println("3.Log Out");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				System.out.println("Working.......");
				break;
			case 2:
				while (true) {
					System.out.print("Nhập Password mới : ");
					String passwordNew = ScannerUltis.inputPassword();	
					passwordNew = ScannerUltis.toMD5(passwordNew);
					if (passwordNew.equals(Password)) {
						System.out.println("Nhập mật khẩu khác ban đầu mới được bạn nhé !");
						continue;
					} else if (accountController.updateAccount(Email, passwordNew)) {
						System.out.println("Cập nhật Password mới thành Công !!");
						accountController.logout();
						System.out.println("Mời bạn đăng nhập lại .");
					} else {
						System.out.println("Update Fail !!");
					}
					break;
				}
			case 3:
				accountController.logout();
				System.out.println("Đăng xuất");
				return;
			default:
				System.err.println("Nhập lại ! ");
				break;
			}
		}
	}
}
