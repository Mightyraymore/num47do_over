<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
</head>
<body>

<form:form commandName="message" method="POST">
	<div style="font-weight: bold;">Share a Message:</div> <form:textarea style="width: 400px; height: 80px;" path="content" /> 
<div style="margin-left: 308px;">
	<input type="submit" id="submitBtn" value="Post Message"/>
</div>

</form:form>

<!-- 
	for (Message message : messages)
	{
	
	}
 -->
 <h2>Messages</h2>

<c:forEach items="${messages}" var="message">
	${message.content} <br/>
</c:forEach>

</body>
</html>
