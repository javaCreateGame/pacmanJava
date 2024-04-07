package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// Dk MySQl vs DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/highscore";
			String username = "root";
			String password = "";

			// Tao ket noi
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		if (c != null) {
			try {
				java.sql.DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
