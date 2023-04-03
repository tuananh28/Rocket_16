package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Employee.ProSkill;
import com.vti.entity.User;

public class UserService implements IUserService {
	UserRepository userRepository;
	boolean userAdminLogin = false;
	boolean userLogin = false;

	public UserService() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		userRepository = new UserRepository();
	}

	public boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.isEmailExist(email);
	}

	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		if (!userAdminLogin && !userLogin) {
			System.out.println("Phải đăng nhập mới sử dụng được chức năng này !");
			return null;
		}
		if (userAdminLogin) {
			return userRepository.getListUser();
		} else {
			System.out.println("Chỉ Admin mới được sử dụng phương thức này");
			return null;
		}
	}

	public List<User> getListUserByID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getListUserByID(id);
	}

	public int deleteUserByID(int id) throws ClassNotFoundException, SQLException {
		if (!userAdminLogin && !userLogin) {
			System.out.println("Phải đăng nhập mới sử dụng được chức năng này !");
		}
		if (userAdminLogin) {
			return userRepository.deleteUserByID(id);
		} else {
			System.out.println("Chỉ Admin mới được sử dụng phương thức này");
		}
		return 0 ;
	}

	public String createEmployee(String fullName, String email, ProSkill proskill)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		if (!userAdminLogin && !userLogin) {
			System.out.println("Phải đăng nhập mới sử dụng được chức năng này !");
			return null;
		}
		if (userAdminLogin) {
			return userRepository.createEmployee(fullName, email, proskill);
		} else {
			System.out.println("Chỉ Admin mới được sử dụng phương thức này");
			return null;
		}
	}

	public void Login(String email, String password) throws ClassNotFoundException, SQLException {

		userAdminLogin = false;
		userLogin = false;

		String user = "";
		user = userRepository.Login(email, password);

		if ("ADMIN".equals(user)) {
			userAdminLogin = true;
			System.out.println("Login in succeses user: " + user);
			return;
		} else if ("EMPLOYEE".equals(user)) {
			System.out.println("Login in succeses user: " + user);
			userLogin = true;
			return;
		}
		System.out.println("Login in fail");

	}
}
