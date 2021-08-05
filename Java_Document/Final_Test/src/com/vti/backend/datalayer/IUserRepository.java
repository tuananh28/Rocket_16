package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;
import com.vti.entity.Employee.ProSkill;

public interface IUserRepository {
	public List<User> getListUser() throws ClassNotFoundException, SQLException;

	public List<User> getUserByUserID(int id) throws ClassNotFoundException, SQLException;

	public boolean isUserIdExists(int id);

	public boolean isEmailIfExist(String Email) throws ClassNotFoundException, SQLException;

	public boolean isLoginAdmin(String Email, String Password) throws ClassNotFoundException, SQLException;

	public boolean isLoginEmployee(String Email, String Password) throws ClassNotFoundException, SQLException;

	public boolean deleteUserByUserID(int id) throws ClassNotFoundException, SQLException;

	public boolean createUserEmployee(String FullName, String Email, ProSkill proSkill) throws ClassNotFoundException, SQLException;

}
