<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="${pageContext.request.contextPath}/header" />
</head>
<body>

	<h3>Add New Product</h3>

	<c:if test="${msg!= null}">
		<i>${msg}</i>
	</c:if>
	<form:form
		action='${pageContext.request.contextPath}/admin/product-save'
		method="POST" modelAttribute="product">
		<div>
			<form:label path="id">Product Id</form:label>
			<form:input type="number" path="id" />
			<form:errors path="id" />
		</div>
		<div>
			<form:label path="productName">Product Name</form:label>
			<form:input type="text" path="productName" />
			<form:errors path="productName" />
		</div>
		<div>
			<form:label path="cost">Cost</form:label>
			<form:input type="number" path="cost" />
			<form:errors path="cost" />
		</div>
		<div>
			<form:label path="productDescription">Product Description</form:label>
			<form:input type="String" path="productDescription" />
			<form:errors path="productDescription" />
		</div>

		<button>SAVE</button>
	</form:form>


</body>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/footer"></jsp:include>
</footer>
</html>