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
 <body class = "container"> 

<script>

function getProject()
{
	var data={"action":"getProject"};
	data=JSON.stringify(data);
	http.onreadystatechange=displayProjectData;
	http.open("POST","controller",true);
	http.setRequestHeader("Content-type","application/json;charset=UTF-8");
	http.send(data);
	}

function displayProjectData()	
{
	if(http.readyState==4&&http.status==200)
		{
		res=http.responseText;	
		
		project=JSON.parse(res);

		text = "";
		for (i in project) {
			text= text + "Project Id: "+project[i].id+"<br>";
			text= text + "Name: "+project[i].name+"<br>";
			text= text + "Manager: "+project[i].manager+"<br>";
			text= text + "Start Date: "+project[i].start+"<br><br>";
			text= text + "Team Members: <br>"+ 
			"<table border='1' class='table'>" +
			"<tr> <th>User Id</th> <th>User Name</th> <th>User Type</th></tr>";
			for (j in project.team)
				{

				text = text + "<tr>";
				text = text + "<td>"+project.team[j].userid+"<td>";
				text = text + "<td>"+project.team[j].name+"<td>";
				text = text + "<td>"+project.team[j].type+"<td>";
				text = text + "</tr>";
				}
			text = text + "</table>";
			text = text + "<h4> Bugs Details </h4> <div id='displaybug'></div>";
		}
		document.getElementById("displayproject").innerHTML=text;
		}
	}

function getBugs()
{
	var data={"action":"getBugs"};
	data=JSON.stringify(data);
	http.onreadystatechange=displayBugData;
	http.open("POST","controller",true);
	http.setRequestHeader("Content-type","application/json;charset=UTF-8");
	http.send(data);
}

function displayBugData()	
{
	if(http.readyState==4&&http.status==200)
		{
		res=http.responseText;
		bug=JSON.parse(res);
		document.getElementById("display").innerHTML=data;
		
		data = "<table border='1' class='table'>" +
			"<tr> <th>Bug Id</th> <th>Name</th> <th>Description</th><th>Actions</th></tr>";
			for (j in bug)
				{

				data = data + "<tr>";
				data = data + "<td>"+bug[j].id+"<td>";
				data = data + "<td>"+bug[j].title+"<td>";
				data = data + "<td>"+bug[j].description+"<td>";
				if (user.type == "manager")
				{
					data = data+"<td><button onclick='displayDevelopers()'>Assign Bug</button> <br>";
					data = data+"<div id='displaydev'> </div>";
					data = data+"<button onclick='closeBug()'>Close Bug</button>";
					data = data+"<div id='displayc'> </div>";
					data = data+"</td>";
				}
				else if (user.type == "developer")
				{
					data = data+"<td><button onclick='markClosing()'>Mark Bug for Closing</button>";
					data = data+"<div id='displaym'> </div>";
					data = data+"</td>";
				}

				else
				{
					data = data+"<td>No Action Applicable</td>";
				}
				data = data + "</tr>";
				}
			data = data + "</table>";
		document.getElementById("displayproject").innerHTML=text;
		}
}

function displayDevelopers()
{
	if(http.readyState==4)
		{
			res=http.responseText;
			alert(res);
			tester=JSON.parse(res);
			text = "<select id='developer'>";
			for (i in developer) {
				text += "<option value='developer[i]'>developer[i]</option>"
			}
			text += "</select><br>";
			
			document.getElementById("displaydev").innerHTML = text;
		}
}

function closeBug()
{
	var txt = "";
	  if (confirm("Close bug?")) {
	    txt = "<br> Bug closed <br>";
	  } 
	  document.getElementById("displayc").innerHTML = txt;
	  }
	  
function markClosing()
{
	var txt = "";
	  if (confirm("Mark bug for closing?")) {
	    txt = "Bug marked for closing";
	  } 
	  document.getElementById("displaym").innerHTML = txt;}
</script>
<h2>Project Details</h2>
<button onclick="getProject()">Get Projects</button>
<div id="displayproject"> </div>
</body>
</html>
