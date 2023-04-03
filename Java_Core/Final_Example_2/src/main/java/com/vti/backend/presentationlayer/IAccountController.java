package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountController {
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException;

	public boolean isLogin(String email, String password)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

//	public boolean isLoginUser(String email, String password) throws ClassNotFoundException, SQLException;

	public boolean createAccountByAdmin(String fullName, String email) throws ClassNotFoundException, SQLException;

	public boolean deleteAccountByAdmin(int id) throws ClassNotFoundException, SQLException;

	public boolean updateAccount(String email,String password) throws ClassNotFoundException, SQLException;

	public List<Account> getListMemberByProjectName(String projectName) throws ClassNotFoundException, SQLException;

	public void getAccountMode() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
}
