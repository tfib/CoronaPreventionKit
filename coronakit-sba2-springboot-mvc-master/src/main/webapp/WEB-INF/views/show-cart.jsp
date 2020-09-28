<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>


	<a href="${pageContext.request.contextPath}/user/show-list">List
		All Products</a>
	<br>
	<br>

	<h4>
		<b> Items in the Kit: </b>
	</h4>
	<br>	
		<c:choose>
			<c:when test="${kitItems==null || kitItems.isEmpty() }">
				<h4>No Products Selected</h4>
			</c:when>
			<c:otherwise>
				<table border="1" cellspacing="5px" cellpadding="5px">
					<tr>
						<th>Kit Id</th>
						<th>Corona Kit Id</th>
						<th>Product Id</th>
						<th>Quantity</th>
						<th>Amount</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${kitItems}" var="item">
						<tr>
							<td>${item.getId()}</td>
							<td>${item.getCoronaKitId()}</td>
							<td>${item.getProductId()}</td>
							<td>${item.getQuantity()}</td>
							<td>${item.getAmount()}</td>
							<td><a
								href="${pageContext.request.contextPath}/user/delete/${item.getId()}">
							</a></td>
						</tr>
					</c:forEach>

				</table>


			</c:otherwise>
		</c:choose>
		<br>

		<a href="${pageContext.request.contextPath}/user/checkout"> CheckOut</a>
</body>
</html>