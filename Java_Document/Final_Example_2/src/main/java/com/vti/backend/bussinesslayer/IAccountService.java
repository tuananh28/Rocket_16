package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException;

	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException;

//	public boolean isLoginUser(String email, String password) throws ClassNotFoundException, SQLException;

	public boolean createAccountByAdmin(String fullName, String email) throws ClassNotFoundException, SQLException;

	public boolean deleteAccountByAdmin(int id) throws ClassNotFoundException, SQLException;

	public boolean updateAccount(String email,String password) throws ClassNotFoundException, SQLException;

	public List<Account> getListMemberByProjectName(String projectName) throws ClassNotFoundException, SQLException;

	public int getAccountMode();
}
