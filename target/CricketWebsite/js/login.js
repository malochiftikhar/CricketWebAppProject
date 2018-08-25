$(document).ready(function (){
	let id;
	$("#loginform").submit (function (event){
		event.preventDefault();
		$.post("start/login_user/login", $(this).serialize(), function(data, status){
			id = JSON.parse(data);
			console.log(id);
			if (id.status == "fail") {
				alert("Email or password incorrect");
			} else {
				sessionStorage.userid = id.username;
				alert("sucess");
			}
		});
	});
});