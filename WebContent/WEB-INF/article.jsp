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
	<link rel="stylesheet" href="css/article.css">
	<!-- titre -->
	<title>Eni-Encheres</title>
	
	<style>
	    form #photoArticle{
	    display: flex;
	    justify-content: flex-start;
	    margin-bottom: -50px;
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


	<!---Main--->
	<main>
		<div>
			<div class="row">
				<h2>Nouvelle vente</h2>
			</div>
		</div>

		<div class="container">
			<div>
				<img src="img/pc_gamer.jpg" alt="Girl in a jacket" width="400" height="400">
			</div>

			<form action="pageArticle" method="post" enctype="multipart/form-data">
			<p class="text-center text-info font-weight-bold">${addSucces}</p>
				<div>
					<label for="article">Article :</label>
					<input type="text" name="article" id="article" placeholder="Tapez le nom de votre article">
				</div>

				<div>
					<label for="description">Description :</label>
					<textarea id="descrption" name="descrption" rows="5" cols="54"> Tapez la description de votre article</textarea>
				</div>

				<div id="categorie">
					<label for="categoris">Catégorie </label>
					<select name="categorie" id="categorie">
						<option value="toutes">Toutes</option>
						<option value="information">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vetement">Vêtement</option>
						<option value="sport&Loisirs">Sport&amp;Loisirs</option>
					</select>
				</div>

				<div id="photoArticle">
					<label for="photoarticle">Photo de l'article</label>
					<div id="list" class="border" style="width:90px; height:90px;"></div>
					<input type="file" id="uploadPhoto"  name="uploadPhoto" accept="image/png, image/jpeg" onchange=" readFilesAndDisplayPreview(files);" >
				</div>

				<div>
					<label for="miseprix">Prix initial</label>
					<input type="number" name="prixInitial" id="miseAPrix" placeholder="Tapez le montant de l'article">
				</div>

				<div>
					<label for="debut">Début de l'enchères</label>
					<input type="datetime-local" name="dateDebutDeEncheres" id="dateDebutDeEncheres">
				</div>

				<div>
					<label for="fin">Fin de l'enchères</label>
					<input type="datetime-local" name="dateFinDeEncheres" id="dateFinDeEncheres" >
				</div>

				<fieldset>
					<legend>Retrait</legend>
					<label for="rue">Rue :</label>
					<input type="text" name="rue" id="rue"  value="${userConnected.rue}">
					<label for="codepostal">Code postal :</label>
					<input type="text" name="codePostal" id="codePostal"  value="${userConnected.codePostal}">
					<label for="ville">Ville :</label>
					<input type="text" name="ville" id="ville"  value="${userConnected.ville}">
				</fieldset>

				<div class="section-btn">
					<div class="enregistrer">
						<input type="submit" id="enregistrer" name="enregistrer" value="Enregistrer">
					</div>	
				</div>

			</form>
		
			<div class="annuler">
						<a href="<%=request.getContextPath()%>/connecter"><input type="submit" id="annuler" name="annuler" value="Annuler"></a>
					</div>			
		   </div>
		   <div class="retour">
						<a href="<%=request.getContextPath()%>/index"><input type="submit" id="annuler" name="annuler" value="Retour"></a>
					</div>			
		   </div>
		   
		 	   
        
	</main>

     <script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="90" alt="image produit" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });


                    reader.readAsDataURL( file );
                }
            }
        </script>

	<!-- Footer -->
	<footer>
		<p>Copyright&copy;2020 Eni-enchères</p>
	</footer>

</body></html>
