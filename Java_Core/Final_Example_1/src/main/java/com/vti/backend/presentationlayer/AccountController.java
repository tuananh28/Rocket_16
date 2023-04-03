package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.AccountService;
import com.vti.entity.Account;

public class AccountController implements IAccountController {
	private AccountService accountService;

	public AccountController() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		accountService = new AccountService();
	}

	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isLogin(email, password);
	}

	public List<Account> getListMemberInProject(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.getListMemberInProject(id);
	}

	public List<Account> getListManagersInProject() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.getListManagersInProject();
	}

}
