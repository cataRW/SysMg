package main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	
	private DBConnection() {}
	
	public static Connection getConnection() {
		String dbName = "ssmp3";
		String dbUser = "root";
		String dbPassword = "NANEmernic1104";
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, dbUser, dbPassword);
		}catch (Exception e){
			e.printStackTrace();
			throw new Error("Can't connect to database");
		}
		return connection;
	}
	
	public static void close() {
		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

