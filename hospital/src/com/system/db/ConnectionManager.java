package com.system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection conn;
	
	public static Connection getConnection() {
		ReadProperties read = new ReadProperties();
		String dbDriver = read.getProperty("DBDRIVER");
		String url = read.getProperty("URL");
		String username = read.getProperty("USERNAME");
		String password = read.getProperty("PASSWORD");
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection()!=null);
	}
}
