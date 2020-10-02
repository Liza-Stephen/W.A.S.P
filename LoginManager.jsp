<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Wasp : Project Manager</title>
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">      
      <link rel = "stylesheet"
         href = "https://fonts.googleapis.com/icon?family=Material+Icons">
      <link rel = "stylesheet"
         href = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
      <script type = "text/javascript"
         src = "https://code.jquery.com/jquery-2.1.1.min.js"></script>           
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
      </script>             
      
      <style>
      
      
         div {
            width : 200px;	
            height : 200px;				
         } 
      
		      .sidenav {
		  height: 100%;
		  width: 0;
		  position: fixed;
		  z-index: 1;
		  top: 0;
		  left: 0;
		  background-color: #111;
		  overflow-x: hidden;
		  transition: 0.5s;
		  padding-top: 60px;
		}

		.sidenav a {
		  padding: 8px 8px 8px 32px;
		  text-decoration: none;
		  font-size: 25px;
		  color: #818181;
		  display: block;
		  transition: 0.3s;
		}

		.sidenav a:hover {
		  color: #f1f1f1;
		}
		
		.sidenav .closebtn {
		  position: absolute;
		  top: 0;
		  right: 25px;
		  font-size: 36px;
		  margin-left: 50px;
		}
		
		@media screen and (max-height: 450px) {
		  .sidenav {padding-top: 15px;}
		  .sidenav a {font-size: 18px;}
		  
		  </style>
     
   </head>
   
   <body class = "container"> 
   
   
      <br>
      <br>
      
      <!-- responsive side-bar -->
      
 <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "200px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>

      
      <!-- Create New Project Button -->
   		<form action="CreateProject.jsp" class = "right-align">
   			<input type="submit" value="Create Project"  >
   		</form>
      <br>
      <br>
      
      <!-- User Profile -->
      <hr/>
      <h3>My Info</h3>
      <table>
         <thead>
            <tr>
               <th>Email Address</th>
               <th>Role</th>
               <th>Last Login</th>
            </tr>
         </thead>
      <!-- Display User Data [DataBase] -->
         <tbody>
            <tr>
               <td></td>
               <td></td>
               <td></td>
            </tr>
          </tbody>
      </table>
      
      
       <br>
      <br>
      
      <!-- Project List -->
      <h3>My Projects</h3>
      <table class = "striped bordered">
         <thead>
            <tr>
               <th>Name</th>
            </tr>
         </thead>
         
         
         <!-- Let the below table body be empty for now -->
         <tbody>
            <tr>
               <td><a href="">Project Name</a></td>
               <td></td>
               <td></td>
            </tr>           
         </tbody>
      </table>
      
       <br>
      <br>
      
      <!-- Footer -->
      <footer class = "page-footer">
         <div class = "row">
            <div class = "col s12 m6 l6">
               <h5 class = "white-text">Footer</h5>
            </div>
            
            <div class = "col">
               <ul>
                  <li><a href = "#" class = "grey-text text-lighten-4 right">
                     Help</a></li>
                  <li><a href = "#" class = "grey-text text-lighten-4 right">
                     Privacy and Terms</a></li>
               </ul>
            </div>
         </div>
        </footer>
      
   </body>
</html>