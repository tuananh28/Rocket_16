package com.vti.backend;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import ultis.ScannerUltis;
import ultis.jdbcUltis;

public class Ex3_CallProcedure {
	private jdbcUltis jdbc;
	private DepartmentDAO DepDAO;
	
	public Ex3_CallProcedure() throws Exception, IOException {
		jdbc = new jdbcUltis();
		DepDAO = new DepartmentDAO();
	}
	public void deleteDepartmentUsingProcedure(int id) throws SQLException, ClassNotFoundException, IOException{
		if (!DepDAO.isDepartmentIdExists(id)) {
			System.out.println("Không tồn tại id "+id);
		}	
		Connection connection = jdbc.getConnection();
		String sql = "{CALL sp_delete_department (?)}";
		CallableStatement callableStatement = connection.prepareCall(sql);
		callableStatement.setInt(1, id);
		callableStatement.executeUpdate();
		jdbc.disConnection();
	}
	public static void Quesiton1() throws ClassNotFoundException, SQLException, IOException, Exception {
		System.out.print("Nhập DepartmentID : ");
		int id = ScannerUltis.inputInt();
		
		new Ex3_CallProcedure().deleteDepartmentUsingProcedure(id);
		System.out.println("Delete Success !");
	}
}
