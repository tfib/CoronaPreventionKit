<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<br>
	<h4>
		<b> Order Summary: </b>
	</h4>
	<br>

	<h4>
		<b>User Details:</b>
	</h4>
	<br>
		<label>User Full Name: ${userdetails.pName} </label>
	<br>
		<label>Contact Number: ${userdetails.pContact} </label>
	<br>
		<label>e-mail: ${userdetails.pEmail} </label>
	<br>
		<label>Address: ${userdetails.address} </label>
	<br>
	<c:choose>
		<c:when test="${kititems==null || kititems.isEmpty() }">
			<h4>No Products Selected</h4>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Cost</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${kititems}" var="item">
					<tr>
						<td>${item.product.getProductId()}</td>
						<td>${item.product.getpName()}</td>
						<td>${item.product.getPcost()}</td>
						<td>${item.product.getpDescription()}</td>
						<td>${item.quantity}</td>
						<td>${item.price}</td>
					</tr>
				</c:forEach>

			</table>
		</c:otherwise>

	</c:choose>
	<br>
	<%String str=session.getAttribute("total").toString();%>
	<h4>
		<b>Total Price: <%=str%></b>
	</h4>
</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>