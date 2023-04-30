package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_assessment", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
