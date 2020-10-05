<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wasp : Login</title>
</head>
<body>
<h1>Login Page</h1> <br> <br>

<form action="loginServlet" method="post">

	<label for="email">Email Address:</label>
	<input type="email" name="email" id="email" placeholder="Email Address: " required>  <br>

	<label for="password" >Password :</label>
	<input type="password" name="password" id="password" placeholder="Password: " required> <br>

	<input type="submit" name="submit" value="Login"> 

</form>
<div>
Error: ${message}
</div>
</body>
</html>