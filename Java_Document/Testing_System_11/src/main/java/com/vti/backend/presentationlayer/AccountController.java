package com.vti.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService service;

	public AccountController() throws IOException {
		service = new AccountService();
	}

	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return service.getListAccounts();
	}

	public Account getAccountByID(int id) throws Exception {
		return service.getAccountByID(id);
	}

	public void createAccount(String email, String username, String fullName) throws Exception {
		service.createAccount(email, username, fullName);
	}

	public void updateAccountByID(int id, String username) throws Exception {
		service.updateAccountByID(id, username);
	}

	public void deleteAccount(int id) throws Exception {
		service.deleteAccount(id);
	}

	public boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException {
		return service.isAccountExists(username);
	}

	public boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException {
		return service.isAccountExists(id);
	}

}
