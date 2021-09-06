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
	<link rel="stylesheet" href="css/modifierProfil.css">
	<!-- titre -->
	<title>Eni-Encheres</title>
	
	<style>
	    .annuler a{
	    padding: 25px 130px;
	    background-color: #FF9472;
	    border: 1px solid #FF9472;
	    color: #fff;
	    transition: 1.5s;
	    position: absolute;
	    top: 650px;
	    left: 870px
     }
     .annuler a:hover{
	  background-color: #E61C15;
	  border: 1px solid #E61C15;
	  text-decoration :none;
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
		<h2>Mon profil</h2>
		
		
		<p class="text-center font-weight-bold text-primary">${resultat}</p>
		
		<c:if test="${!empty erreurs}">
		    <p class="text-center text-info">"${erreurs['pseudo']}"</p>
		    <p class="text-center text-info">"${erreurs['pseudoUnique']}"</p>
		    <p class="text-center text-info">"${erreurs['email']}"</p>
		    <p class="text-center text-info">"${erreurs['motDePasse']}"</p>
		    <p class="text-center text-info">"${erreurs['confirmation']}"</p>
		    <p class="text-center text-info">"${erreurs['motDePasseActuel ']}"</p>
		    
		</c:if>
		
		<form action="modifierProfil" method="post">
			<div class="formulaire">
				<div>
					<label for="pseudo">Pseudo </label>
					<input type="text" id="pseudo" name="pseudo" value="<c:out value="${param.pseudo}"/><c:if test="${empty erreurs}">${userConnected.pseudo}</c:if>" required><br />
					<label for="prenom">Prénom </label>
					<input type="text" id="prenom"  name="prenom"  value="<c:out value="${param.prenom}"/><c:if test="${empty erreurs}">${userConnected.prenom}</c:if>" required><br />
					<label for="telephone">Téléphone </label>
					<input type="text" id="telephone" name="telephone" value="<c:out value="${param.telephone}"/><c:if test="${empty erreurs}">${userConnected.telephone}</c:if>" required><br />
					<label for="telephone">Code postal </label>
					<input type="text" id="codePostal" name="codePostal" value="<c:out value="${param.codePostal}"/><c:if test="${empty erreurs}">${userConnected.codePostal}</c:if>" required><br />
					<label for="motpasse">Mot de passe actuel</label>
					<input type="password" id="motDePasseActuel" name="motDePasseActuel" value="" required><br />
					<label for="motpasse">Nouveau mot de passe</label>
					<input type="password" id="motDePasse" name="motDePasse" value="" required><br />		
				</div>
				<div>
					<label for="nom">Nom </label>
					<input type="text" id="nom" name="nom" value="<c:out value="${param.nom}"/><c:if test="${empty erreurs}">${userConnected.nom}</c:if>" required><br />

					<label for="email">Email </label>
					<input type="text" id="email" name="email" value="<c:out value="${param.email}"/><c:if test="${empty erreurs}">${userConnected.email}</c:if>"><br />

					<label for="rue">Rue </label>
					<input type="text" id="rue" name="rue" value="<c:out value="${param.rue}"/><c:if test="${empty erreurs}">${userConnected.rue}</c:if>" required><br />
					<label for="ville">Ville </label>
					<input type="text" id="ville" name="ville" value="<c:out value="${param.ville}"/><c:if test="${empty erreurs}">${userConnected.ville}</c:if>" required><br /><br /><br /><br />

					<label for="confirmation">Confirmation </label>
					<input type="password" name="confirmation" id="confirmation" value="" required> <br />
				</div>
				<div id="credit">
				<p>Credit : </p>
			</div>
			</div>
			
			
			<div class="creer">
				<input type="submit" id="enregistrer" name="enregistrer" value="Enregistrer">
				
			</div>
		</form>
		<a href="${pageContext.request.contextPath}/modifierProfil">enregistrer</a>
		<div class="annuler">	
			 <a href="${pageContext.request.contextPath}/suprimerCompte">Supprimer</a> 
	   </div>
	

	</main>


	<!-- Footer -->
	<footer>
		<p>Copyright&copy;2020 Eni-enchères</p>
	</footer>

</body></html>
