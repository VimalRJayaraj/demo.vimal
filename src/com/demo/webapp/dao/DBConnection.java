package com.demo.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	public static Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "DB", "mass");
		} catch (SQLException |ClassNotFoundException e) {
			System.out.println("Where is your DB driver");
			e.printStackTrace();
		}
		System.out.println("Inserted");
		return connection;
	}
}
