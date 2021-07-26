import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Program {
	public static void main(String[] args)throws SQLException,ClassNotFoundException{
		Connection connection = getJDBCConnection();
	}
	public static Connection getJDBCConnection() {
		
		String url = "jdbc:mysql://localhost:3306/hello?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
		String user = "root";
		String password = "vaythoi";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return DriverManager.getConnection(url,user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
