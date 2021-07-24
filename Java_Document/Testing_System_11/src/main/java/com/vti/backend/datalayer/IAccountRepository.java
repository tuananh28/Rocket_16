package com.vti.backend.datalayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException;

	Account getAccountByID(int id) throws Exception;

	boolean isAccountNameExists(String username) throws ClassNotFoundException, SQLException, IOException;

	boolean isAccountIDExists(int id) throws ClassNotFoundException, SQLException, IOException;
	
	void createAccount(String email, String username, String fullName) throws Exception;

	void updateAccountByID(int id, String username) throws Exception;

	void deleteAccount(int id) throws Exception;

}
