<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Binding</title>
</head>
<body>
	<h1>Search by any field below</h1>
	
	<form action="/searchContact">
		Name:<input type="text" name="name" /> <br />
		Phone Number:<input type="text" name="phone" /> <br />
		Address:<input type="text" name="address" /><br />
		Email:<input type="text" name="email" /> <br />
		
		<input type="submit" value="Search" />
		
	
	</form>
</body>
</html>