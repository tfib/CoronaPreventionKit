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
		<b> Products List: </b>
	</h4>
	<br>
	<c:choose>
		<c:when
			test="${ availableproducts==null || availableproducts.isEmpty() }">
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
				<c:forEach items="${availableproducts}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td>${product.pName}</td>
						<td>${product.pcost}</td>
						<td>${product.pDescription}</td>
						<c:choose>
							<c:when test="${selectedproductids.contains(product.productId)}">
								<td>Added To Kit</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="addToKit?pid=${product.productId}">Add To
										Kit</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>

			</table>
		</c:otherwise>

	</c:choose>
	<br>
	<form action="showKit">
		<button>View Kit</button>
	</form>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form action="placeOrder.jsp">
		<button>Place Order</button>
	</form>
</body>

<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>