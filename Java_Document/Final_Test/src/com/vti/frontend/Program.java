package com.vti.frontend;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import ultis.ScannerUltis;
public class Program {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			UserFunction userFunction = new UserFunction();
			System.out.println("-----------| Mời bạn chọn chức năng |----------");
			String leftAlignFormat = "| %-43s |%n";
			System.out.format("+---------------------------------------------+%n");
			System.out.format("|                 Choose please               |%n");
			System.out.format("+---------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Get List User ");
			System.out.format(leftAlignFormat, "2. Get User By UserID ");
			System.out.format(leftAlignFormat, "3. Delete User By UserID ");
			System.out.format(leftAlignFormat, "4. Login Admin ");
			System.out.format(leftAlignFormat, "5. Login Employee ");
			System.out.format(leftAlignFormat, "6. Exit ");
			System.out.format("+---------------------------------------------+%n");
			System.out.println("Mời bạn chọn chức năng: ");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				userFunction.getListUser();
				break;
			case 2:
				userFunction.getUserByUserID();
				break;
			case 3:
				userFunction.deleteUserByUserID();
				break;
			case 4:
				userFunction.getLoginAdmin();
				break;
			case 5:
				userFunction.getLoginEmployee();
				break;
			case 6:
				return;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn nhập lại: ");
				break;
			}
		}
	}
}