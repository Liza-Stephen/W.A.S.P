  	$(document).ready(function() {
  		$('.sidenav').sidenav();

  	})
  	
  	$(document).ready(function() {
  		$('.login').on('click',function() {

  			$('#login_modal').modal(); 
  		})

  		$('.register').on('click',function() {

  			$('#register_modal').modal(); 
  		})

  		$('.importUser').on('click',function() {

  			$('#import_modal').modal(); 
  		})
  	})
  