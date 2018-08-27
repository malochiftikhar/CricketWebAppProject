function registerClub() {
  let clubname = document.getElementById("cname").value;
  let email = document.getElementById("email").value;
  let phoneNumber = document.getElementById("phoneNumber").value;
  let postcode = document.getElementById("postcode").value;
  let streetName = document.getElementById("stName").value;
  let city = document.getElementById("city").value;
  let addressOne = document.getElementById("AddressOne").value;

  if (clubname == "" || email == "" || phoneNumber == "" || postcode == "" || streetName == "" || addressOne == "" || city == "" ) {
    alert("Form is not complete");
  }
  else {
    let request = new XMLHttpRequest();
    request.open(
      "POST",
      "http://localhost:8080/CricketWebsite/start/register/registerClub",
      true);
    request.setRequestHeader('Content-Type', 'application/json');
    let data = JSON.stringify({
      club_name: clubname,
      email: email,
      phoneOne: phoneNumber,
      postcode: postcode,
      street_name: streetName,
      addressNumber: addressOne,
      city: city
    });
    console.log(data);
    request.send(data);
    request.responseType = 'json';
    request.onload = function() {
      let rs = request.response;
      console.log(rs.result);
      if (rs.result == "complete") {
        console.log("logged in");
        window.location.href = "index.html";
      }
      else {
        alert("something went wrong not registered");
      }
    }
  }
}

//function registerUser() {
//	  let fName = document.getElementById("fname").value;
//	  let sName = document.getElementById("sname").value;
//	  let dob = document.getElementById("dob").value;
//	  let email = document.getElementById("email").value;
//	  let cName = document.getElementById("cname").value;
//	  let password = document.getElementById("pass").value;
//
//	  if (fName == "" || sName == "" || dob == "" || email == "" || password == "" ) {
//	    alert("Please fill in the form complete");
//	  }
//	  else {
//	    let request = new XMLHttpRequest();
//	    request.open(
//	      "POST",
//	      "http://localhost:8080/CricketWebsite/start/register/registerUser",
//	      true);
//	    request.setRequestHeader('Content-Type', 'application/json');
//	    let data = JSON.stringify({
//	    	firstName: fName,
//	    	surname: sName,
//	    	email: email,
//	    	password: password,
//	    	dob: dob,
//	    	club_id: cName
//	    });
//	    console.log(data);
//	    request.send(data);
//	    request.responseType = 'json';
//	    request.onload = function() {
//	      let rs = request.response;
//	      console.log(rs.result);
//	      if (rs.result == "complete") {
//	        console.log("logged in");
//	        window.location.href = "index.html";
//	      }
//	      else {
//	        alert("something went wrong not registered");
//	      }
//	    }
//	  }
//	}