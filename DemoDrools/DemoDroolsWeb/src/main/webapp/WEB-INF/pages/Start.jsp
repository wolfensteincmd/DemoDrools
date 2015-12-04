<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start operation</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Account</th>
			<th> Balance</th>
		</tr>
		<%
			List<List<String>> accounts = (List<List<String>>)request.getAttribute("accounts");
			for(List<String> elem : accounts){
				%>
				<tr>
				<td><%= elem.get(0) %></td>
				<td><%= elem.get(1) %></td>
				</tr>
				<%
			}
		%>
	</table>
	<br>
	<br>
	<br>
	<h1>Start an Operation</h1>
	<form action="operation" method="get">
		<label for="origin">Origin: </label>
		<input type="text" id="origin" name="origin" />
		<label for="destination">Destination: </label>
		<input type="text" id="destination" name="destination" />
		<label for="amount">Amount: </label>
		<input type="text" id="amount" name="amount" />
		<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>