<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
	<%@include file="header.jsp" %>
	<h1 class="text-white bg-primary mt-3">Liste des offres</h1>
	<table class="table table-striped">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Titre</th>
			<th>Description</th>
			<th>Profil</th>
			<th>Date Publication</th>
			<th>type de contrat</th>
		</tr>
		<c:forEach items="${offres}" var="offre">
			<c:forEach items="${offre.candidats}" var="candidat">
			<tr>
			
				<td>${candidat.nom}</td>
				<td>${candidat.prenom}</td>
				<td>${offre.title}</td>
				<td>${offre.description}</td>
				<td>${offre.profil}</td>
				<td>${offre.date}</td>
				<td>${offre.typeContrat.libelle}</td>
				<td><a class="btn btn-primary" href="telechargerCV.php?id=${candidat.id}">telecharger cv</a></td>
				<td><a class="btn btn-danger" href="annuler.php?id=${offre.id}">refuser</a></td>
			</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>