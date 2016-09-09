<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<html>
<head>
	<title>Register</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function() {
		$("#submitBrn").click(function (){
			var password = $("#password").val();
			var confirmPassword = $("#confirmPassword").val();
			
			if (password == confirmPassword)
			{
				$("#user").submit();
			}
			else
			{
				alert("Password do not match!");
			}
		});
	});
	</script>
</head>
<body>
<h1>
	User Registration  
</h1>

<!-- MVC (Model, View, Controller)
		Data, JSP Java
-->

<!-- User.java
	---------------
	private String username;
	private String password;

 	getters/setters
 	
 	JSPs -> Java Objects
 -->
 <form:form commandName="user" method="POST">
Username: <form:input path="username"/> <br/>
Password: <form:password path="password"/> <br/>
Confirm Password: <input type="password" id="confirmPassword" /> <br/> <br/>

 <form:radiobuttons path="accountType" items="${mySpecialAccountTypes}" element="div"/> <br/> <br/> 

<form:checkboxes  items="${countries}" path="selectedCountries" element="div"/> <br/> <br/>

<form:checkbox path="termsOfService" label="Terms of Service"/> <br/> <br/>

<input type="button" id="submitBtn" value="Submit"/>
</form:form>
 


</body>
</html>
