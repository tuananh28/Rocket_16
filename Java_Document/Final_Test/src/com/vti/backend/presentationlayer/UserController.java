package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.UserService;
import com.vti.entity.Employee.ProSkill;
import com.vti.entity.User;

public class UserController implements IUserController{
	private UserService userService;
	
	public UserController() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		userService = new UserService();
	}
	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.getListUser();
	}

	@Override
	public List<User> getUserByUserID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.getUserByUserID(id);
	}

	@Override
	public boolean isUserIdExists(int id) {
		// TODO Auto-generated method stub
		return userService.isUserIdExists(id);
	}

	@Override
	public boolean isEmailIfExist(String Email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.isEmailIfExist(Email);
	}

	@Override
	public boolean isLoginAdmin(String Email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.isLoginAdmin(Email, Password);
	}

	@Override
	public boolean isLoginEmployee(String Email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.isLoginEmployee(Email, Password);
	}

	@Override
	public boolean deleteUserByUserID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.deleteUserByUserID(id);
	}

	@Override
	public boolean createUserEmployee(String FullName, String Email, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.createUserEmployee(FullName, Email, proSkill);
	}
	
}
