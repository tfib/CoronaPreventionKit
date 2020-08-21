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

	<p>
		<a href="welcomeAdmin.jsp">Go To Admin Welcome Page</a>
	</p> 
	<br>
	<h4>
		<b> Products List: </b>
	</h4>
	<br>
	<c:choose>
		<c:when test="${ products==null || products.isEmpty() }">
			<h4>No Products Available</h4>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Cost</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td>${product.pName}</td>
						<td>${product.pcost}</td>
						<td>${product.pDescription}</td>
						<td><a href="doEdit?pid=${product.productId}">Edit</a> <br>
							<a href="deleteProduct?pid=${product.productId}">Delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</c:otherwise>

	</c:choose>
</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>