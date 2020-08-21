<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<p>
		<a href="doListProducts">Go To Products List</a>
	</p>
	<br> 
	<h4>
		<b>Please enter the product details</b>
	</h4>
	<br>
	<br>

	<form action="newProductSave" method="post">
		<label> Product ID: <input type="text" name="pid" required>
		</label> <br> <label> Product Name: <input type="text"
			name="pname" required></label><br> <label> Product Cost:
			<input type="text" name="pcost" required>
		</label><br> <label> Product Description: <input type="text"
			name="pdesc"></label>
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