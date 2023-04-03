package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Ultis.ScannerUltis;

public class Program {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		UserFunction userFunction = new UserFunction();
		while (true) {
			
			System.out.println("\t\t --- MENU --- \t\t");
			System.out.println("1. Login ");
			System.out.println("2. Create User");
			System.out.println("3. Get List User");
			System.out.println("4. Get User By ID");
			System.out.println("5. Delete User By ID");
			System.out.println("6. Exit");
			System.out.print("Mời bạn nhập chức năng : ");
			int lc = ScannerUltis.inputInt();
			switch (lc) {
			case 1:
				userFunction.Login();
				break;
			case 2:
				userFunction.getCreateUser();
				break;
			case 3:
				userFunction.getListUser();
				break;
			case 4:
				userFunction.getUserByID();
				break;
			case 5:
				userFunction.getDeleteUserByID();
				break;
			case 6:
				System.exit(lc);
				return;
			default:
				System.err.println("Nhập lại !!!");
				break;
			}

		}
	}
}
