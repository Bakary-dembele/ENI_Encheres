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
	<link rel="stylesheet" href="css/seConnecter.css">
	<!-- titre -->
	<title> Eni-Encheres </title>
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
		<form action="seConnecter" method="post">
			<div class="identifiant">
				<div class="identifiant_un">
					<label>Identifiant :</label>
					<input type="text" id="pseudo" name="pseudo" value="${cookie.pseudo.value}" placeholder="NinaJaa"><br>
					<label>Mot de passe :</label>
					<input type="password" id="motDePasse" name="motDePasse" value="${cookie.motDePasse.value} ${erreur}"><p style="color:red">${erreur}</p><br/> 
				</div>
				<div class="connexion">
					<div class="identifiant_deux">
						<input type="submit" id="connecxion" name="connecxion" value="Connecxion">
					</div>
					<div class="cookie_password">
						<div><input type="checkbox" name="sesouvenir" value="">
							<label for="identifiant">Se souvenir de moi </label>
						</div>
						<div>
							<a href="#">Mot de passe oublié</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="compte">
			<a href="<%=request.getContextPath()%>/inscription"><input type="submit" id="creer" name="creer" value="Créer un compte"></a>
		</div>
	</main>





	<!-- Footer -->
	<footer>
		<p>Copyright&copy;2020 Eni-enchères</p>
	</footer>

</body></html>
