package Signup_Login_User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup {

	public void createUserAccount(String first_name, String last_name, String email, String password, Date dob, int clubId) {
		PreparedStatement statment = null;
		String sqlStatment = "insert into user(user_id, fname, lname, email, password, dob, fk_club_id)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			statment = Database.connection.prepareStatement(sqlStatment);
			statment.setInt(1, getNewId());
			statment.setString(2, first_name);
			statment.setString(3, last_name);
			statment.setString(4, email);
			statment.setString(5, password);
			statment.setDate(6, dob);
			statment.setInt(7, 1);
			statment.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public int getNewId() {
		int id = 0;
		PreparedStatement statment = null;
		String sqlStatment = "SELECT max(user_id) FROM user;";
		try {
			statment = Database.connection.prepareStatement(sqlStatment);
			ResultSet result = statment.executeQuery(sqlStatment);
			while(result.next()) {
				id = result.getInt(1);
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id+1;
	}

}
