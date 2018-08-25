import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Signup_Login_User.Login;

@Path("/loginuser")
public class Login_User {
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("Application/json")
	@Path("/login")
	public void loginUser(@FormParam("email")String uEmail, @FormParam("pass") String pass) {
		Login loginuser = new Login();
		loginuser.login(uEmail, pass);
	}
}
