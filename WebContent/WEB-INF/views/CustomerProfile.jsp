<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${customer.firstName }</title>
</head>
<body>
<h2>${customer.firstName} ${customer.lastName } (${customer.gender}, ${customer.age} / ${customer.birthDate})</h2>
<h5 style="padding-top:0px">${customer.phoneNumber}</h5>
<div>
<form action="${pageContext.request.contextPath}/orders" method="get">
<input type="hidden" value="" name="id">
</form>
 <a href="${pageContext.request.contextPath}/orders?id=${customer.customer_id}">Orders</a>
 
 <form action="${pageContext.request.contextPath}/createOrder" method="get">
<input type="hidden" value="" name="id">
</form>
 <a href="${pageContext.request.contextPath}/createOrder?id=${customer.customer_id}">Create Order</a>
 
<div style="padding-left:120px">
<form action="${pageContext.request.contextPath}/updateLastName" method="get">
Enter new last name: <input type="text" name="lastname">
				<input type="hidden" value="${customer.customer_id }" name="id">
			<input type="submit" value="submit">
</form>

</div> 
</div>

</body>
</html>

