  
package ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUltis {
	private Connection connection;
	private Properties properties;


	public void connnectionTestting() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String Username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String dirver = properties.getProperty("driver");
		
		Class.forName(dirver);
		connection = DriverManager.getConnection(url, Username, password);
		System.out.println("Connect Success");
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String Username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String dirver = properties.getProperty("driver");
		Class.forName(dirver);
		connection = DriverManager.getConnection(url, Username, password);
		return connection;
	}

	public void disConnection() throws SQLException {
		connection.close();
	}
	


	public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		Connection connnection = getConnection();
		Statement statement = connnection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		return result;
	}

	public PreparedStatement createPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection connnection = getConnection();
		PreparedStatement preStatement = connnection.prepareStatement(sql);
		return preStatement;
	}

}