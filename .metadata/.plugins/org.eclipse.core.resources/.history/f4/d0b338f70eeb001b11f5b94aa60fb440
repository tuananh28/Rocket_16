package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.vti.entity.Department;

import ultis.jdbcUltis;

public class DepartmentDAO {
	private jdbcUltis jdbc;

	public DepartmentDAO() throws SQLException, FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Department> getDepartments()
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		// Tạo method để lấy ra danh sách tất cả các Department

			List<Department> departments = new ArrayList<>();

			// Step 2: get connection
			Connection connection = jdbc.getConnection();

			// Step 3: Create a statement object
			Statement statement = connection.createStatement();

			// Step 4: execute query
			String sql = "SELECT * FROM Department";
			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: handling result set
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentId"));
				department.setName(resultSet.getString("DepartmentName"));

				departments.add(department);
			}

			// disconnect
			jdbc.disConnection();

			return departments;
		}
	public Department getDepartmentByID(int id) throws Exception {

		// get connection
		Connection connection = jdbc.getConnection();

		// Create a statement object
		String sql = "SELECT * FROM Department WHERE DepartmentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			jdbc.disConnection();
			return department;

		} else {
			jdbc.disConnection();
			System.out.println("Lỗi !!!");
		}
		return null;
	}


	public boolean isDepartmentNameExists(String name) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		Connection connection = jdbc.getConnection();

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public void createDepartment(String name) throws Exception {

		// check name exist
		if (isDepartmentNameExists(name)) {
			System.out.println("Department name is Exist");
		}

		// get connection
		Connection connection = jdbc.getConnection();

		// if not exist
		// Create a statement object
		String sql = "	INSERT INTO Department (DepartmentName)" + "	VALUE				(   ?	)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		preparedStatement.executeUpdate();

		// disconnect
		jdbc.disConnection();
	}

	public boolean isDepartmentIdExists(int id) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		Connection connection = jdbc.getConnection();

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;

		} else {
			jdbc.disConnection();
			return false;
		}
	}
	public void updateDepartment(int id, String newName) throws SQLException, Exception {

		// check department id exist
		if (!isDepartmentIdExists(id)) {
			System.out.println("Không tồn tại DepartmentID "+id);
		}

		// if department name not exist update

		// get connection
		Connection connection = jdbc.getConnection();

		// Create a statement object
		String sql = "	UPDATE Department SET DepartmentName = ? WHERE DepartmentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);

		// Step 4: execute query
		preparedStatement.executeUpdate();

		// disconnect
		jdbc.disConnection();
	}

	public void deleteDepartment(int id) throws Exception {

		// check department id exist
		if (!isDepartmentIdExists(id)) {
			System.out.println("Không tồn tại DepartmentID "+id);
		}

		// if department id not exist delete

		// get connection
		Connection connection = jdbc.getConnection();

		// Create a statement object
		String sql = "DELETE FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		preparedStatement.executeUpdate();

		// disconnect
		jdbc.disConnection();
	}
}
