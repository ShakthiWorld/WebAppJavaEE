<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Cart</title>
</head>
<body>
	<%
String[] selectedCars=(String[])session.getAttribute("selectedCars");
String[] selectedBooks=(String[])session.getAttribute("selectedBooks");
String[] selectedBikes=request.getParameterValues("bikes");
%>
<h4>books</h4>
<ul>
	<%for(String book:selectedBooks)
	{
		
	%>
		<li><%= book %> </li>
	<%
	}%>
</ul>
<h4>cars</h4>
<ul>
	<%for(String car:selectedCars)
	{
		
	%>
		<li><%= car %> </li>
	<%
	}%>
</ul>
<h4>bikes</h4>
<ul>
	<%for(String bike:selectedBikes)
	{
		
	%>
		<li><%= bike %> </li>
	<%
	}%>
</ul>
</body>
</html>