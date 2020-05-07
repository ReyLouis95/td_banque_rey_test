package com.iut.td_banque_rey.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/banque_test";
	private static final String USER = "root";
	private static final String password = "";
	private static Connection instance;
		
	public static Connection getInstance() {
		if (instance == null) {
			try {
				instance = DriverManager.getConnection(URL, USER, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return instance;	
	}	
}
