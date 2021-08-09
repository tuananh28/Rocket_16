package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee.ProSkill;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

public class UserService implements IUserService{
	UserRepository userRepository;
	public UserService() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		userRepository = new UserRepository();
	}
	public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isEmailExist(email);
	}

	public boolean isLoginAdmin(String email, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.isLoginAdmin(email, password);
	}

	public boolean isLoginEmployee(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isLoginEmployee(email, password);
	}

	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getListUser();
	}

	public List<User> getUserByID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUserByID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createEmployee(String fullName, String email, ProSkill proskill)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
