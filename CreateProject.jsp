<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Project</title>
</head>
<body>

<h3>Fill Project Details</h3>

<form action="LoginManager.jsp">

Name:<input type="text" required> <br>
Start Date: <input type="date" required> <br>
Description:  <br> <textarea rows="5" cols="50"></textarea>  <br>
Status: 

<select>
<option>In-Progress</option>
<option>Completed</option>
</select> <br>

Team Members: <br>

<input type="submit" >


</form>

</body>
</html>