<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="x" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Project</title>
<!-- Compiled and minified CSS -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



  <!-- CSS  -->

  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>

  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

<style>
	body {
		background-image: url("background_image.jpg");
	}
	
	.card {
		background-color: #eeeeee;
		border-radius: 15px;
		border: 5px solid black;
	}
</style>

</head>
<body>
<div class= "container">

<div class="row">
	
<div class="col m6 offset-m3">
		
<div class="card">
			
<div class="card-content">

<h4 class="center-align">Create New Project</h4>
					
<div class="form center-align">
<form action="">
Project Name: <input type="text" name="pname"/><br> <br>
Start Date: <input type = "date" class = "datepicker" name="starter"/><br> <br>
Description: <br>
<div class="input-field col s12">
<textarea name="desc"></textarea> <br> <br>
</div>
<h6> Add Team Members: </h6> 
Add Tester:
	<div class="input-field col s12">
	<select name="tester">
	<x:forEach var="c" items="${tester}">
	<option value="${c.testerId}">${c.name}</option>
	</x:forEach>
	</select>
  	</div><br><br>
Add Developers: <br>
Number of developers required:
<input type="number" id="quantity" name="quantity" min="1" max="10"  onkeypress="developerCount()"> <br>
Choose developer(s):
<p id="inputdev"> </p>
<script>
function developerCount() {
	count = document.getElementById("quantity").value;
	block = "";
	for (i=0;i<count;i++)
		{
		block += "<select name='developer' required>"+"<x:forEach var='c' items='${developers}'> + 
			"<option value='${c.developerId}'>${c.name}</option>" +
			"</x:forEach>"+"</select><br><br>";
		}
		document.getElementById("inputdev").innerHTML = block;
		//block += "</select> <br>";
		//document.getElementById("inputdev").innerHTML = block;
}
</script>
<button type="submit" class="btn">Submit </button>
</form>
</div>	
</div>
</div>
</div>
</div>
</div>
</body>
</html>