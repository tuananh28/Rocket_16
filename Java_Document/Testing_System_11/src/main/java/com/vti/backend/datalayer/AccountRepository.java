package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;

import ultis.jdbcUltis;

public class AccountRepository implements IAccountRepository {
	private jdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		List<Account> accounts = new ArrayList<Account>();
		Connection connection = jdbc.getConnection();
		@SuppressWarnings("unused")
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM `Account` ORDER BY AccountID";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountId"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"));
			accounts.add(account);
		}
		jdbc.disConnection();
		return accounts;
	}
	public Account getAccountByID(int id) throws Exception {
		Connection connection = jdbc.getConnection();
		String sql = "SELECT * FROM `Account` WHERE AccountID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("FullName"));
			jdbc.disConnection();
			return account;
		} else {
			jdbc.disConnection();
			System.out.println("Không tìm thấy id" + id);
		}
		return null;
	}

	public boolean isAccountNameExists(String username) throws SQLException, ClassNotFoundException {
		Connection connection = jdbc.getConnection();
		String sql = "SELECT * FROM `Account` WHERE Username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean isAccountIDExists(int id) throws SQLException, ClassNotFoundException {
		Connection connection = jdbc.getConnection();
		String sql = "SELECT * FROM `Account` WHERE AccountID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public void createAccount(String Email, String Username, String Fullname)
			throws ClassNotFoundException, SQLException {
		Connection connection = jdbc.getConnection();
		String sql = "INSERT INTO `Account` (Email, UserName, FullName) "
				+ "VALUES 				( (?) , 	(?) ,	(?)	  ) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Email);
		preparedStatement.setString(2, Username);
		preparedStatement.setString(3, Fullname);

		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			System.out.println("Create Complete !!");
		} else {
			jdbc.disConnection();
			System.out.println("Create False !!!");
		}
	}

	public void updateAccountByID(int id, String username) throws Exception {
		Connection connection = jdbc.getConnection();
		String sql = "UPDATE `Account` SET UserName = ? WHERE AccountID = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setInt(2, id);
		
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			System.out.println("Create Complete !!");
		} else {
			jdbc.disConnection();
			System.out.println("Create False !!!");
		}
			
	}

	public void deleteAccount(int id) throws Exception {
		Connection connection = jdbc.getConnection();
		String sql = "DELETE FROM `Account` WHERE AccountID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			System.out.println("Create Complete !!");
		} else {
			jdbc.disConnection();
			System.out.println("Create False !!!");
		}
	}
}
