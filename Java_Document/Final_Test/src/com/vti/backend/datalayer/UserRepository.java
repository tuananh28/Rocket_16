package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee.ProSkill;

import ultis.jdbcUltis;

import com.vti.entity.User;

public class UserRepository implements IUserRepository {
	private jdbcUltis jdbc;
	List<User> listUsers = new ArrayList<User>();

	public UserRepository() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		jdbc = new jdbcUltis();
	}

	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User`";
		PreparedStatement preSatement = jdbc.createPrepareStatement(sql);
		ResultSet resultSet = preSatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setFullName(resultSet.getNString(2));
			user.setEmail(resultSet.getString(3));
			listUsers.add(user);
		}
		;
		return listUsers;
	}

	@Override
	public List<User> getUserByUserID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `User` WHERE UserID = (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setFullName(resultSet.getNString(2));
			user.setEmail(resultSet.getString(3));
			listUsers.add(user);
		}
		;

		return listUsers;
	}

	@Override
	public boolean isUserIdExists(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmailIfExist(String Email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `User` WHERE Email = (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, Email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean isLoginAdmin(String Email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `User` WHERE Email = (?) AND Password = (?) AND Category = 'ADMIN';";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, Email);
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

	@Override
	public boolean isLoginEmployee(String Email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `User` WHERE Email = ? AND Password = ? AND Category = 'EMPLOYEE';";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, Email);
		preStatement.setString(2, Password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean deleteUserByUserID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `User` WHERE UserID = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		if (preStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createUserEmployee(String FullName, String Email, ProSkill proSkill)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `User` (FullName, Email, Password, ProSkill, Category)"
				+ "VALUES (?, ?, '123456', ?, 'EMPLOYEE');";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, FullName);
		preStatement.setString(2, Email);
		preStatement.setString(3, proSkill.toString());
		if (preStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
}
