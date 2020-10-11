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

<form action="">  
Project Name: <input type="text" name="pname"/><br> <br>
Title: <input type="text" name="title"/><br> <br>
Description: <br>
<textarea rows="4" cols="50" name="desc"></textarea> <br> <br>

<div class = "input-field col s12">             
Severity: <select name="level">
	<option value=1>High</option>
	<option value=2>Medium</option>
	<option value=3>Low</option>
	</select>
	<br> <br>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
});
</script>
</div>

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