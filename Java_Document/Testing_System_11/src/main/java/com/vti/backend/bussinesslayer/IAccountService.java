package com.vti.backend.bussinesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {
	List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException;

	Account getAccountByID(int id) throws Exception;

	void createAccount(String email, String username, String fullName) throws Exception;

	void updateAccountByID(int id, String username) throws Exception;

	void deleteAccount(int id) throws Exception;

	boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException;

	boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException;
}