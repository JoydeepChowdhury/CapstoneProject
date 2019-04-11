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
.checkbtn {
	box-shadow: 1px 1px 1px 1px #cee3ce;
}
</style>
</head>
<body
	style="background: #00c3ff; background: -webkit-linear-gradient(to right, #ffff1c, #00c3ff); background: linear-gradient(to right, #ffff1c, #00c3ff);">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" disabled="disabled">Admin User</a>
			</div>
			<ul class="nav navbar-nav">

				<li><a href="customer-details-page">Customer Details</a></li>
				<li><a href="view-accounts-for-a-customer">Account Details</a></li>
				<li  class="active"><a href="get-add-accounts-page">Add Account</a></li>
				 <li style="margin-left: 490px;"><a href="logout-admin"><span style="font-size:16px;">Logout</span><img src="images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
	    <div class="row">
	       	<div class="col-md-4 col-sm-12 col-xs-12">
				<div class="card" style="width: 30rem;">
					<div class="card-header" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">Customer Details</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerId}</li>
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerName}</li>
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerAddress}</li>
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerDateOfBirth}</li>
					</ul>
				</div>
			</div>
	    </div>
		<div class="row">
			<form:form method="post" modelAttribute="account"
				action="add-new-account-to-current-customer">
				<div class="col-md-6 col-sm-12 col-xs-12">
					<fieldset class="form-group">
						<form:label path="accountType">Account Type</form:label>
						<form:select path="accountType" class="form-control" required="required">
							<form:options items="${accountTypes}" />
						</form:select>
						<form:errors path="accountType" cssClass="text-warning" />
					</fieldset>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<fieldset class="form-group">
						<form:label path="balance">Account Balance</form:label>
						<form:input path="balance" type="number"
							class="form-control" required="required" min="100"/>
					</fieldset>
				</div>
			    <div class="col-md-6 col-sm-12 col-xs-12">
					<fieldset class="form-group">
						<form:label path="bankName">Bank Name</form:label>
						<form:select path="bankName" class="form-control" required="required">
							<form:options items="${bankNames}" />
						</form:select>
						<form:errors path="bankName" cssClass="text-warning" />
					</fieldset>
				</div>
				 <div class="col-md-6 col-sm-12 col-xs-12">
					<fieldset class="form-group">
						<form:label path="branchDetails">Branch Address</form:label>
						<form:input path="branchDetails" type="text"
							class="form-control" required="required"/>
						<form:errors path="branchDetails" cssClass="text-warning" />
					</fieldset>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<fieldset class="form-group">
						<form:label path="dateOfBranchOpening">Account Creation Date</form:label>
						<form:input path="dateOfBranchOpening" type="text"
							class="form-control" required="required"/>
						<form:errors path="dateOfBranchOpening" cssClass="text-warning" />
					</fieldset>
					<button type="submit" class="btn btn-success" style="width: 120px;">Submit</button>
				</div>
			</form:form>
		</div>
	</div>

</body>
<script>
$('#dateOfBranchOpening').datepicker({
	format : 'dd/mm/yyyy'
});
</script>
</html>