package auth.login;

import auth.Credentials;
import auth.Database;
import com.google.gson.Gson;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/loginuser")
public class LoginUser {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
	@Path("/login")
	public void loginUser(String data) {
        Database database = new Database();
        database.connectDB();
		Credentials credentials = new Gson().fromJson(data, Credentials.class);
        new Login().login(credentials.getEmail(), credentials.getPassword());
	}
}
