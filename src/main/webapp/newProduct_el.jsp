<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add and view product</title>
</head>
<body>
<fieldset name="add product">
<form action="product" method="get">

product name
<input type="text" name="product_name">
<br>
product price
<input type="number" name="product_price"><br>
product quantity on hand
<input type="number" name="product_qoh"><br>

<input type="submit" name="submit" value="enter">

</form>
</fieldset>
<table>
<tr>
<th>id</th>
<th>name</th>
<th>price</th>
<th>qoh</th>
<th>remove</th>
</tr>
<c:forEach var="pro" items="${productcontents}"> 
<tr>
<td>${pro.id }</td>
<td>${pro.name }</td>
<td>${pro.price }</td>
<td>${pro.qoh }</td>
<th><a href=removeProduct?id=${pro.id}>remove</a></th>
</tr>
</c:forEach>
</table>
</body>
</html>