package com.vti.test;

import java.util.List;

import com.vti.entity.Manager;
import com.vti.repository.ManagerRepository;

public class ManagerProgram {
	public static void main(String[] args) {
		ManagerRepository repository = new ManagerRepository();
		System.out.println("---------------- GET ALL ManagerS ----------------");
		List<Manager> list = repository.getAllManagers();
		for (Manager Manager : list) {
			System.out.println(Manager);
		}
//		System.out.println("---------------- CREATE ManagerS -----------------");
//		Manager Manager= new Manager();
//		Manager.setEmail("tuananh@gmail.com");
//		Manager.setUserName("tuananhbui");
//		Manager.setFirstName("Bùi");
//		Manager.setLastName("Tuấn Anh");
//		Manager.setCreateDate(null);
//		repository.createManager(Manager);
	}
}
