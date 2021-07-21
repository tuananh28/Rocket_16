package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_Basic {

	public void Question1() throws SQLException, ClassNotFoundException {
		final String url = "jdbc:mysql://localhost:3306/testingsystem?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
		final String username = "root";
		final String password = "vaythoi";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect Success !");

		String sql = "SELECT id, username, email FROM `User` ";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("username"));
			System.out.println(resultSet.getString("email"));
		}
	}
}
