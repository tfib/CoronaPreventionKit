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

	<a href="showProductsToAdd.jsp"> Click to View the list of
		Available Products</a>
	<h4>
		<b> Items in the Kit: </b>
	</h4>
	<br>
	<form action="calculateTotals">
		<c:choose>
			<c:when
				test="${selectedproducts==null || selectedproducts.isEmpty() }">
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
					</tr>
					<c:forEach items="${selectedproducts}" var="product">
						<tr>
							<td>${product.productId}</td>
							<td>${product.pName}</td>
							<td>${product.pcost}</td>
							<td>${product.pDescription}</td>
							<td><input type="text"
								name="quantityOfProduct${product.productId}"
								pattern="[0-9]+" required></td>
						</tr>
					</c:forEach>

				</table>
			</c:otherwise>

		</c:choose>
		<br>

		<button>Save Items</button>
	</form>

	<%
		if (request.getAttribute("Message") != null) {
	%>
	<%
		String message = request.getAttribute("Message").toString();
	%>
	<%=message%>
	<%
		}
	%>
</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>