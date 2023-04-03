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
	 Iview iview;
	public AccountController(Iview iview) throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		accountService =  new AccountService();
		this.iview = iview;
	}
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isEmailIfExists(email);
	}

	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (!accountService.isLogin(email, password)) {
			System.out.println("Tài khoản hoặc mật khẩu sai !");
			return false;
		}
		// login success
		getAccountMode();
		return accountService.isLogin(email, password);
	}

	public boolean createAccountByAdmin(String fullName, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.createAccountByAdmin(fullName, email);
	}

//	public boolean isLoginUser(String email, String password) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return accountService.isLoginUser(email, password);
//	}

	public List<Account> getListMemberByProjectName(String projectName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.getListMemberByProjectName(projectName);
	}
	public boolean deleteAccountByAdmin(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.deleteAccountByAdmin(id);
	}
	public boolean updateAccount(String email,String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccount(email,password);
	}
	public Account logout(){
        currUser = null;
        return currUser;
    }
	public void getAccountMode() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		if(accountService.getAccountMode()==1) {
			iview.getLoginAdmin();
		}else {
			iview.getLoginUser();
		}	
	}
}
