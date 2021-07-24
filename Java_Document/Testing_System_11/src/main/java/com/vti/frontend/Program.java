package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		AccountController accountController = new AccountController();
		List<Account>accounts = accountController.getListAccounts();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
}
