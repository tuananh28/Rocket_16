package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.vti.entity.Department;

import ultis.ScannerUltis;

public class Ex2_CRUD {
	private Properties properties;
	public Ex2_CRUD() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(
				"D:\\Rocket_16\\Java_Document\\Testing System 10\\src\\resource\\database.properties"));
	}
	@SuppressWarnings("unused")
	public static void Question1() throws SQLException, IOException, ClassNotFoundException {
		List<Department> departments = new DepartmentDAO().getDepartments();

		for (Department department : departments) {
			System.out.println(department);
		}
	}

	public static void Question2_3() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUltis.inputInt();

		Department department = new DepartmentDAO().getDepartmentByID(id);
		System.out.println(department);
	}

	public static void Question4() throws Exception {
		System.out.println("Input department Name: ");
		String name = ScannerUltis.inputString();

		boolean result = new DepartmentDAO().isDepartmentNameExists(name);
		System.out.println("Result: " + result);
	}

	public static void Question5() throws Exception {
		System.out.println("Input department Name: ");
		String name = ScannerUltis.inputString();

		new DepartmentDAO().createDepartment(name);
		System.out.println("create success!");
	}

	public static void Question6() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUltis.inputInt();

		System.out.println("Input department new name: ");
		String newName = ScannerUltis.inputString();

		new DepartmentDAO().updateDepartment(id, newName);
		System.out.println("update success!");
	}

	public static void Question7() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUltis.inputInt();

		new DepartmentDAO().deleteDepartment(id);
		System.out.println("delete success!");
	}
}
