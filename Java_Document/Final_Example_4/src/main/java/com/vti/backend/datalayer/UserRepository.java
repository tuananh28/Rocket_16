package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee.ProSkill;
import com.vti.Ultis.jdbcUltis;
import com.vti.entity.User;

public class UserRepository implements IUserRepository {
	private jdbcUltis jdbc;

	public UserRepository() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		jdbc = new jdbcUltis();
	}

	public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE Email = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean isLoginAdmin(String email, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `User` WHERE Email = (?) AND Password = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean isLoginEmployee(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE Email = (?) AND Password = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		String sql = "SELECT UserID, FullName, Email FROM `User`";
		List<User> listUser = new ArrayList<User>();
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			System.out.println(resultSet.getInt("UserID"));
			System.out.println(resultSet.getString("FullName"));
			System.out.println(resultSet.getString("Email"));
			listUser.add(user);
		}
		return listUser;

	}

	public List<User> getUserByID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE UserID = (?)";
		List<User> listusers = new ArrayList<User>();
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			System.out.println(resultSet.getInt("UserID"));
			System.out.println(resultSet.getString("FullName"));
			System.out.println(resultSet.getString("Email"));
			listusers.add(user);
		}
		return listusers;
	}

	public boolean deleteUserByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM `User` WHERE UserID = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		if (preparedStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		}else {
			jdbc.disConnection();
			return false;
		}		
	}

	public boolean createEmployee(String fullName, String email, ProSkill proskill) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `User` (FullName,Email,Password,ProSkill,   Role   )"
					+"VALUES			 ( 	  (?) ,	(?) ,'123456',   (?)  ,'EMPLOYEE')";
		
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, fullName);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3,proskill.toString());
		if (preparedStatement.executeUpdate()==1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
}
