function login(){
	let clubname = document.getElementById("cname").value;
	let email = document.getElementById("email").value;
	let phoneNumber = document.getElementById("phoneNumber").value;
	let postcode = document.getElementById("postcode").value;
	let streetName = document.getElementById("stName").value;
	let city = document.getElementById("city").value;
	let addressOne = document.getElementById("AddressOne").value;
	
	let request = new XMLHttpRequest();
	request.open("POST", "http://localhost:8080/CricketWebsite/start/register/registerClub", true);
	request.setRequestHeader('Content-Type', 'application/json');
    let data = JSON.stringify({club_name: clubname, email: email, phoneOne: phoneNumber, postcode: postcode, street_name: streetName, addressNumber: addressOne, city: city});
    console.log(data);
    request.send(data);
}

