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
	<link rel="stylesheet" href="css/inscription.css">
	<!-- titre -->
	<title>Eni-Encheres</title>
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
	 

		<h2>Créer un compte</h2>
		<form action="inscription" method="post">
			<div class="formulaire">
				<div>
					<label for="pseudo">Pseudo </label>
					<input type="text" id="pseudo" name="pseudo" value="" required><br />
					<label for="prenom">Prénom </label>
					<input type="text" id="prenom"  name="prenom" value="" required><br />
					<label for="telephone">Téléphone </label>
					<input type="text" id="telephone" name="telephone" value="" required><br />
					<label for="telephone">Code postal </label>
					<input type="text" id="codePostal" name="codePostal" value="" required><br />
					<label for="motpasse">Mot de passe </label>
					<input type="password" id="motDePasse" name="motDePasse" value="" required><br /> <p style="color:red">${erreurs}</p><br/>
				</div>
				<div>
					<label for="nom">Nom </label>
					<input type="text" id="nom" name="nom" value="" required><br />

					<label for="email">Email </label>
					<input type="text" id="email" name="email" value="" required><br/>
					

					<label for="rue">Rue </label>
					<input type="text" id="rue" name="rue" value="" required><br />
					<label for="ville">Ville </label>
					<input type="text" id="ville" name="ville" value="" required><br />

					<label for="confirmation">Confirmation </label>
					<input type="password" name="confirmation" id="confirmation" value="" required> <br />
				</div>
			</div>
			<div class="creer">
				<input type="submit" id="creer" name="creer" value="Créer">
			</div>
		</form>
		<div class="annuler">
			
			<a href="<%=request.getContextPath()%>/index"><input type="submit" id="annuler" name="annuler" value="Annuler"></a>  
			
		</div>	
		     
		     <p class="text-center font-weight-bold text-primary">${resultat}</p>

	</main>


	<!-- Footer -->
	<footer>
		<p>Copyright&copy;2020 Eni-enchères</p>
	</footer>

</body></html>
