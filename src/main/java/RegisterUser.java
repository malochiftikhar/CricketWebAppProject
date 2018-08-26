import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import auth.Database;
import auth.Signup;
import auth.User;

@Path("/register")
public class RegisterUser {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createUser(@FormParam("fname")String fname, @FormParam("sname") String sname,
			@FormParam("email")String email,@FormParam ("pass") String password,
			@FormParam("dob")Date dob, @FormParam("cname") int ccName) {
			Database database = new Database();
			database.connectDB();
			User newUser = new User();
			newUser.setFirst_name(fname);
			newUser.setSurname(sname);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setDob(dob);
			newUser.setClub_id(ccName);
			Signup signup = new Signup();
			signup.createUserAccount(newUser.getFirst_name(), newUser.getSurname(),
            		newUser.getEmail(), newUser.getPassword(), newUser.getDob(), newUser.getClub_id());
			database.closeConnection();
	}
}
