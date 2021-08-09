package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;

import ultis.jdbcUltis;

public class AccountRespository implements IAccountRespository {
	private jdbcUltis jdbc;

	public AccountRespository() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		jdbc = new jdbcUltis();
	}

	public List<Account> getListEmployeeInProject(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "SELECT ap.ProjectID, p.ProjectName, p.TeamSize, ap.AccountID, a.Email, a.FullName, a.ExpInYear, a.ProSkill, a.Category\r\n"
				+ "FROM AccountProject ap\r\n" 
				+ "INNER JOIN `Account` a ON ap.AccountID = a.AccountID\r\n"
				+ "INNER JOIN Project p ON ap.ProjectID = p.ProjectID\r\n" 
				+ "WHERE ap.ProjectID = (?);";
		List<Account> listAccounts = new ArrayList<Account>();
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Account account = new Account();
			account.setID(resultSet.getInt("AccountID"));
			account.setEmail(resultSet.getString("Email"));
			account.setFullName(resultSet.getString("FullName"));
			listAccounts.add(account);
		}
		return listAccounts;

	}

	public List<Account> getListManagersInProject() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Account> listAccounts = new ArrayList<Account>();
		String sql = "SELECT AccountID, Email, FullName FROM `Account` WHERE Category = 'MANAGER';";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Account account = new Account();
			account.setID(resultSet.getInt("AccountID"));
			account.setEmail(resultSet.getString("Email"));
			account.setFullName(resultSet.getString("FullName"));
			listAccounts.add(account);
		}
		return listAccounts;

	}

	public boolean isLogin(String email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `Account` WHERE Email = (?) AND Password = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, Password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
}
