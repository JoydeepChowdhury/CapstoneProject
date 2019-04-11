<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
   <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form:form class="login100-form validate-form" method="POST" action="/customers/login-customer" modelAttribute="userdetails">
					
					<span class="login100-form-title p-b-34">
						User Login
					</span>
					
					<div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
						<form:input path="userName" id="first-name" class="input100" type="text" name="username" placeholder="User name" required="required"/>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
						<form:input path="password" class="input100" type="password" name="pass" placeholder="Password" required="required"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<input type="submit" value="Sign In" class="login100-form-btn"/>
					</div>

					<div class="w-full text-center p-t-27 p-b-239">
					      <span style="color:red;"> ${error}</span>	
					</div>

					<div class="w-full text-center">
                         <a href="/customers/admin-login-screen" style="color:green;font-size:18px;">Login as admin</a>
					     <!--  <button class="login100-form-btn" style="">Login as Admin user</button> -->
					</div>
				</form:form>

				<div class="login100-more" style="background-image: url('images/bank.png');"></div>
			</div>
		</div>
	</div>
	
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
</body>
</html>