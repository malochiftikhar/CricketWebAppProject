package auth;

public class Address {
	
	String postcode;
	String street_name;
	String city;
	
	public Address(String postcode, String street_name, String city) {
		super();
		this.postcode = postcode;
		this.street_name = street_name;
		this.city = city;
	}
	
	public Address() {
		
	}
	
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
