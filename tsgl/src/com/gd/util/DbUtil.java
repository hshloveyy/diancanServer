package com.gd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private Connection connection;

	public DbUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost/crm", "root", "root");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/crm", "hshloveyy", "hshloveyy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
