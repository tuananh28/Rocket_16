package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee.ProSkill;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

public class UserService implements IUserService{
	private UserRepository userRepository;
	
	public UserService() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		userRepository = new UserRepository();
	}
	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getListUser();
	}

	@Override
	public List<User> getUserByUserID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserID(id);
	}

	@Override
	public boolean isUserIdExists(int id) {
		// TODO Auto-generated method stub
		return userRepository.isUserIdExists(id);
	}

	@Override
	public boolean isEmailIfExist(String Email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isEmailIfExist(Email);
	}

	@Override
	public boolean isLoginAdmin(String Email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isLoginAdmin(Email, Password);
	}

	@Override
	public boolean isLoginEmployee(String Email, String Password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isLoginEmployee(Email, Password);
	}

	@Override
	public boolean deleteUserByUserID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserByUserID(id);
	}

	@Override
	public boolean createUserEmployee(String FullName, String Email, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.createUserEmployee(FullName, Email, proSkill);
	}

}
