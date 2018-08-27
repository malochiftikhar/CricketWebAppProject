package auth.Register;
import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import auth.Address;
import auth.CricketClub;
import auth.Database;
import auth.User;
import auth.Register.RegisterCricketClub;

@Path("/register")
public class Register {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/registerUser")
	public void createUser(@FormParam("fname")String fname, @FormParam("sname") String sname,
			@FormParam("email")String email,@FormParam ("pass") String password,
			@FormParam("dob")Date dob, @FormParam("cname") int ccName) {
			Database database = new Database();
			database.connectDB();
			User newUser = new User();
			newUser.setFirstName(fname);
			newUser.setSurname(sname);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setDob(dob);
			newUser.setClub_id(ccName);
			Signup signup = new Signup();
			signup.createUserAccount(newUser.getFirstName(), newUser.getSurname(),
            		newUser.getEmail(), newUser.getPassword(), newUser.getDob(), newUser.getClub_id());
			database.closeConnection();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
	@Path("/registerClub")
	public String registerClub(String data) {
        Database database = new Database();
        database.connectDB();
        CricketClub newCricketClub = new Gson().fromJson(data, CricketClub.class);
        Address clubAddress = new Gson().fromJson(data, Address.class);
        new RegisterCricketClub().createCricketClubAccount(newCricketClub.getClub_name(), newCricketClub.getEmail(), newCricketClub.getPhoneNumber(),
				newCricketClub.getAddressNumber(), clubAddress.getPostcode(), clubAddress.getStreet_name(), clubAddress.getCity());
        String consolemsg = "complete";
		return "{\"result\":\""+ consolemsg+"\"}";
	}
}

//@POST
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces("application/json")
//@Path("/registerUser")
//public String registerUser(String data) {
//	Database database = new Database();
//	database.connectDB();
//	User newUser = new Gson().fromJson(data, User.class);
//	new Signup().createUserAccount(newUser.getFirstName(), newUser.getSurname(), newUser.getEmail(),
//			newUser.getPassword(), newUser.getDob(), newUser.getClub_id());
//	database.closeConnection();
//	String consolemsg = "complete";
//	return "{\"result\":\"" + consolemsg + "\"}";
//}
