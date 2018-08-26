package club;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import auth.Database;


public class RegisterCricketClub {
	
	public void createCricketClubAccount(String clubName, String email, String phoneNumber, String addressOne, String postcode, String street, String city ) {
		clubAddressData(postcode, street, city);
		PreparedStatement statment = null;
		String sqlStatment = "INSERT INTO club(club_id, name, email, phone_number,address1, postcode)" 
				+ "values (?, ?, ?, ?, ?)";
		try {
			statment = Database.connection.prepareStatement(sqlStatment);
			statment.setInt(1, getNewId());
			statment.setString(2, clubName);
			statment.setString(3, email);
			statment.setString(4, phoneNumber);
			statment.setString(5, addressOne);
			statment.setString(6, postcode);
			statment.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clubAddressData(String postcode, String street_name, String city) {
		
		PreparedStatement statment = null;
		String sqlStatment = "INSERT INTO address(postcode, street_name, city)"
				+ "values(?,?,?)";
		try {
			statment  = Database.connection.prepareStatement(sqlStatment);
			statment.setString(1, postcode);
			statment.setString(2, street_name);
			statment.setString(2, city);
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
		String sqlStatment = "SELECT max(club_id) FROM club;";
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
