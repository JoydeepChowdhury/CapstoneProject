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
<link rel="stylesheet" href="css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/fontawesome.min.css">
<link rel="stylesheet" href="css/homestyle.css">
<link rel="stylesheet" href="css/jquery-confirm.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-confirm.js"></script>
<script src="js/bootstrap-select.min.js"></script>
<style type="text/css">
.selectpicker:hover {
	box-shadow: 1px 1px 1px 1px grey;
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

				<li><a href="customer-home">Home</a></li>
				<li id="acc"><a href="get-accounts-for-customer" >Accounts</a></li>
				<li class="active"><a href="transactions">Transfer Funds</a></li>
				<li style="margin-left: 685px;"><a
					href="/customers/logout-user"><span style="font-size: 16px;">Logout</span><img
						src="images/logout.jpg"
						style="width: 25px; height: 25px; color: transparent; border-radius: 15px; margin-left: 5px;'" /></a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<h4>Account to be transferred from:</h4>
				<select class="selectpicker" id="from-account"
					data-live-search="true">
					<option style="font-size: 18px;" value="" disabled selected>Choose
						Account to Transfer from....</option>
				</select>

			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<h4>Account to be transferred to:</h4>
				<select class="selectpicker" id="to-account" data-live-search="true">
					<option style="font-size: 18px;" value="" disabled selected>Choose
						Account to Transfer to....</option>
				</select>
			</div>
			<div class="col-md-12 col-sm-6 col-xs-12" id="valuediv"
				style="margin-bottom: 10px;"></div>
			<div class="col-md-3 col-sm-6 col-xs-12" id="buttondiv"></div>
		</div>
	</div>

</body>
<script>
var accountinfo;
var accountnos;
var from_acc_no;
var to_acc_no;
var bal;
$(document).ready(function(){
	 $.ajax({
	        url: "http://localhost:1236/customers/get-account-details-for-funds-transfer",
	        method: "GET",
	        contentType: "application/json",
	         success: function(result,status,jqXHR ){
	        	 accountinfo=result;
	        	 accountnos=accountinfo.map(function(d){
	        		 return d['accountNo'];
	        	 });
	        	 $('select').selectpicker();
	          $.each(accountnos,function(index,value)
	                {
	        	  $('#from-account').append('<option style="font-size:18px;" value="'+value+'">'+value+'</option>');
	                });
	          $('.selectpicker').selectpicker('refresh');
	         },
	         error(jqXHR, textStatus, errorThrown){
	        	 console.log(jqXHR);
	             console.log(textStatus);
	             console.log(errorThrown);
	         }
	    }); 
	
	
});

$("#from-account").change(function(){
	var from_account=$("#from-account").val();
	var accounts;
	var accnos;
	 $.ajax({
	        url: "http://localhost:1236/customers/get-account-details-for-funds-transfer",
	        method: "GET",
	        contentType: "application/json",
	         success: function(result,status,jqXHR ){
	        	 
	        	 accounts=result;
	        	accnos=accounts.map(function(d){
	        		 return d['accountNo'];
	        		
	        	 });
        		 accnos=accnos.filter(e => e !== from_account);
        		 $('#to-account').html('');
        		 $('#to-account').append('<option style="font-size:18px;" value="" disabled selected>Choose Account to Transfer to....</option>');
        		 $('#to-account').selectpicker();
        		  $.each(accnos,function(index,value)
      	                {
      	        	  $('#to-account').append('<option style="font-size:18px;" value="'+value+'">'+value+'</option>');
      	                });
        		 $('#to-account').selectpicker('refresh');
        		 
        		 
        		 
	         },
	         error(jqXHR, textStatus, errorThrown){
	        	 console.log(jqXHR);
	             console.log(textStatus);
	             console.log(errorThrown);
	         }
	    }); 
});

$("#to-account").change(function(){
	var to_account=$("#to-account").val();
	var from_account=$("#from-account").val();
	var accounts;
	var accnos;
	 $.ajax({
	        url: "http://localhost:1236/customers/get-account-details-for-funds-transfer",
	        method: "GET",
	        contentType: "application/json",
	         success: function(result,status,jqXHR)
	            {
	        	 accounts=result;
	        	 balance=accounts.filter(function(d){
	        		 return d['accountNo']==from_account;
	        	 }).map(function(z){
	        		 return z['balance'];
	        	 });
	        	 $("#valuediv").html("");
	        	 $("#valuediv").append('<h4>Amount to be transferred <span style="color:red"> Maximum balance in source account ('+balance[0]+')</span></h4><input id="valueinput" type="number" style="width:120px;height:35px;border-radius:7px;" min="0" max="'+balance[0]+'"/>');
        	   },
	         error(jqXHR, textStatus, errorThrown){
	        	 console.log(jqXHR);
	             console.log(textStatus);
	             console.log(errorThrown);
	         }
	    }); 
});
$("input[type='number']").change(function(){
	  alert($(this).val());
	});
$(document).on('change', 'input[id=valueinput]', function() {
   var askedForBalance=parseFloat($(this).val());
   var allowedBalance=parseFloat($(this).attr('max'));
   if(askedForBalance>allowedBalance)
	   {
	   $('#buttondiv').html('');
	   $.alert({
		    title: 'Transfer not allowed',
		    content: allowedBalance+" is the maximum amount that can be transferred from source account"
		});
	   $(this).css('background-color','red');
	   $(this).css('color','white');
	   }
   else
	   {
	   from_acc_no=$("#from-account").val();
	   to_acc_no=$("#to-account").val();
	   bal=askedForBalance;
	   $(this).css('background-color','yellow');
	   $('#buttondiv').html('');
	   $('#buttondiv').append('<button type="button" class="btn btn-success" onclick="navigate();">Transfer</button>');
	   }
});


function navigate()
  {
	urll="transfer-funds/"+from_acc_no+"/"+to_acc_no+"/"+bal;
	var transfer_json={
		"from_acc_no":from_acc_no,
		"to_acc_no":to_acc_no,
		"balance":bal
	};
	
	 $.ajax({
		    type: "GET",
		    dataType : 'json',
		    contentType: "application/json",
		    url: "http://localhost:1236/customers/transfer-funds-new",
		    data: transfer_json, // Note it is important without stringifying
		    success: function(result,status,jqXHR) {
		    // do what ever you want with data
		   
		        if(result.response=="success")
		        	{
		       	 $.alert({
		     		    title: 'Success',
		     		    content: "Transfer done successfully"
		     		}); 
		       	$("#valuediv").html("");
		        	}
		        else
		        	{
		        	 $.alert({
			     		    title: 'Failure',
			     		    content: "Transfer failed. Please try again"
			     		});
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