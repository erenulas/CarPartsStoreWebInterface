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
<form action="${pageContext.request.contextPath}/login" method="get">
<input type="hidden" value="" name="id">
</form>
 <a href="${pageContext.request.contextPath}/login?id=${orderlist[1].customer_id}">Back to Profile</a>

	<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Order ID</th>
          <th>Amount</th>
          <th>Date of Order</th>

       </tr>
       <c:forEach var="order" items="${orderlist}">
          <tr>
             <td>
             <a href="${pageContext.request.contextPath}/ordercontent?cst_id=${order.customer_id}&ordr_id=${order.order_id}">
             ${order.order_id}
             </a>
             </td>
             <td>${order.amount}</td>
             <td>${order.dateOfOrder}</td>
             <!-- <td>
                <a href="editProduct?code=${product.code}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
             </td> -->
          </tr>
       </c:forEach>
    </table>
</body>
</html>