<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <!-- This will allow me the form binding -->
    <%@ taglib prefix = "fb" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>

</head>
<body>
	<h1>Contacts information</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Address</th>
				<th>Email</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${person}" var="item">
				<tr>
					<td>${item.name }</td>
					<td>${item.phone }</td>
					<td>${item.address }</td>
					<td>${item.email }</td>
		
					<td><a href="<c:url value="/delete/${item.id }" />">Delete</a></td>
					<td><a href="<c:url value="/update/${item.id }" />">Update</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>

</body>
</html>