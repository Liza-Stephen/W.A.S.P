<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Bug</title>
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

<h4 class="center-align">Report New Bug</h4>
					
<div class="form center-align">

<button class='btn' id='project' onclick='getProjects()'>Get Projects</button>
<!-- Project Name: <input type="text" id="pName"/> -->
<br> <br>
<div id='projects_div'>
</div>
Pick and add project: <input type="text"  id="addProject"/>
Title: <input type="text" id="title"/><br> <br>
Description: <br>
<textarea rows="4" cols="50" id="description"></textarea> <br> <br>

<div class = "input-field col s12">             
Severity: <select id="severity">
	<option value='High'>High</option>
	<option value='Medium'>Medium</option>
	<option value='Low'>Low</option>
	</select>
	<br> <br>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
});
</script>
</div>

<input type='hidden' id='action' value='addBug'/>
<button class="btn" onclick='sendData()'>Submit </button>

<script>
	function sendData()
	{
		pName = document.getElementById('pName').value
		title = document.getElementById('title').value
		description = document.getElementById('description').value
		severity = document.getElementById('severity').value
		action = document.getElementById('action').value
		var data = {"pName":pName,"description":description,"title":title,"severity":severity,"action":action}
		data = JSON.stringify(data)
		alert(data)
		http.onreadystatechange = displayData;
		http.open("POST","controller",true);
		http.setRequestHeader("Content-type","application/json;charset=UTF-8")
		http.send(data)	;
	}
	
	
</script>

<script>
function getProjects()
{
	if(http.readyState==4)
	{
		res=http.responseText;
		alert(res);
		project=JSON.parse(res);
		text = "<table>" + "<tr> <th> Project Name </th> </tr>"
		for (i in project) {
			text += "<tr> <td> project[i] </td> </tr>"
		}
		text += "</table>";
		
		document.getElementById("projects_div").innerHTML = text;
	}
}
</script>


</div>	
</div>
</div>
</div>
</div>
</div>
</body>
</html>