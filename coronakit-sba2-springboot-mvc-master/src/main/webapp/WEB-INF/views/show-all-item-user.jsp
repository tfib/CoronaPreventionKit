<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>

<jsp:include page="${pageContext.request.contextPath}/header" />

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
						<td>${product.id}</td>
						<td>${product.productName}</td>
						<td>${product.cost}</td>
						<td>${product.productDescription}</td>
						<td><a href="${pageContext.request.contextPath}/user/add-to-cart/${product.id}">Add To
								Kit</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>

	</c:choose>

</body>
</html>