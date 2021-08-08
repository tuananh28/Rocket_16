package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.Ultis.ScannerUltis;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

public class AccountFuction {
	AccountController accountController;
	public AccountFuction() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
	accountController = new AccountController();
	}
	public void getLoginAdmin() throws ClassNotFoundException, SQLException {
		System.out.print("Mời bạn nhập Email : ");
		String emailAdmin = ScannerUltis.inputEmail();
		System.out.print("Mời bạn nhập Password : ");
		String passwordAdmin = ScannerUltis.inputString();
		if (accountController.isLoginAdmin(emailAdmin, passwordAdmin)) {
			System.out.println("Xin chào Admin, Chúc bạn ngày mới tốt lành ");
			System.out.println(" -- Thêm thông tin User -- ");
			System.out.print("FullName : ");
			String newName = ScannerUltis.inputString();
			System.out.print("Email : ");
			String newEmail = ScannerUltis.inputEmail();
			if (accountController.isEmailIfExists(newEmail)) {
				System.out.println("Email này đã tồn tại");
				return;
			}
			if (accountController.createAccountByAdmin(newName, newEmail)) {
				System.out.println("Thêm tài khoản thành công !!!");
				System.out.println("Thông tin tài khoản vừa tạo là : "
						+"FullName : "+newName
						+"Email : "+newEmail
						+"Password : 1234567");	
				return;
			}else {
				System.err.println("Thêm tài khoản không thành công, vui lòng thử lại !");
				return;
			}
		}
	}
	public void getLogin() throws ClassNotFoundException, SQLException {
		System.out.print("Mời bạn nhập Email : ");
		String emailUser = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password : ");
		String PasswordUser = ScannerUltis.inputString();
		if (accountController.isLoginUser(emailUser, PasswordUser)) {
			System.out.println("Chào bạn "+ emailUser + " chúc bạn ngày mới làm việc vui vẻ ");
		} else {
			System.err.println("Tài khoản hoặc mật khẩu sai, vui lòng thử lại !!");
		}
	}
	public void getListMemberByProjectName() throws ClassNotFoundException, SQLException {
		new ArrayList<Account>();
		System.out.println("-- Project Name ---");
		System.out.println("1. Project DEV");
		System.out.println("2. Project TEST");
		System.out.println("3. Project JAVA");
		System.out.println("4. Project SQL");
		System.out.println("Bạn đang cần tìm người ở dự nào ? Bạn vui lòng nhập đầy đủ tên 1 trong 4 Project trên nhé !");
		String name = ScannerUltis.inputString();
		accountController.getListMemberByProjectName(name);
	}
}
