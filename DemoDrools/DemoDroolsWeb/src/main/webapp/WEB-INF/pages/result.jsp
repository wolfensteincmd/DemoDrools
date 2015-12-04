<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h1>Operation</h1>

	<h2>Origin : <%= (String) request.getAttribute ("origin") %></h2>
	<h2>Destination : <%= (String) request.getAttribute ("destination") %></h2>
	<h2>Amount : <%= ((Double) request.getAttribute ("amount")).toString() %></h2>
	<h2>Message : <%= (String) request.getAttribute ("message") %></h2>
	<br>
	<br>
	<a href="StartOperation">Another operation</a>
</body>
</html>