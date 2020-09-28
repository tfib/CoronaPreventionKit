<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header" />
	<a href="${pageContext.request.contextPath}/admin/product-entry">
		Add New Product</a>

	<c:if test="${errMsg!= null}">
		<i>${errMsg}</i>
	</c:if>

	<c:choose>
		<c:when test="${products == null || products.isEmpty() }">
			<p>No Products are Available</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Cost</th>
					<th>Product Description</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${products }" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.productName }</td>
						<td>${product.cost }</td>
						<td>${product.productDescription }</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/product-delete/${product.id}">DELETE</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/footer" />
</footer>
</html>