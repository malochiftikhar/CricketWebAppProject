package Signup_Login_User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost:3306/cricketprojectdb?serverTimezone=UTC&useSSL=false";
	 static final String USER = "root";
	 static final String PASS = "password";
	 
	 public static Connection connection;
	 
	 public void connectDB() {
	        try {
	        	Class.forName(JDBC_DRIVER);
	            connection = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("DATABASE CONNECTED");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void closeConnection() {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
