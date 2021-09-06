<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<!-- boostrap -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
	<!-- font -->
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400&display=swap" rel="stylesheet">
	<!-- css -->
	<link rel="stylesheet" href="css/AfficherProfil.css">
	<!-- titre -->
	<title>Eni-Encheres</title>
	
	<style>
	    
	    footer{
	    margin-top: 280px;
	    }
	     
	</style>
	
</head>
    
<body>

	<!-- Header -->
	<header>
		<div>
			<div class="header">
				<p><a href="<%=request.getContextPath()%>/index">ENI Enchères</a></p>
			</div>
		</div>
	</header>

	<!-- Main -->
	<main>
		<form action="modifierProfil" method="post">
			
					<p> <label for="pseudo">Pseudo :</label><c:out value="${userConnected.pseudo}" /></p>
					<p> <label for="pseudo">Nom : </label>
						<c:out value="${userConnected.nom}" />
					</p>
					<p> <label for="pseudo">Prénom :</label>
						<c:out value="${userConnected.prenom}" />
					</p>
					<p> <label for="pseudo">Email :</label>
						<c:out value="${userConnected.email}" />
					</p>
					<p> <label for="pseudo">Téléphone :</label>
						<c:out value="${userConnected.telephone}" />
					</p>
					<p> <label for="pseudo">Rue :</label>
						<c:out value="${userConnected.rue}" />
					</p>
					<p> <label for="pseudo">Code postal :</label>
						<c:out value="${userConnected.codePostal}" />
					</p>
					<p> <label for="pseudo">Ville :</label>
						<c:out value="${userConnected.ville}" />
					</p>
				
		</form>
		<div class="compte">
			
				<a href="<%=request.getContextPath()%>/modifierProfil"><input type="submit" id="connecxion" name="connecxion" value="Modifier"></a>  
		</div>
	</main>





	<!-- Footer -->
	<footer>
		<p>Copyright&copy;2020 Eni-enchères</p>
	</footer>

</body>

</html>
