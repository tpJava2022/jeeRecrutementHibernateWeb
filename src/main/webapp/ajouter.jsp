<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ajout d'un offre</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
	<div class="card card-primary">
		<div class="card-header bg-primary text-white">nouvel offre</div>
		<div class="card-body">
			<form action="ajouter.php" method="post">
				<div class="form-group">
					<label class="control-label">Titre</label>
					<input class="form-control" name="titre" type="text"/>
				</div>
				<div class="form-group">
					<label class="contol-label">Profil</label>
					<input class="form-control" name="profil" type="text"/>
				</div>
				<div class="form-group">
					<label class="control-label">Description</label>
					<input class="form-control" name="description" type="text"/>
				</div>
				<div class="form-group">
					<label class="control-label">type contrat</label>
						<select name="type">
							<c:forEach items="${types}" var="type">
								<option value="${type.idType }" >${type.libelle }</option>
							</c:forEach>
						</select>
					
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="save"/>
				</div>	
			</form>
		</div>
	</div>

</body>
</html>