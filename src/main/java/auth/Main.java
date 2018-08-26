package auth;

import auth.login.Login;

public class Main {
	
	public static void main(String[] args) {
		Database database = new Database();
		database.connectDB();
		
		
		Login login = new Login();
		System.out.println(login.login("sumbulkhan@gmail.com", "pasword"));

//		System.out.println("Enter 1 to login, 2 to Signup, 3 to register a club");
//		Scanner sc = new Scanner(System.in);
//		int choice = sc.nextInt();
//		if(choice == 2) {
//			
//			User newUser = new User();
//			System.out.print("Enter first name: ");
//			newUser.setFirst_name(sc.next());
//			
//			
//			System.out.print("Enter surname: ");
//			newUser.setSurname(sc.next());
//			
//			
//			System.out.print("Enter email: ");
//			newUser.setEmail(sc.next());
//			
//			
//			System.out.print("Enter new password: ");
//			newUser.setPassword(sc.next());
//			
//			System.out.print("Enter your date of birth YEAR/MONTH/DATE: ");
//			String dob = sc.next();
////			LocalDate localDate = LocalDate.parse(dob);
////			newUser.setDob(localDate);
//			
//			sc.close();
//			
//			Signup signup = new Signup();
//            signup.createUserAccount(newUser.getFirst_name(), newUser.getSurname(),
//            		newUser.getEmail(), newUser.getPassword(), newUser.getDob(), 1);
//            System.out.println(newUser.getFirst_name() + " has been entered into the user table.");
//            
//		}else if (choice == 3) {
//			
//			CricketClub newCricketClub = new CricketClub();
//			Address clubAddress = new Address();
//			
//			System.out.print("Enter your club name: ");
//			newCricketClub.setClub_name(sc.next());
//			
//			System.out.print("Enter the email address for the club: ");
//			newCricketClub.setEmail(sc.next());
//			
//			System.out.print("Enter contact number for the club: ");
//			newCricketClub.setPhoneNumber(sc.next());
//			
//			System.out.print("Enter address number: ");
//			newCricketClub.setAddressNumber(sc.next());
//		
//			System.out.print("Enter postcode: ");
//			clubAddress.setPostcode(sc.next());
//			
//			System.out.print("Enter street name: ");
//			clubAddress.setPostcode(sc.next());
//			
//			System.out.print("Name of the city: ");
//			clubAddress.setCity(sc.next());
//			sc.close();
//			
//			RegisterCricketClub newClub = new RegisterCricketClub();
//			newClub.createCricketClubAccount(newCricketClub.getClub_name(), newCricketClub.getEmail(), newCricketClub.getAddressNumber(), newCricketClub.getAddressNumber(),
//					clubAddress.getPostcode(), clubAddress.getStreet_name(), clubAddress.getCity());
//			System.out.println(newCricketClub.getClub_name() + " has now been added to the Database");
//		}
//		if (choice == 1) {
//			Login loginuser = new Login();
//			System.out.print("Email");
//			String email = sc.next();
//			System.out.print("Password");
//			String password = sc.next();
//			loginuser.login(email, password);
//		}
	}
}
