package auth;

public class CricketClub {
	
	int club_id;
	String club_name;
	String email;
	String phoneOne;
	String addressNumber;
	String postcode;
	
	public CricketClub(int club_id, String club_name, String email, String phoneOne, String addressNumber,
			String postcode) {
		this.club_id = club_id;
		this.club_name = club_name;
		this.email = email;
		this.phoneOne = phoneOne;
		this.addressNumber = addressNumber;
		this.postcode = postcode;
	}
	
	public CricketClub() {
		
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneOne;
	}

	public void setPhoneNumber(String phoneNummber) {
		this.phoneOne = phoneNummber;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}
