package auth;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
	
	 private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/cricketprojectdb?serverTimezone=UTC&useSSL=false";
	 private static final String USER = "root";
	 private static final String PASS = "password";
	 
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
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
