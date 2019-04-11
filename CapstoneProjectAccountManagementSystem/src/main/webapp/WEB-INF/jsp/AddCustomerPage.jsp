<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Accounts</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
   <link rel="stylesheet" href="css/fontawesome.min.css">
   <link rel="stylesheet" href="css/homestyle.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-datepicker.min.js"></script>
  <style type="text/css">
      .checkbtn
         {
         box-shadow:1px 1px 1px 1px #cee3ce;
         }
  </style>
</head>
<body style="background: #00c3ff;background: -webkit-linear-gradient(to right, #ffff1c, #00c3ff);background: linear-gradient(to right, #ffff1c, #00c3ff);">
     <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" disabled="disabled">Admin User</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li><a href="/customers/customer-details-page">Customer Details</a></li>
      <li class="active"><a href="#">Add New Customer</a></li>
       <li style="margin-left: 610px;"><a href="logout-admin"><span style="font-size:16px;">Logout</span><img src="images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
    </ul>
  </div>
</nav>
  <div class="container">
     <div class="row">
        <form:form method="post" modelAttribute="customer" action="add-new-customer">
           <div class="col-md-6 col-sm-12 col-xs-12">
              <fieldset class="form-group">
				<form:label path="customerName">Customer Name</form:label>
				<form:input path="customerName" type="text" class="form-control"
					required="required" />
				<form:errors path="customerName" cssClass="text-warning" />
			</fieldset>
			</div>
			  <div class="col-md-6 col-sm-12 col-xs-12">
			   <fieldset class="form-group">
				<form:label path="customerAddress">Customer Address</form:label>
				<form:input path="customerAddress" type="text" class="form-control"
					required="required" />
				<form:errors path="customerAddress" cssClass="text-warning" />
			</fieldset>
			</div>
			<div class="col-md-6 col-sm-12 col-xs-12">
			<fieldset class="form-group">
				<form:label path="customerDateOfBirth">Date Of Birth</form:label>
				<form:input path="customerDateOfBirth"  type="text" class="form-control"
					required="required"/>
				<form:errors path="customerDateOfBirth" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success" style="width:120px;">Submit</button>
			</div>
        </form:form>
        </div>
  </div>

</body>
<script>
$('#customerDateOfBirth').datepicker({
	format : 'dd/mm/yyyy'
});
</script>
</html>