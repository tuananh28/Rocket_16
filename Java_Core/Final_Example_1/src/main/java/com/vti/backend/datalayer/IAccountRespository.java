package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRespository {
	public List<Account> getListEmployeeInProject(int id) throws SQLException, ClassNotFoundException;

	public List<Account> getListManagersInProject() throws ClassNotFoundException, SQLException;

	public boolean isLogin(String email, String Password) throws ClassNotFoundException, SQLException;

}
