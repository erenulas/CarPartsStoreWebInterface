<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/orders" method="get">
<input type="hidden" value="" name="id">
</form>
 <a href="${pageContext.request.contextPath}/orders?id=${customer_id}">Back to Orders</a>

	<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Part ID</th>
          <th>Part Name</th>
          <th>Price</th>

       </tr>
       <c:forEach var="part" items="${parts}">
          <tr>
             <td> ${part.part_id}</td>
             <td>${part.partName}</td>
             <td>${part.priceToCustomer}</td>
          </tr>
       </c:forEach>
    </table>
</body>
</html>