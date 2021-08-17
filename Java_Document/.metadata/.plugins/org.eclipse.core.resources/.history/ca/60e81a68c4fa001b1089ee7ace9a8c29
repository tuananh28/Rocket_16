package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.AccountService;
import com.vti.entity.Account;

public class AccountController implements IAccountController{
	AccountService accountService;
	 private Account currUser;
	public AccountController() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		accountService =  new AccountService();
	}
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isEmailIfExists(email);
	}

	public boolean isLoginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isLoginAdmin(email, password);
	}

	public boolean createAccountByAdmin(String fullName, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.createAccountByAdmin(fullName, email);
	}

	public boolean isLoginUser(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isLoginUser(email, password);
	}

	public List<Account> getListMemberByProjectName(String projectName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.getListMemberByProjectName(projectName);
	}
	public boolean deleteAccountByAdmin(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.deleteAccountByAdmin(id);
	}
	public boolean updateAccountByAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccountByAdmin(email, password);
	}
	public Account logout(){
        currUser = null;
        return currUser;
    }

}
