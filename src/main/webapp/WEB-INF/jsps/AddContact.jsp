<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- This will allow me the form binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercise 10</title>
</head>
<body>
	<h1>Add Contact</h1>

	<c:url var="url" value="/addContact" />
	<form:form action="${url }" method="POST" modelAttribute="person">
	
		Name:<form:input path="name" />
		<br />
		Phone Number::<form:input path="phone" />
		<br />
		Address:<form:input path="address" />
		<br />
		Email:<form:input path="email" />
		<br />

		<input type="submit" value="Submit" />

	</form:form>
	
	<c:url var="view" value="/view" />
	<a href="${view }">View Contacts</a>


</body>
</html>