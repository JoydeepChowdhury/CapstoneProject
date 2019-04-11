<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</head>
<body style="background: #00c3ff;background: -webkit-linear-gradient(to right, #ffff1c, #00c3ff);background: linear-gradient(to right, #ffff1c, #00c3ff);">
     <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" disabled="disabled">Bank Accounts</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="customer-home">Home</a></li>
      <li><a href="get-accounts-for-customer">Accounts</a></li>
      <li><a href="transactions">Transfer Funds</a></li>
      <li><a href="get-transfer-bank-details">Transfer Details</a></li>
      <li style="margin-left:500px;"><a href="/customers/logout-user"><span style="font-size:16px;">Logout</span><img src="images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
    </ul>
  </div>
</nav>
<h2 style="text-align:center">User Profile</h2>

<div class="card">
  <img src="images/profile.png" alt="Profile" style="width:100%">
  <h1>${customer.customerName}</h1>
  <p class="title">Address: ${customer.customerAddress}</p>
  <p>Date of Birth: ${customer.customerDateOfBirth} </p>

</div>

</body>


</html>