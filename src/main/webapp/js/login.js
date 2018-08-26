function login(email, password){
	
	if(email==""||password==""){
		alert("fills forms please")
	}
	else{
		let connection = new XMLHttpRequest();
		connection.open("POST", "http://localhost:8080/CricketWebsite/start/loginuser/login", true);
		connection.setRequestHeader('Content-Type', 'application/json');
	    let data = JSON.stringify({"email": email, "password": password});
	    connection.send(data);
	    connection.responseType = 'json';
	    connection.onload = function (){
	    let success = connection.response;
	    console.log(connection.response)
	       if(success.result == "true"){
	           alert("success");
	           window.location.href="LogedIn.html";
	       }
	       else{
	           alert("Wrong Login");
	       }
	   } 
	}
}