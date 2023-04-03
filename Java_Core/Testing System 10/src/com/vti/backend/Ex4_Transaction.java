package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ultis.ScannerUltis;
import ultis.jdbcUltis;

public class Ex4_Transaction {
	private jdbcUltis jdbc;
	
	public Ex4_Transaction() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	public void deleteDepartmentUsingTransaction(int id) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = jdbc.getConnection();
		// turn off auto commit
		connection.setAutoCommit(false);
		// delete employees
		String sql1 = "DELETE FROM `Account` WHERE DepartmentID = ?";
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
		// set parameter
		preparedStatement1.setInt(1, id);
		// delete department
		String sql2 = "DELETE FROM `Department` WHERE DepartmentID = ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
		// set parameter
		preparedStatement2.setInt(1, id);
		// excute query
		try {
			preparedStatement1.executeUpdate();
			System.out.println("Delete Acount Success !");
			preparedStatement2.executeUpdate();
			System.out.println("Delete Department Success !");
			// commit transaction
			connection.commit();
			System.out.println("Transaction commit");
		} catch (Exception e) {
			System.out.println("có lỗi xảy ra");
			connection.rollback();
			System.out.println("Transaction Rollback");
		}
		// turn on auto commit
		connection.setAutoCommit(true);
		jdbc.disConnection();
	}
	public static void Question1()throws SQLException,ClassNotFoundException,IOException {
		System.out.print("Nhập DepartmentID : ");
		int id = ScannerUltis.inputInt();
		
		new Ex4_Transaction().deleteDepartmentUsingTransaction(id);
		System.out.println("Delete Success !");
	}
}
