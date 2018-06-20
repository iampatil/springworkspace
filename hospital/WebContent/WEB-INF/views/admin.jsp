<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security Authentication and Authorization - Admin
	Page</title>
</head>
<body>
	<h2>Spring Security Authentication and Authorization - Admin Page</h2>
	<h3>${welcomeMessage}</h3>
	<br>
	<form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<input type="submit" value="Logout">
	</form>
</body>
</html>