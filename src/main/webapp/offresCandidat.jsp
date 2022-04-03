<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <%@include file="header.jsp" %> --%>
	<h1 class="text-white bg-primary mt-3">Liste des offres</h1>
	<table class="table table-striped">
		<tr>
			<th>Titre</th>
			<th>Description</th>
			<th>Profil</th>
			<th>Date Publication</th>
			<th>type de contrat</th>
		</tr>
		<c:forEach items="${offres}" var="offre">
			<tr>
				<td>${offre.title}</td>
				<td>${offre.description}</td>
				<td>${offre.profil}</td>
				<td>${offre.date}</td>
				<td>${offre.typeContrat.libelle}</td>
				<td><a class="btn btn-success" href="postuler.php?id=${offre.id}">postuler</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>