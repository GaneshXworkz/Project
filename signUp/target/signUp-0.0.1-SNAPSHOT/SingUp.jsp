<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
			<a href="Index.jsp" class="p-2">HOME PAGE</a>
			
			
			</div>						
		</div>
	</nav>




<form action="reg" method="post" class="container col-12 col-sm-6 col-md-3 shadow-lg p-4 mb-4 bg-white mx-auto d-block border border-primary rounded-lg 
m-5 pb-5 bg-info">

 <tr><h3>  SIGN UP</h3></tr>
 

     <tr><td>NAME :</td><td><input type="text" name="name" value="${SignUpDto.name}"></td></tr><br>
     
      <tr><td>EMAIL :</td><td><input type="text" name="email" value="${SignUpDto.email}"></td></tr><br>
     
      <tr><td>MOBIAL NO :</td><td><input type="text" name="mobilNo" value="${SignUpDto.mobilNo}"></td></tr><br>

      <tr><td>PASSWORD :</td><td><input type="password" name="password" value="${SignUpDto.password}"></td></tr><br>

      <tr><td> CONFORM PASSWORD :</td><td><input type="password" name="conformPassword" value="${SignUpDto.conformPassword}"></td></tr><br>

      <tr><td> AGGREMENT :</td><td><input type="checkbox" name="aggrement" value="${SignUpDto.aggrement}"></td></tr><br>
		
      <tr><td><input type="submit" value="signUp" class="btn btn-primary"/></td></tr>
          




</form>

</body>
</html>