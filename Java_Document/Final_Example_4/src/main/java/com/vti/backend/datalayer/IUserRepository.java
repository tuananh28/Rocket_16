package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee.ProSkill;
import com.vti.entity.User;

public interface IUserRepository {
	public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException;

	public String Login(String email, String password) throws ClassNotFoundException, SQLException;

	public List<User> getListUser() throws ClassNotFoundException, SQLException;

	public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException;
	
	public int deleteUserByID(int id) throws ClassNotFoundException, SQLException;

	public String createEmployee(String fullName, String email, ProSkill proskill)
			throws ClassNotFoundException, SQLException;
}
