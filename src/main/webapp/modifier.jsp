<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
	<div class="card card-primary">
		<div class="card-header bg-primary text-white">Modifier offre</div>
		<div class="card-body">
			<form action="modifier.php" method="post">
				<input type="hidden" name="id" value="${offre.id }" />
				<input type="hidden" name="date" value="${offre.date }"/>
				<div class="form-group">
					<label class="control-label">Titre</label>
					<input class="form-control" name="titre" type="text" value="${offre.title }"/>
				</div>
				<div class="form-group">
					<label class="contol-label">Profil</label>
					<input class="form-control" name="profil" type="text" value="${offre.profil }"/>
				</div>
				<div class="form-group">
					<label class="control-label">Description</label>
					<input class="form-control" name="description" type="text" value="${offre.description }"/>
				</div>
				<div class="form-group">
					<label class="control-label">type contrat</label>
					<select name="type" class="form-control">
						<c:forEach items="${types}" var="type">
							<option value="${type.idType }" 
								<c:if test="${type.idType eq offre.typeContrat.idType}">
									selected
								</c:if> 
							>${type.libelle}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<br/>
					<input type="submit" class="btn btn-primary" value="update"/>
				</div>	
			</form>
		</div>
	</div>
</body>
</html>