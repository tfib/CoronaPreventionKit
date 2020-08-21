<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<br>
	<p>
		<a href="doListProducts">View Products List</a>
	</p>
	<br>
	<h4>
		<b>Product Edit Form:</b>
	</h4>
	<br>
	<br>



	<form action="editSave" method="post">
		<label> Product ID: <input type="text" name="pid"
			value="${product.productId}" readonly>
		</label> <br> <label> Product Name: <input type="text"
			name="pname" value="${product.pName}" required></label><br> <label>
			Product Cost: <input type="text" name="pcost"
			value="${product.pcost}" required>
		</label><br> <label> Product Description: <input type="text"
			name="pdesc" value="${product.pDescription}"></label>
		<button>Save</button>
	</form>
	<br>
	<br>
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