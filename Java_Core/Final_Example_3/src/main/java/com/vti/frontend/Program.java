package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.Ultis.ScannerUltis;

public class Program {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		CandidateFunction candidateFunction = new CandidateFunction();
		while (true) {
			System.out.println("\t\t --- MENU --- \t\t");
			System.out.println("\t 1. Login");
			System.out.println("\t 2. Register");
			System.out.println("\t 3. Exit");
			System.out.print("Mời bạn nhập lựa chọn : ");
			int lc = ScannerUltis.inputInt();
			switch (lc) {
			case 1:
				candidateFunction.getLogin();
				break;
			case 2:
				candidateFunction.getRegister();
				break;
			case 3:
				System.exit(lc);
			default:
				System.err.println("Mời bạn nhập lại !!!");
				break;
			}
		}
	}
}
