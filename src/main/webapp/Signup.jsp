<!DOCTYPE html>
<html lang="en">
<head>
<title>Zill || Signup </title>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!--//fonts-->	
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="css/signup.css" rel="stylesheet"/>
</head>
<body>
 <script type="text/javascript">
	 	/*function validateEmail(){
	 		var em=document.getElementById("email").value;
	 		//alert(em);
	 		//step 1 how to get XHR
	 		var xhr=new XMLHttpRequest();
	 		//step 2 how xhr will open connection with servlet
	 		xhr.open("GET","GlobalServlet?taskType=validateEmail&email="+em);
	 		//step 3 how xhr will send request to servlet
	 		xhr.send();
	 		//step 4 how xhr will get response from server?
	 		
	 		xhr.onreadystatechange=function(){
	 			console.log("hello");
	 			if(xhr.readyState==4){
	 				var v1=xhr.responseText;		
	 				document.getElementById("emresult").innerHTML=v1;
	 			}
	 		}
	 		
	 	}*/
	 	function validateEmail(){
	 		var em=document.getElementById("email").value;
	 		
	 		fetch("GlobalServlet?taskType=validateEmail&email="+em)
	 	   .then(response => response.text().then(function (text) {
	 		  document.getElementById("emresult").innerHTML=text;
	 	  }))
	 	  .catch(error => console.error('Error:', error));
	 	}
	 </script>
<section class="h-80 bg-dark">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4 ">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <img src="images/loginsvgImage.svg"
                alt="Sample photo" class="img-fluid"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">Create New Account</h3>

                <!-- Form starts here -->
                <form action="GlobalServlet?taskType=signup" method="POST">

                  <div class="row">
                    <div class="col-md-6 mb-4">
                      <div data-mdb-input-init class="form-outline">
                        <input type="text" id="form3Example1m" name="fullname" class="form-control form-control-lg" />
                        <label class="form-label" for="form3Example1m">Full name</label>
                      </div>
                    </div>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="form3Example8" name="address" class="form-control form-control-lg" />
                    <label class="form-label" for="form3Example8">Address</label>
                  </div>
                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="form3Example90" name="pincode" class="form-control form-control-lg" />
                    <label class="form-label" for="form3Example90">Pincode</label>
                  </div>

                  <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">
                    <h6 class="mb-0 me-4">User Type: </h6>
                    <div class="form-check form-check-inline mb-0 me-4">
                      <input class="form-check-input" type="radio" name="userType" id="buyer" value="Buyer" />
                      <label class="form-check-label" for="buyer">Buyer</label>
                    </div>
                    <div class="form-check form-check-inline mb-0 me-4">
                      <input class="form-check-input" type="radio" name="userType" id="seller" value="Seller" />
                      <label class="form-check-label" for="seller">Seller</label>
                    </div>
                  </div>
                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="email" name="email" class="form-control form-control-lg" onblur="validateEmail()" />
                    <label class="form-label" for="email">Email ID</label>
                    <div id="emresult"></div>
                  </div>
                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="password" id="form3Example9" name="password" class="form-control form-control-lg" />
                    <label class="form-label" for="form3Example9">Password</label>
                  </div>

                  <div class="d-flex justify-content-end pt-3">
                    <button type="reset" class="btn btn-light btn-lg">Reset all</button>
                    <button type="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
                  </div>
                </form> 
                <!-- Form ends here -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>
