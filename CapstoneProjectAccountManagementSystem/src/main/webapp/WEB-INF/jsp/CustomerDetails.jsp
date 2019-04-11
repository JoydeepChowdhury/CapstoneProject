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
   <link rel="stylesheet" href="css/jquery-confirm.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-confirm.js"></script>
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
      <a class="navbar-brand" href="#" disabled="disabled">Admin User</a>
    </div>
    <ul class="nav navbar-nav">
     
      <li class="active"><a href="customer-details-page">Customers</a></li>
      <li style="margin-left: 900px;"><a href="logout-admin"><span style="font-size:16px;">Logout</span><img src="images/logout.jpg" style="width: 25px; height: 25px;color:transparent;border-radius:15px;margin-left:5px;'"/></a></li>
     
    </ul>
  </div>
</nav>
   <div class="container" >
      <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12" style="height:480px;overflow:auto;">
		<table class="table table-striped" style="border:2px solid black;border-radius:10px;box-shadow:5px 5px 5px 5px grey;">
			<thead>
				<tr style="background: linear-gradient(to bottom, #33ccff 76%, #000099 100%);color: white;">
					<th >Customer Id</th>
					<th>Customer Name</th>
					<th>Customer Address</th>
					<th>Customer Date of Birth</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerList}" var="customer">
					<tr style=" background: #41295a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #41295a, #2f0743); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #41295a, #2f0743);color:white;">
						<td>${customer.customerId}</td>
						<td>${customer.customerName}</td>
						<td>${customer.customerAddress}</td>
						<td>${customer.customerDateOfBirth}</td>
						<%-- <td><button type="button" class="btn btn-success checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="window.location.href='view-accounts-for-a-customer/${customer.customerId}'">View Accounts</button></td> --%>
					    <td><button type="button" class="btn btn-success checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="onclick=setCustomerIdToSession('${customer.customerId}')">View Accounts</button></td>
						<td><button type="button" class="btn btn-danger checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="checkAndDelete('${customer.customerId}');">Delete Customer</button></td>
					    <td><button type="button" class="btn btn-warning checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce" onclick="checkAndUpdate('${customer.customerId}');">Update Customer</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		</div>
		<button type="button" class="btn btn-success checkbtn" style="box-shadow:2px 2px 2px 2px #cee3ce;width:140px;margin-top:20px;margin-left:10px;" onclick="window.location.href='get-add-customer-page'">Add Customer</button>
		</div>
	</div>

</body>
<script>
function checkAndDelete(customerId)
        {
	
	     var x=window.confirm("Are you sure you want to delete customer with id "+customerId);
	     
	     if(x)
	    	{
	    		var transfer_json={
	    				"customerId":customerId
	    			};
	    	 
	    	 $.ajax({
	 		    type: "GET",
	 		    dataType : 'json',
	 		    contentType: "application/json",
	 		    url: "http://localhost:1236/customers/delete-customer",
	 		    data: transfer_json, // Note it is important without stringifying
	 		    success: function(result,status,jqXHR) {
	 		    // do what ever you want with data
	 		      
	 		        if(result.response=="success")
	 		        	{
	 		      alert("Customer deleted successfully");
	 		       	 window.location.href="customer-details-page";
	 		        	}
	 		        else
	 		        	{
	 		        	 alert("Customer couldnot be deleted");
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
        
        function checkAndUpdate(customerId)
        {
        	var transfer_json={
    				"customerId":customerId
    			};
        	
       	 $.ajax({
	 		    type: "GET",
	 		    dataType : 'json',
	 		    contentType: "application/json",
	 		    url: "http://localhost:1236/customers/set-customerid-in-session",
	 		    data: transfer_json, // Note it is important without stringifying
	 		    success: function(result,status,jqXHR) {
	 		    // do what ever you want with data
	 		   
	 		        if(result.response=="success")
	 		        	{
	 		       	      window.location.href="getCustomerUpdatePage";
	 		        	}
	 		        else
	 		        	{
	 		        	 alert("Customer id cannot be set in session");
	 		        	}
	 		    
	 		    },
	 	   error(jqXHR, textStatus, errorThrown){
	       	 console.log(jqXHR);
	            console.log(textStatus);
	            console.log(errorThrown);
	        }
	 		    });
        }
        function setCustomerIdToSession(customerId)
           {
        	var transfer_json={
    				"customerId":customerId
    			};
        	
       	 $.ajax({
	 		    type: "GET",
	 		    dataType : 'json',
	 		    contentType: "application/json",
	 		    url: "http://localhost:1236/customers/set-customerid-in-session",
	 		    data: transfer_json, // Note it is important without stringifying
	 		    success: function(result,status,jqXHR) {
	 		    // do what ever you want with data
	 		   
	 		        if(result.response=="success")
	 		        	{
	 		       	 window.location.href="view-accounts-for-a-customer";
	 		        	}
	 		        else
	 		        	{
	 		        	 alert("Customer id cannot be set in session");
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