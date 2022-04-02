<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<title>Connexion</title>
</head>
<body>
	<%@include file="header2.jsp" %>
	<div class="d-flex justify-content-center">
		<h1>Espace Candidat</h1>
	</div>
	<div class="d-flex justify-content-center">
			<p>Vous devez s'authentifier pour pouvoir postuler au differents offres d'emplois.
			</p>
	</div>
	<div class="d-flex justify-content-center">
		<div class="card mt-5 w-25">
			<div class="card-header">s'identifier</div>
			<div class="card-body">
			<form action="loginCandidat.php" method="post">
				<div class="form-group">
					<label class="control-label">CIN</label>
					<input  name="cin" type="text"/>
				</div>
				<br/>
				<div class="form-group">
					 <button class="btn btn-primary" type="submit">s'identifier</button>
				</div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>