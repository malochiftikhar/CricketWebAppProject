package Signup_Login_User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	
	public String login(String email, String password) {
		
		PreparedStatement statment = null;
        String sqlStatment = "SELECT email, password FROM user WHERE email= ? && password=?;";
        String tf="";
        try {
        	statment = Database.connection.prepareStatement(sqlStatment);
        	statment.setString(1,email);
        	statment.setString(2, password);
        	statment.execute();
        	
        	ResultSet  rs = statment.executeQuery();
        	int count = 0;
        	while(rs.next()) {
        		count++;
        	}
        	
        	switch(count) {
        	case 1: System.out.println("you are logged in");
        			tf = "true";
        			break;
        	default : System.out.println("failed to login");
        			tf = "false";
        			break;
        	}
        	
        }catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "{\"result\":\""+tf +"\"}";
	}
}
