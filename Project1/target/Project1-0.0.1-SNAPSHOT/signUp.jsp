<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Insert title here</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><img alt=""
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				height="80" width="60"> </a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="d-flex flex-row-reverse">
			<a href="index.jsp" class="p-2">HOME</a>
						
			</div>						
		</div>
	</nav>
	
	<h1 style="color: green;">${message}</h1>
	<h5 style="color: red;">${messag}<br>
		<c:forEach items="${errors}" var="e">${e.message}</c:forEach>
	</h5>
		<form action="register" method="post" class="container col-12 col-sm-6 col-md-3 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info" >
			
			<table>
					 <tr><h1>Sign Up</h1></tr>
					 <tr><p>Please fill in this form to create an account</p></tr>
					
					<tr>
					<div>
						<td>User ID</td><td> <input type="text" name="userId" value="${dto.userId}" id="userName"
							onchange="ValideName()"></td>
							 <span id="nameError" style="color: red"></span><br>
					</div></tr>
					
					<tr>
					<div>
						<td>Email</td><td><input type="email" name="email" id="emailId" value="${dto.email}"
							onchange="valideEmail()"></td>
							 <span id="emailError" style="color: red"></span><br>
					</div>
					</tr>
					
					<tr>
					<div>
						<td>Mobile Number</td><td><input type="number" name="mobile" id="userMobile" value="${dto.mobile}"
							onchange="ValideMobile()"></td> 
							<span id="mobileError" style="color: red"></span> <br>
					</div>
					</tr>
					
					<tr>
					<div>
						<td>Passwor</td>
						<td><input type="password" name="password" id="userPassword" value="${dto.password}"onchange="ValidePassword()"></td>
							 <span id="passwordError" style="color: red"></span><br>
	                         <td><input type="checkbox" onclick="myFunction()"></td><br><td>Show Password</td> <br>
					</div>
					</tr>
					
					<tr>
					<div>
						<td>Confirm Password</td><td><input type="password" name="confirmPassword" id="userConfirmPassword" onchange="ValidePassword()"></td>
						 <span id="passwordCompare" style="color: red"></span> <br>
					</div>
					</tr>
					
					<tr>
					<div>
						<td>Agreement</td><td> <input type="checkbox" name="agreement"
							id="agreementConfirm" onclick="onconfirm()"></td>
							 <br>
					</div>
					</tr>
					
					<tr>
					<div>
						<td><input type="submit" value="SignUp" class="btn btn-primary"/></td>
					</div>
					</tr>
					
			</table>
		</form>
	<h4 style="color: red;">${password}</h4>
	<script>
		function myFunction() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		function onconfirm() {
			var agree = document.getElementById('agreementConfirm');
			console.log(agree.checked);
			if (agree.checked) {
				document.getElementById('submitId').disabled = false;
			} else {
				document.getElementById('submitId').disabled = 'disabled';
			}

			function ValideName() {
				var user = document.getElementById('userName');
				var uservalue = user.value;
				console.log(uservalue);
				if (uservalue != null && uservalue != ""
						&& uservalue.length > 3 && uservalue.length < 30) {
					console.log('valide name');
					document.getElementById('nameError').innerHTML = '';
				} else {
					console.log('invalide name');
					document.getElementById('nameError').innerHTML = 'Plese enter valide name min 4 and max 30 character';
				}
			}
		}
		
		function valideEmail() {
			var userEmail = document.getElementById('emailId');
			var userEmailvalue = userEmail.value;
			console.log(userEmailvalue);
			if (userEmailvalue != null && userEmailvalue != ""
					&& userEmailvalue.length > 4 && userEmailvalue.length < 40) {
				console.log('valide email');
				document.getElementById('emailError').innerHTML = '';
			} else {
				console.log('invalide email');
				document.getElementById('emailError').innerHTML = 'Plese enter valide email';
			}
			const xhttp = new XMLHttpRequest();
			console.log("Running in ajax");
			console.log(userEmailvalue);
			xhttp.open("GET", "http://localhost:8080/sahana-xworkz-cm/email/"
					+userEmailvalue);
			xhttp.send();
			
			xhttp.onload = function () {
				console.log(this);
				
				document.getElementById("display").innerHTML = this.responseText
				
			}
			
		}
		function ValideMobile() {
			var userMobile = document.getElementById('userMobile');
			var userMobilevalue = userMobile.value;
			console.log(userMobilevalue);
			if (userMobilevalue != null && userMobilevalue != ""
					&& userMobilevalue.length == 10) {
				console.log('valide mobile');
				document.getElementById('mobileError').innerHTML = '';
			} else {
				console.log('invalide mobile');
				document.getElementById('mobileError').innerHTML = 'Plese enter valide Mobile Number';
			}
		}
		function ValidePassword() {
			var userPassword = document.getElementById('userPassword');
			var userConfirmPassword = document
					.getElementById('userConfirmPassword');
			var userPasswordvalue = userPassword.value;
			var userConfirmPasswordvalue = userConfirmPassword.value;
			console.log(userPasswordvalue);
			if (userPasswordvalue != null && userPasswordvalue != ""
					&& userPasswordvalue.length > 4
					&& userPasswordvalue.length < 12) {
				if (userPasswordvalue == userConfirmPasswordvalue) {
					console.log('valide both password are same');
					document.getElementById('passwordCompare').innerHTML = '';
				} else {
					console.log('valide both password are not same');
					document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword must be same';
				}
				console.log('valide password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalide password');
				document.getElementById('passwordError').innerHTML = 'Plese enter valide password';
			}
		}
	</script>
	
	
	
	
	
	
	
	
	
	

</body>
</html>