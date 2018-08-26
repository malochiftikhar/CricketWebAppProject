function login(email, password){
		let request = new XMLHttpRequest();
		request.open("POST", "http://localhost:8080/CricketWebsite/start/loginuser/login", true);
		request.setRequestHeader('Content-Type', 'application/json');
	    let data = JSON.stringify({"email": email, "password": password});
	    request.send(data);
	    request.responseType = 'json';
	    request.onload = function (){
	    var success = request.response;
	       if(success.result == "true"){
	           alert("success");
	           window.location.href="Landing.html";
	       }
	       else{
	           alert("Wrong Login");
	       }
	}
}

