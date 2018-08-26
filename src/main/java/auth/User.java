package auth;

import java.sql.Date;

public class User {
	int user_id;
	String first_name;
	String surname;
	String email;
	String password;
	Date dob;
	int club_id;
	
	public User(int user_id, String first_name, String surname, String email, String password, Date dob, int club_id) {
		this.user_id = user_id;
		this.first_name = first_name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.club_id = club_id;
	}
		
	public User (){
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname_name) {
		this.surname = surname_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}
	
	
}
