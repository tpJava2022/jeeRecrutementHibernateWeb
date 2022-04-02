<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<title>identification</title>
</head>
<body>
<%@include file="header2.jsp" %>
<div class="d-flex justify-content-center">
		<h1>Espace Recruteur</h1>
</div>
<div class="d-flex justify-content-center">
<div class="card mt-5 w-25">
	<div class="card-header">s'identifier</div>
	<div class="card-body">
	<form action="login.php" method="post">
		<div class="form-group">
			<label class="control-label">CIN</label>
			<input  name="cin" type="text"/>
		</div>
		<br/>
		<div class="form-group">
			 <button class="btn btn-primary">s'identifier</button>
		</div>
	</form>
	</div>
</div>
</div>

</body>
</html>