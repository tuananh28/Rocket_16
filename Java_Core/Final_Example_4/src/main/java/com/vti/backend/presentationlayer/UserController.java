package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.UserService;
import com.vti.entity.Employee.ProSkill;
import com.vti.entity.User;

public class UserController implements IUserController{
	UserService userService;
	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}
	public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.isEmailExist(email);
	}
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.getListUser();
	}
	public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.getListUserByID(id);
	}
	public int deleteUserByID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.deleteUserByID(id);
	}
	public String createEmployee(String fullName, String email, ProSkill proskill)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userService.createEmployee(fullName, email, proskill);
	}
	public void Login(String userNameString, String passwString) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		userService.Login(userNameString, passwString);
	}
	
}
