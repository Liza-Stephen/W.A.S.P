<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Compiled and minified CSS -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    

<title>Import Users Page</title>
</head>


<body>

<div class= "container">

	<div class="row">
	
		<div class="col m6 offset-m3">
		
			<div class="card">
			
				<div class="card-content">
				
					<h4 class="center-align">Import Users</h4>
					
					<div class="form center-align">
					
					<!-- Compiled and minified JavaScript -->
<form action="testServlet" method="POST">
						
					<div class = "file-field input-field">
                  		<div class = "btn">
                     	<span>Browse</span>
                     	
                    <input type = "file" />
                  		</div>
                  
                  	<div class = "file-path-wrapper">
                    <input class = "file-path validate" type = "text" placeholder = "Upload file" accept='application/json' onchange='openFile(event)'/>
                    <!-- <input type='file' accept='application/json' onchange='openFile(event)'> -->
                    <script>
 var http=new XMLHttpRequest();
  var openFile = function(event) {
    var input = event.target;

    var reader = new FileReader();
    reader.onload = function(){
      var text = reader.result;
      process(text);
    //  console.log(reader.result.substring(0, 200));
    };
    reader.readAsText(input.files[0]);
  };
  function process(text)
  {
	  data={"file":JSON.parse(text),"action":"importUser"};
	  data=JSON.stringify(data);
	   http.onreadystatechange=display;
		http.open("POST","controller",true);
		http.setRequestHeader("Content-type","application/json;charset=UTF-8");
		http.send(data);
  }
  function display()
  {
	  if(http.readyState==4&&http.status==200)
	  {
	  	res=http.responseText;
	  	document.getElementById("display").innerHTML=res;
	  	}
  }
</script>
                    
                  </div>
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

