package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRespository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private AccountRespository accountRespository;

	public AccountService() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		accountRespository = new AccountRespository();
	}

	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRespository.isLogin(email, password);
	}

	public List<Account> getListMemberInProject(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRespository.getListEmployeeInProject(id);
	}

	public List<Account> getListManagersInProject() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRespository.getListManagersInProject();
	}

}
