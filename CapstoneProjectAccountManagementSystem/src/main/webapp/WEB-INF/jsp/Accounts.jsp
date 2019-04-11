<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
      <a class="navbar-brand" href="#" disabled="disabled">Bank Accounts</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li><a href="customer-home">Home</a></li>
      <li class="active"><a href="get-accounts-for-customer">Accounts</a></li>
       <li><a href="transactions">Transfer Funds</a></li>
       <li><a href="get-transfer-bank-details">Transfer Details</a></li>
        <li style="margin-left: 500px;"><a href="/customers/logout-user"><span style="font-size:16px;">Logout</span><img src="images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
    </ul>
  </div>
</nav>
   <div class="container" >
      <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
		<table class="table table-striped" style="border:2px solid black;border-radius:10px;box-shadow:5px 5px 5px 5px grey;">
			<thead>
				<tr style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%);color: white;">
					<th >Account No</th>
					<th>Account Type</th>
					<th>Account Balance</th>
					<th>Bank Name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accounts}" var="account">
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>${account.accountNo}</td>
						<td>${account.accountType}</td>
						<td>${account.balance}</td>
						<td>${account.bankName}</td>
						<td><button type="button" class="btn btn-success checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="window.location.href='get-account-details-by-id/${account.accountNo}'">Check account details</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		</div>
	</div>

</body>
<script>
$(document).ready(function(){
	
	$("tbody tr td:nth-child(3)").each(function () {
         var value=$(this).text();
         value=parseFloat(value).toFixed(2);
         value=String.fromCharCode(0x20b9).concat(" ").concat(value.toString());
         $(this).text(value);
	});
	
	
});


</script>
</html>