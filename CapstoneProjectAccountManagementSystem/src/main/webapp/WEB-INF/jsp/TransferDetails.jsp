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
<link rel="stylesheet" href="css/bootstrap-datepicker3.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>

</head>
<body
	style="background: #00c3ff; background: -webkit-linear-gradient(to right, #ffff1c, #00c3ff); background: linear-gradient(to right, #ffff1c, #00c3ff);">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" disabled="disabled">Bank
					Accounts</a>
			</div>
			<ul class="nav navbar-nav">

				<li><a href="customer-home">Home</a></li>
				<li><a href="get-accounts-for-customer">Accounts</a></li>
				<li><a href="transactions">Transfer Funds</a></li>
				<li class="active"><a href="get-transfer-bank-details">Transfer
						Details</a></li>
				<li style="margin-left: 500px;"><a
					href="/customers/logout-user"><span style="font-size: 16px;">Logout</span><img
						src="images/logout.jpg"
						style="width: 25px; height: 25px; color: transparent; border-radius: 15px; margin-left: 5px;'" /></a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<div class="input-group date" data-provide="datepicker">
					<input type="text" class="form-control" placeholder="Filter date from" id="filterdatefrom">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-th"></span>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12">
			    
				<div class="input-group date" data-provide="datepicker">
					<input type="text" class="form-control" placeholder="Filter date to" id="filterdateto">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-th"></span>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12"></div>
		</div>
		<div class="row" style="margin-top:20px;">
			<div class="col-md-12 col-sm-12 col-xs-12"
				style="height: 430px; overflow: auto;">
				<table class="table table-fixed"
					style="border: 2px solid black; border-radius: 10px; box-shadow: 5px 5px 5px 5px grey;">
					<thead>
						<tr
							style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">
							<th class="col-xs-3">Source Account Number</th>
							<th class="col-xs-3">Destination Account Number</th>
							<th class="col-xs-3">Transferred Ammount</th>
							<th class="col-xs-3">Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${transactions}" var="transaction">
							<tr
								style="background: #41295a; /* fallback for old browsers */ background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */ background: linear-gradient(to right, #41295a, #2f0743); color: white;">
								<td class="col-xs-3">${transaction.sourceAccountNo}</td>
								<td class="col-xs-3">${transaction.destinationAccountNo}</td>
								<td class="col-xs-3">${transaction.amount}</td>
								<td class="col-xs-3">${transaction.transactionTime}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
<script>
	$(document).ready(
			function() {

				$("tbody tr td:nth-child(3)").each(
						function() {
							var value = $(this).text();
							value = parseFloat(value).toFixed(2);
							value = String.fromCharCode(0x20b9).concat(" ")
									.concat(value.toString());
							$(this).text(value);
						});
				
				
				$('.datepicker').datepicker();
				$('.datepicker').datepicker({
				    format: 'mm/dd/yyyy',
				    startDate: '-3d'
				});

			});
	
	$(document).on('change', 'input[id=filterdateto]', function() {
		 
		  if($("#filterdatefrom").val()!="")
			  {
		          filtertodate=$(this).val();
		          filterfromdate=$("#filterdatefrom").val();
		          filterJson={
		        		 "filterfromdate":filterfromdate,
		        		 "filtertodate":filtertodate
		          };
		          console.log(filterJson)
		          $.ajax({
	     	 		    type: "GET",
	     	 		    dataType : 'json',
	     	 		    contentType: "application/json",
	     	 		    url: "http://localhost:1236/customers/set-filter-criteria",
	     	 		    data: filterJson, // Note it is important without stringifying
	     	 		    success: function(result,status,jqXHR) {
	     	 		    // do what ever you want with data
	     	 		   
	     	 		        if(result.response=="success")
	     	 		        	{
	     	 		       	window.location.href="get-transfer-bank-details-after-filtration"
	     	 		        	}
	     	 		        else
	     	 		        	{
	     	 		        	alert("filtration failed")
	     	 		        	}
	     	 		    
	     	 		    },
	     	 	   error(jqXHR, textStatus, errorThrown){
	     	       	 console.log(jqXHR);
	     	            console.log(textStatus);
	     	            console.log(errorThrown);
	     	        }
	     	 		    });
			  }
		});
	
	
</script>
</html>