import java.sql.*;
public class Utility {
	//1.load and register the driver for connection.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2.establish the connection.
	public static Connection getconnect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "Imran@2005";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	//3.close the connection.
	public static void closeConnection(PreparedStatement pstmt, Connection conn) throws SQLException {
		conn.close();
		pstmt.close();
	}
}