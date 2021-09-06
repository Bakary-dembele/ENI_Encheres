package fr.eni.encheres.Servlets;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.eni.encheres.bll.bo.Article;
import fr.eni.encheres.bll.bo.Retraits;
import fr.eni.encheres.bll.bo.Utilisateurs;
import fr.eni.encheres.blll.ArticleManager;
import fr.eni.encheres.blll.UtilisateurManager;

/**
 * Servlet implementation class Article
 */
@WebServlet("/pageArticle")
@MultipartConfig( 
        fileSizeThreshold   = 1024 * 1024 * 2,  // 2 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 50 // 50 MB
)
public class pageArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Dépose l'image
	private static final String DEPOSE_IMG ="C:\\Users\\Bakary\\Desktop\\wspLinproy\\ENI-Enchere\\WebContent\\img"; 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récup la session en cours
		HttpSession session = request.getSession();
		//Acceuillir les erreurs du formulaire
		Map<String, String> erreurs = new HashMap<String, String>();
		
		//Récup les variables du formulaire
		String nom_article = request.getParameter("article");
		String descrption = request.getParameter("descrption");
		String categorie = request.getParameter("categorie");
		int prix_initial = Integer.parseInt(request.getParameter("prixInitial"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"); //
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
		LocalDateTime  date_debut_encheres = null;
		LocalDateTime date_fin_encheres = null;
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		int no_utilisateur = 0;
		int prix_vente = 0;
		int acheteur =0;
		
		//Ajouter contrôle sur la date début enchère et peut être fin encheres
		try {
			  date_debut_encheres = LocalDateTime.parse(request.getParameter("dateDebutDeEncheres"),dtf); //
			  date_fin_encheres = LocalDateTime.parse(request.getParameter("dateFinDeEncheres"),dtf); 
		}catch(Exception e) {
			e.printStackTrace();
	      }
		
		
		//Récup le fichier photo
		Part part = request.getPart("uploadPhoto"); //
		//Déterminition d'un champs classique ou de champ de type fichier
		String mon_img = getMonFichier(part);
		
		//Je fait l'écriture si fichier img à uploader
		if(mon_img != null) {
			String savePath = DEPOSE_IMG + File.separator + mon_img; //
			File fileSveDic = new File(savePath); //
			part.write(savePath + File.separator); //	
		}
		
		
		//Récup Id utilisateuer
		try {
			String pseudoEnMemoire = ((Utilisateurs)session.getAttribute("userConnected")).getPseudo();
			String emailEnMemoire = ((Utilisateurs)session.getAttribute("userConnected")).getEmail();
			//Récup id de l'utilisateur
			int noUtilisateur = retriveID(pseudoEnMemoire, emailEnMemoire);
			
		}catch(Exception e) {
			e.printStackTrace();
	      }
		
		
		//Traitement pour la BDD
		int no_categorie = numeroCategorie(categorie);
		System.out.println("n° catégories : " + no_categorie);
		Article art;
		Retraits ret;
		art = new Article(0, nom_article,descrption,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,mon_img ,acheteur);
		ret = new Retraits(0, rue,code_postal,ville);
		ArticleManager mgt;
		mgt = ArticleManager.getInstance();
		mgt.inserArticle(art, ret);
		
		session.setAttribute("addSucces", "Article a été ajouté pour les enchères");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
		rd.forward(request, response);
					
	}

	
	
	//
	private int numeroCategorie(String categorie) {
		int no_categorie =0;
		switch (categorie) {
		case "Toutes" : no_categorie = 1;
		break;
		case "Informatique" : no_categorie =2;
		break;
		case "Ameublement" : no_categorie =3;
		break;
		case "Vêtement" : no_categorie =4;
		break;
		case "Sport&Loisirs" :no_categorie =5;
		}
		return no_categorie;
	}
	
	
	private String getMonFichier(Part part) {
		/* Boucle sur chacun des parametres de l'en-tête "content-disposition", */
		for(String contentDisposition : part.getHeader("content-disposition").split(",")) { //
			/* Recherche de l'éventuelle présence du paramètre "filename" */
			if(contentDisposition.trim().startsWith("filename")) {//
				/* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier (sans guillements) */
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		/* Et pour terminer , si rien n'a été trouvé, il retourne null */
		return null;
		
	}
	
	
	/*
	 * Méthode pour retrouve l'id de l'utilisateur qui est en session
	 * @param pseudoEnMemoire
	 * @param emailEnMemoire 
	 * @param noUtilisateur
	 *
	 */
	private int retriveID(String pseudoEnMemoire, String emailEnMemoire) {
		UtilisateurManager mgt = UtilisateurManager.getInstance();
		int noUtilisateur = mgt.findById(pseudoEnMemoire, emailEnMemoire);
		return noUtilisateur;
	}


}















