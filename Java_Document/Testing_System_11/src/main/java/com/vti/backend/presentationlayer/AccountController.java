package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.entity.Account;

public class AccountController {
	private AccountService  service;
	public AccountController() throws FileNotFoundException, IOException {
		service = new AccountService();
	}
	public List<Account>getListAccounts() throws ClassNotFoundException, SQLException, IOException{
		return service.getListAccounts();
	}
}
