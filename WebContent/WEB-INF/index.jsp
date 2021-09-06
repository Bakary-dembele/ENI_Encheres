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
	<link rel="stylesheet" href="css/index.css">
	<!-- titre -->
	<title>Eni-Encheres</title>
</head>

<body>

	<!-- Navigation -->


	<!-- Header -->
	<header>
		<div class="">
			<div class="header" >
				<p><a href="<%=request.getContextPath()%>/index">ENI Enchères</a></p>            
               <a href="<%=request.getContextPath()%>/seConnecter">S'inscrire - Se connecter</a>   
			</div>
		</div>
	</header>


	<!-- Main -->
	<main>
		<div>
			<div class="row">
				<h3>Liste des enchères</h3>
			</div>
		</div>

		<div>
			<div>
				<div class="categories_rechercher">
					<div id="filtre_categorie">
						<div class="filtre" class="row">
							<!-- filtre-->
							<p>Filtres :</p><br>
							<input type="text" id="article" name="article" value="" placeholder="Le nom de l'artictle contient" />
						</div>
						<div class="rechercher">
							<!-- catégories-->
							<form action="index" method="post">
								<label for="categorie"> Catégorie :</label>
								<select name="toutes" id="toutes">
									<option value="toutes">Toutes</option>
									<option value="information">Information</option>
									<option value="ameublement">Ameublement</option>
									<option value="vetement">Vêtement</option>
									<option value="sport&Loisirs">Sport&amp;Loisirs</option>
								</select>
							</form>
						</div>
					</div>
					<div id="rechercher">
						<!-- Rechercher-->
						<input type="text" id="rechercher" name="rechercher" placeholder="Rechercher">
					</div>
				</div>
			</div>

			<div>
				<div class="images">
					<div class="images_enfant">
						<div>
							<!-- Images-->
							<img src="img/pc_gamer.jpg" alt="Girl in a jacket" width="200" height="200">
						</div>
						<div>
							<p><a href="detailVente.jsp"> PC Gamer pour travailler</a></p>
							<p>Prix : 210 points</p>
							<p>Fin de l'entrée : 10/08/2018</p>
							<p>Vendeur : jojo44</p>
						</div>
					</div>
					<div class="images_enfant">
						<div>
							<!-- Images-->
							<img src="img/rocket_stoves.jpg" alt="Girl in a jacket" width="200" height="200">
						</div>
						<div>
							<p><a href="detailVente.jsp"> PC Gamer pour travailler</a></p>
							<p>Prix : 185 points</p>
							<p>Fin de l'entrée : 09/10/2018</p>
							<p>Vendeur : NineJea44</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- Footer -->
	<footer>
		<p>Copyright&copy;2020 Eni-enchères</p>
	</footer>





</body></html>
