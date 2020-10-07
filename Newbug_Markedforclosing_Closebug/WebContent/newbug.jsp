<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Report New Bug </h1>
<form  action='getbug'>  
Project Name: <input type="text" name="pname"/><br> <br>
Title: <input type="text" name="title"/><br> <br>
Start Date: <input type="date" name="start"/><br> <br>
Description: <br>
<textarea rows="4" cols="50" name="desc"></textarea> <br> <br>
Severity: <select name="level">
	<option value=1>High</option>
	<option value=2>Medium</option>
	<option value=3>Low</option>
	</select>
	<br> <br>
<input type='submit' value='Submit'>
</form>  
</body>
</html>