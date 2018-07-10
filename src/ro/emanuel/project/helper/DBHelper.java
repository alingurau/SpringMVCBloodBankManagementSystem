package ro.emanuel.project.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	public static Connection createConnection() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", connectionProps);
			System.out.println("Conection to Db created");

			return conn;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
