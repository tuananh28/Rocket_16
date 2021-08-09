package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.Ultis.jdbcUltis;
import com.vti.entity.Employee.ProSkill;
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

	public String Login(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE Email = (?) AND Password = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			if (resultSet.getString("Role").equals("ADMIN")) {
				return "ADMIN";
			} else if (resultSet.getString("Role").equals("EMPLOYEE")) {
				return "EMPLOYEE";
			}
			return null;
		} else {
			return null;
		}
	}

	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		String sql = "SELECT UserID, FullName, Email FROM `User`";
		List<User> listUser = new ArrayList<User>();
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			user.setUserID(resultSet.getInt("UserID"));
			user.setFullName(resultSet.getString("FullName"));
			user.setEmail(resultSet.getString("Email"));
			listUser.add(user);
		};
		return listUser;
	}

	public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException {
		List<User> listusers = new ArrayList<User>();
		String sql = "SELECT * FROM `User` WHERE UserID = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User user = new User();
			user.setUserID(resultSet.getInt("UserID"));
			user.setFullName(resultSet.getString("FullName"));
			user.setEmail(resultSet.getString("Email"));		
			listusers.add(user);
		}
		return listusers;
	}

	public int deleteUserByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM `User` WHERE UserID = (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		if (preparedStatement.executeUpdate() == 1) {
			System.out.println("Xóa thành công UserID " + id + ". ");
		} else {
			System.out.println("Xóa không thành công. Mời bạn kiểm tra lại. ");
		}
		return id;

	}

	public String createEmployee(String fullName, String email, ProSkill proskill)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `User` (FullName,Email,Password,ProSkill,   Role   )"
					+ "VALUES			 ( 	  (?) ,	(?) ,'123456',   (?)  ,'EMPLOYEE')";

		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, fullName);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, proskill.toString());
		if (preparedStatement.executeUpdate() == 1) {
			System.out.println("Create Success !!!");
		} else {
			System.out.println("Create fail !!");
		}
		return null;
	}
}
