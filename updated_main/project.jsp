<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="x" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

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

</style>


</head>
<body>

<script>
function action() {
		if (${user.type == "manager"}) {
			
			document.getElementById("useraction").innerHTML = "<p onclick='showDevelopers()'> Assign Bug </p><p onclick='closeBug()'> Close Bug </p>";
		}
		if (${user.type == "developer"}) {
			
			document.getElementById("useraction").innerHTML = "<p onclick='markClosing()'> Mark for Closing </p>";
		}
		}

function showDeveloper()
{
	block = "";
	for (i=0;i<count;i++)
		{
		block += "<select name='developer' required>"+"<x:forEach var='c' items='${developers}'> + 
			"<option value='${c.developerId}'>${c.name}</option>" +
			"</x:forEach>"+"</select><br><br>";
		}
		document.getElementById("inputdev").innerHTML = block;}
function closeBug()
{
	var txt = "";
	  if (confirm("Close bug?")) {
	    txt = "Bug closed";
	  } 
	  document.getElementById("inputdev").innerHTML = txt;}
function markClosing()
{
	var txt = "";
	  if (confirm("Mark bug for closing?")) {
	    txt = "Bug marked for closing";
	  } 
	  document.getElementById("inputdev").innerHTML = txt;}
</script>

<h2>Project Details</h2>

  Project Id: ${data.projectId} <br>
  Project Name: ${data.name} <br>
  Manager: ${data.mName} <br>
  Start Date: ${data.start} <br>
  Team members: <br>
<h3> Bugs Details </h3>
<x:choose>
	
	<x:when test="${message == null}">
  	<table border='1' class="table">
	<tr>
	<th>Bug Id</th>
	<th>Title</th>
	<th>Description</th>
	</tr>
		<x:forEach var="c" items="${bugs}">
		<tr>
		<td>${c.bugId}<br><p id="useraction">
		</p><p id="inputdev">
		</p></td>
		
		<td>${c.title}</td>
		<td>${c.desc}</td>
		</tr>
		</x:forEach>
	</table>
	</x:when>
	
	<x:otherwise>
	${message}
	</x:otherwise>
	
	</x:choose>
</body>
</html>