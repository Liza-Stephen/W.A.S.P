<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Wasp : Tester </title>
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
      /* Header */
      
      /* Style the header with a grey background and some padding */
		.header {
		  overflow: hidden;
		  /* background-color: #f1f1f1; */
		  padding: 10px 10px;
		}
		
		/* Style the header links */
		.header a {
		  float: left;
		  color: black;
		  text-align: center;
		  padding: 12px;
		  text-decoration: none;
		  font-size: 18px;
		  line-height: 25px;
		  border-radius: 4px;
		}
		
		/* Style the logo link (notice that we set the same value of line-height and font-size to prevent the header to increase when the font gets bigger */
		.header a.logo {
		padding:1px; 
		  font-size: 25px;
		  font-weight: bold;
		}
		
		/* Change the background color on mouse-over */
		.header a:hover {
		  background-color: #ddd;
		  color: black;
		}
		
		/* Style the active/current link*/
		.header a.active {
		  background-color: dodgerblue;
		  color: white;
		}
		
		/* Float the link section to the right */
		.header-right {
		  float: right;
		}
		
		/* Add media queries for responsiveness - when the screen is 500px wide or less, stack the links on top of each other */
		@media screen and (max-width: 500px) {
		  .header a {
		    float: none;
		    display: block;
		    text-align: left;
		  }
		  .header-right {
		    float: none;
		  }
		}
		      
      /* Sidebar Navigation*/
      
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
		  }
		  
		  
		  /*Up- scroll button styles */
		  #myBtn {
				/*  display: none;  Hidden by default */
				  position: fixed; /* Fixed/sticky position */
				  bottom: 20px; /* Place the button at the bottom of the page */
				  right: 30px; /* Place the button 30px from the right */
				  z-index: 99; /* Make sure it does not overlap */
				  border: none; /* Remove borders */
				  outline: none; /* Remove outline */
				  background-color: red; /* Set a background color */
				  color: white; /* Text color */
				  cursor: pointer; /* Add a mouse pointer on hover */
				  padding: 15px; /* Some padding */
				  border-radius: 10px; /* Rounded corners */
				  font-size: 18px; /* Increase font size */
				}
				#myBtn:hover {
				  background-color: #555; /* Add a dark-grey background on hover */
				}
		  
		  /* Footer */
		  
		 .page-footer {
 
  padding-top: 20px;
 
  color: #e8eaf6;
 
  background-color: #8e24aa ;
 
}
		  
		  
		  
		  </style>
     
   </head>
   
   <body class = "container"> 
   
   
      <br>
      
		      <div class="header">
		  <a href="#default" class="logo"><img src="wasplogo.png" alt="logo" style="width:60px; height:60px;"></a>
		  <div class="header-right">
		    <a class="active" href="#home">Home</a>
		    <a href="#contact">Contact</a>
		    <a href="#about">About</a>
		  </div>
		</div>
      
  
      
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
// Side Navigar Bar Js
function openNav() {
  document.getElementById("mySidenav").style.width = "200px";
}
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
// Up-scroll Js
	//Get the button:
mybutton = document.getElementById("myBtn");
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};
function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}
// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}
</script>

	  <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
      <!-- Report New Bug Button -->
   		<form action="CreateBug.jsp" class = "right-align">
   			<input type="submit" value="Report Bug"  >
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
      
     <footer class="page-footer">
 
  <div class="container">
 
    <div class="row">
 
      <div class="col s4">
 
        <h5 class="white-text">Who we are?</h5>
 
        <p class="grey-text text-lighten-4">Wasp Bug Tracking System Developers</p>
 
   
 
      </div>
 
      <div class="col s4">
 
        <h5 class="white-text">User Guide</h5>
 
        <ul>
 
          <li><a class="grey-text text-lighten-3" href="#!">Documentation</a></li>
 
          <li><a class="grey-text text-lighten-3" href="#!">Team</a></li>
 
          <li><a class="grey-text text-lighten-3" href="#!">	</a></li>
 
          <li><a class="grey-text text-lighten-3" href="#!">	</a></li>
 
        </ul>
 
 
 
      </div>
 
      <div class="col s4">
 
        <h5 class="white-text">Quick Access </h5>
 
        <ul>
 
          <li><a class="grey-text text-lighten-3" href="#!">Home</a></li>
 
          <li><a class="grey-text text-lighten-3" href="#!">Logout</a></li>
 
          <li><a class="grey-text text-lighten-3" href="#!">Donate :)</a></li>
 
          <li><a class="grey-text text-lighten-3" href="#!">	</a></li>
 
        </ul>
 
      </div>     
 
    </div>
 
  </div>
 
</footer>
        
        <!--Up Scroll button -->
   
        
      
   </body>
</html>
