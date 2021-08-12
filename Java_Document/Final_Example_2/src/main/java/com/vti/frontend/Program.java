package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Ultis.ScannerUltis;

public class Program {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			AccountFuction accountFunction = new AccountFuction();
			System.out.println("-----------| Mời bạn chọn chức năng |----------");
			String leftAlignFormat = "| %-43s |%n";
			System.out.format("+---------------------------------------------+%n");
			System.out.format("|                 Choose please               |%n");
			System.out.format("+---------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Login  ");
			System.out.format(leftAlignFormat, "2. Exit ");
			System.out.format("+---------------------------------------------+%n");
			System.out.print("Mời bạn chọn chức năng: ");
			int lc = ScannerUltis.inputInt();
			switch (lc) {
			case 1:
				accountFunction.getLogin();
				break;
			case 2:
				System.out.println("Good Bye !");
				return;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn nhập lại: ");
				break;
			}
		}
	}
}
