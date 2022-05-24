package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBConnectionUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/employees";

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "";

	private static Connection connection = null;

	public static Connection openConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		

	
				
				String sql = "SELECT * FROM employees";
				connection = DBConnectionUtil.openConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
				
					System.out.println(resultSet.getInt("emp_no"));
					
				}
			
		
	}

}