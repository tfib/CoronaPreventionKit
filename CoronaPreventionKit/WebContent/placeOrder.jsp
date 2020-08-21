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
	<form action="orderConfirmation" action="post">
		<label>
			<h4>
				<b>Please enter the complete shipping address:</b>
			</h4> <textarea name="address" rows="4" cols="25"></textarea>
		</label>
		<button>Confirm Order</button>
	</form>
</body>
<footer>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>