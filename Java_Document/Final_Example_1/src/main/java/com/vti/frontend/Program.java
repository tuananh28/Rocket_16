package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import ultis.ScannerUltis;

public class Program {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			AccountFuntion accountFuntion = new AccountFuntion();
			System.out.println("\t\t --- MENU --- \t\t");
			System.out.println("\t 1. Login");
			System.out.println("\t 2. Get List Account Member By Project");
			System.out.println("\t 3. Get List Account Manager In Project");
			System.out.println("\t 4. Exit");
			System.out.print("Mời bạn đưa ra lựa chọn : ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				accountFuntion.getLogin();
				break;
			case 2:
				accountFuntion.getListMemberByProjectID();
				break;
			case 3:
				accountFuntion.getListManagersInProject();
				break;
			case 4:
				return;
			default:
				System.err.println("Mời bạn nhập lại !!");
				break;
			}
		}
	}
}
