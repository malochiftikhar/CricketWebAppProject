function login() {

  let email = document.getElementById("email").value;
  let password = document.getElementById("pass").value;
  let request = new XMLHttpRequest();
  request.open("POST", "http://localhost:8080/CricketWebsite/start/loginuser/login", true);
  request.setRequestHeader('Content-Type', 'application/json');
  let data = JSON.stringify({
    "email": email,
    "password": password
  });
  request.send(data);
  request.responseType = 'json';
  request.onload = function() {
    let rs = request.response;
    console.log(rs.result);
    if (rs.result) {
      console.log("logged in");
      window.location.href = "LogedIn.html";
    }
    else {
      alert("Wrong Login");
    }
  }
}