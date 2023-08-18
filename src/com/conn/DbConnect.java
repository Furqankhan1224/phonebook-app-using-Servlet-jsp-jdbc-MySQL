package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection Conn;
	
	public static Connection getconn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","furqan3672");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Conn;
	}
	

}
