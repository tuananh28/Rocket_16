package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountController {
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException;

	public List<Account> getListMemberInProject(int id) throws ClassNotFoundException, SQLException;

	public List<Account> getListManagersInProject() throws ClassNotFoundException, SQLException;
}
