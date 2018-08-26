package auth.login;

import auth.Database;
import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

	
	public String login(String email, String password) {
		
		PreparedStatement preparedStatement = null;
        String sqlStatement = "SELECT email, password FROM user WHERE email=? && password=?;";
        LoginResult loginResult = new LoginResult();
        try {
        	
        	preparedStatement = Database.connection.prepareStatement(sqlStatement);
        	preparedStatement.setString(1, email);
        	preparedStatement.setString(2, password);
        	preparedStatement.execute();
        	
        	ResultSet  rs = preparedStatement.executeQuery();
        	int count = 0;
        	while(rs.next()) {
        		count++;
        	}
        	
        	if(count == 1) {
        		System.out.println("loged in");
        		loginResult.setResult(true);
        	}else {
        		System.out.println("Failed to login");
        		loginResult.setResult(false);
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println(new Gson().toJson(loginResult));
		return new Gson().toJson(loginResult);
	}
}
