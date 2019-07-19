<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Cart</title>
</head>
<body bgcolor=green>


	<h4>books</h4>
	<ul>

	<c:forEach var="abook" items="${selectedBooks}">
	<li>"${abook}"</li>
	</c:forEach>
		

	</ul>
	
	<h4>cars</h4>
	<ul>

	<c:forEach var="acar" items="${selectedCars}">
	<li>${acar}</li>
	</c:forEach>
		

	</ul>
	
	<h4>bikes</h4>
	<ul>

	<c:forEach var="abike" items="${paramValues.bikes}">
	<li>${abike}</li>
	</c:forEach>
		

	</ul>
</body>
</html>