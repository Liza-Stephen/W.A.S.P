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
<!--  <form action="">  -->
Project Name: <input type="text"  id="pName" class='validate'/><br> <br>
Start Date: <input type = "date" class = "datepicker validate"  id="startDate"/><br> <br>
Description: <br>
<div class="input-field col s12">
<textarea name="desc" id='description' class='validate'></textarea> <br> <br>
</div>
<button onclick='getDevelopers()' class='btn'>Get Developers</button><br><br>
<div id='displayDevelopers'></div>
<button onclick='getTesters()' class='btn'>Get Testers</button><br><br>
<div id='displayTesters'>
	<select id='selectTester'>
		
	</select>
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
<input type="hidden" id='action' name='action' value="addProject"/>
Choose developer(s):
<p id="inputdev"> </p>

<button class="btn" onclick="sendData()">Submit </button>

<script>

function sendData()
{
	pName = document.getElementById('pName').value
	startDate = document.getElementById('startDate').value
	description = document.getElementById('description').value
	action = document.getElementById('action').value
	
	var data = {"pName":pName,"description":description,"startDate":startDate,"action":action}
	
	data = JSON.stringify(data)
	alert(data)
	http.onreadystatechange = displayData;
	http.open("POST","controller",true);
	http.setRequestHeader("Content-type","application/json;charset=UTF-8")
	http.send(data)	;

}


function getTesters()
{

	$('#selectTester').append("<option>hello</option>");
	if(http.readyState==4)
		{
			alert('ready')
			res=http.responseText;
			alert(res);
			tester=JSON.parse(res);
			text = "<select name='tester' mutiple>";
			for (i in tester) {
				text += "<option value='tester[i]'>tester[i]</option>"
			}
			text += "</select>";
			
			$('#displayTesters').append("<option value='"+tester[i]+"'>"+tester[i]+"</option>");
			
			document.getElementById("displayTesters").innerHTML = text;
		}
}

function getDevelopers()
{
	
	if(http.readyState==4)
		{
			res=http.responseText;
			alert(res);
			developer=JSON.parse(res);
			text = "<select name='developer' mutiple>";
			for (i in developer) {
				text += "<option value='developer[i]'>developer[i]</option>"
			}
			text += "</select>";
			
			document.getElementById("displayDevelopers").innerHTML = text;
		}
}

</script>

  
<script>
$(document).ready(function(){
    $('.datepicker').datepicker();
  });
</script>
<!--  </form> -->
</div>	
</div>
</div>
</div>
</div>
</div>
</body>
</html>