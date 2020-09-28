<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<style>
form input{
position:fixed; 
right:30px; 
top:20px
}
</head>
<body>
<jsp:include page="/header" />
<br> <br>
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>


<jsp:include page="${pageContext.request.contextPath}/header" />
	<a href="${pageContext.request.contextPath}/admin/product-entry">
		Add New Product</a> <BR> <br>

	<c:if test="${msg!= null}">
		<i>${msg}</i>
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
	<jsp:include page="/footer" />
</footer>
</html>