<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Accounts</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="../css/bootstrap.min.css">
   <link rel="stylesheet" href="../css/fontawesome.min.css">
   <link rel="stylesheet" href="../css/homestyle.css">
  <script src="../js/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script> 
</head>
<body style="background: #00c3ff;background: -webkit-linear-gradient(to right, #ffff1c, #00c3ff);background: linear-gradient(to right, #ffff1c, #00c3ff);">
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" disabled="disabled">Bank Accounts</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/customers/customer-home">Home</a></li>
      <li><a href="/customers/get-accounts-for-customer">Accounts</a></li>
      <li class="active"><a href="#">Account Details</a></li>
      <li style="margin-left: 670px;"><a href="/customers/logout-user"><span style="font-size:16px;">Logout</span><img src="../images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
    </ul>
  </div>
</nav>
<h2 style="text-align:center">Account Summary</h2>
 <div class="container" >
      <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
		<table class="table table-striped" style="border:2px solid black;border-radius:10px;box-shadow:5px 5px 5px 5px grey;">
			<tbody>
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>Account No</td>
						<td>${account.accountNo}</td>
					</tr>
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>Account Type</td>
						<td>${account.accountType}</td>
					</tr>
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>Account Balance</td>
						<td id="accountBalance">${account.balance}</td>
					</tr>
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>Bank Name</td>
						<td>${account.bankName}</td>
					</tr>
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>Branch Details</td>
						<td>${account.branchDetails}</td>
					</tr>
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
					    <td>Account Creation Date</td>
						<td>${account.dateOfBranchOpening}</td>
					</tr>
			</tbody>
		</table>
		</div>
		</div>
	</div>
     

</body>
<script>
$(document).ready(function(){
	var accountBalance=document.getElementById("accountBalance").innerHTML;
	accountBalance=parseFloat(accountBalance).toFixed(2);
	accountBalance=String.fromCharCode(0x20b9).concat(" ").concat(accountBalance.toString());
	document.getElementById("accountBalance").innerHTML=accountBalance;
});
</script>
</html>