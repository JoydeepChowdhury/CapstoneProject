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
				<a class="navbar-brand" href="#" disabled="disabled">Bank
					Accounts</a>
			</div>
			<ul class="nav navbar-nav">

				<li><a href="/customers/customer-details-page">Customer Details</a></li>
				<li class="active"><a href="#">Account Details</a></li>
				 <li style="margin-left: 620px;"><a href="logout-admin"><span style="font-size:16px;">Logout</span><img src="images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-12 col-xs-12">
				<div class="card" style="width: 35rem;">
					<div class="card-header" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">Customer Details</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerId}</li>
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerName}</li>
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerAddress}</li>
						<li class="list-group-item" style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">${customer.customerDateOfBirth}</li>
					</ul>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12" style="height:250px;overflow:auto;">
				<table class="table table-striped" id="displayTable"
					style="border: 2px solid black; border-radius: 10px; box-shadow: 5px 5px 5px 5px grey;">
					<thead>
						<tr
							style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%); color: white;">
							<th>Account No</th>
							<th>Account Type</th>
							<th>Account Balance</th>
							<th>Bank Name</th>
							<th>Branch Details</th>
							<th>Date of Account Creation</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${accounts}" var="account">
							<tr
								style="background: #41295a; /* fallback for old browsers */ background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */ background: linear-gradient(to right, #41295a, #2f0743); color: white;">
								<td>${account.accountNo}</td>
								<td>${account.accountType}</td>
								<td>${account.balance}</td>
								<td>${account.bankName}</td>
								<td>${account.branchDetails}</td>
								<td>${account.dateOfBranchOpening}</td>
                                <td><button type="button" class="btn btn-danger checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="deleteAcount('${account.accountNo}');">Delete Account</button></td>
                                <td><button type="button" class="btn btn-warning checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="updateAcount('${account.accountNo}');">Update Account</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
		<div class="row">
			<button type="button" class="btn btn-success checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce;width:140px;margin-left:10px;margin-top:10px;" onclick="window.location.href='get-add-accounts-page'">Add Account</button>
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
    
    
    function deleteAcount(accountId)
      {
    	var transfer_json={
			"accountId":accountId
		};
    	var x=window.confirm("Are you sure you want to delete account "+accountId);
    	if(x)
    		{
    		 $.ajax({
 	 		    type: "GET",
 	 		    dataType : 'json',
 	 		    contentType: "application/json",
 	 		    url: "http://localhost:1236/customers/delete-account-for-a-customer",
 	 		    data: transfer_json, // Note it is important without stringifying
 	 		    success: function(result,status,jqXHR) {
 	 		    // do what ever you want with data
 	 		   
 	 		        if(result.response=="success")
 	 		        	{
 	 		       	 window.location.href="view-accounts-for-a-customer";
 	 		       	 alert("Account "+accountId+" deleted successfully")
 	 		        	}
 	 		        else
 	 		        	{
 	 		        	 alert("Account cannot be deleted");
 	 		        	}
 	 		    
 	 		    },
 	 	   error(jqXHR, textStatus, errorThrown){
 	       	 console.log(jqXHR);
 	            console.log(textStatus);
 	            console.log(errorThrown);
 	        }
 	 		    });
    		}
    	
    	
    	
      }
    
    function updateAcount(accountId)
        {
    	var transfer_json={
    			"accountId":accountId
    		};
        		 $.ajax({
     	 		    type: "GET",
     	 		    dataType : 'json',
     	 		    contentType: "application/json",
     	 		    url: "http://localhost:1236/customers/set-accountid-in-session",
     	 		    data: transfer_json, // Note it is important without stringifying
     	 		    success: function(result,status,jqXHR) {
     	 		    // do what ever you want with data
     	 		   
     	 		        if(result.response=="success")
     	 		        	{
     	 		       	 window.location.href="get-update-account-page";
     	 		        	}
     	 		        else
     	 		        	{
     	 		        	
     	 		        	}
     	 		    
     	 		    },
     	 	   error(jqXHR, textStatus, errorThrown){
     	       	 console.log(jqXHR);
     	            console.log(textStatus);
     	            console.log(errorThrown);
     	        }
     	 		    });
        		
        }
    
    
</script>


</html>