package fr.eni.encheres.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.bo.Utilisateurs;
import fr.eni.encheres.blll.UtilisateurManager;

/**
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/modifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // Encodage
		HttpSession session = request.getSession(); // session

		// Pour acceullir les erreurs du formailaire
		Map<String, String> erreurs = new HashMap<String, String>();

		// récuperer des champs du formulaire
		String resultat;

		// Récuperer les champs de formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");
		// Créer de méthode pour le pseudo, email, motdepasse déjà en memoire BDD
		String pseudoEnMemoire = ((Utilisateurs) session.getAttribute("userConnected")).getPseudo();
		String emailEnMemoire = ((Utilisateurs) session.getAttribute("userConnected")).getEmail();
		String motDePasseEnMemoire = ((Utilisateurs) session.getAttribute("userConnected")).getMotDePasse();
		
		// Récuperer l'id de l'utilisateur
		int noUtilisateur = retriveID(pseudoEnMemoire, emailEnMemoire);

		// Vérification avant d'ajouter l'utilisateur
		if (!email.equals(emailEnMemoire)) {
			// validation du champ email
			try {
				validationEmail(email);
			} catch (Exception e) {
				erreurs.put("email", e.getMessage());
			}

			// vérification email Unique
			try {
				ExistenceEmail(email);
			} catch (Exception e) {
				erreurs.put("emailUnique", e.getMessage());
			}
		}

		if (!pseudo.equals(pseudoEnMemoire)) {
			// validation du champ pseudo
			try {
				validationPseudo(pseudo);
			} catch (Exception e) {
				erreurs.put("pseudo", e.getMessage());
			}

			// vérification pseudo Unique en BDD
			try {
				ExistencePseudo(pseudo);
			} catch (Exception e) {
				erreurs.put("pseudo", e.getMessage());
			}
		}

		if (motDePasseActuel != null && motDePasseActuel.trim().length() != 0) {
			// validation du champ de mot de passe actuel
			try {
				ValidationMotDepasseActuel(motDePasseActuel);
			} catch (Exception e) {
				erreurs.put("motDePasseActuel", e.getMessage());
			}

			// validation du mot de passe en BDD via le pseudo garder en session
			try {
				existenceMotDepasse(motDePasseActuel, pseudoEnMemoire);
			} catch (Exception e) {
				erreurs.put("motDePasseActuel", e.getMessage());
			}
		}

		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			// validation du champ du nouveau mot de passe et confirme
			try {
				validationMotDePasse(motDePasse, confirmation);
			} catch (Exception e) {
				erreurs.put("motdepasse", e.getMessage());
			}
		}

		// Intilisation du résultat global de la validation
		if (erreurs.isEmpty()) { // isEmpty () vérifie si cette chaîne est vide ou non. Il renvoie vrai , si la
									// longueur de la chaîne est 0 sinon faux
			resultat = "Profil mise à jour";
			request.setAttribute("resultat", resultat);
			Utilisateurs u = null;

			int credit = ((Utilisateurs) session.getAttribute("userConnected")).getCredit();
			boolean administrateur = ((Utilisateurs) session.getAttribute("userConnected")).isAdministrateur();

			// Ajouter l'utilisteur dans la BDD
			if (motDePasse.trim().length() == 0 && confirmation.trim().length() == 0) {
				u = new Utilisateurs(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,motDePasse, credit, administrateur);
			} else {
				u = new Utilisateurs(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,motDePasse, credit, administrateur);
			}
			UtilisateurManager mgt;
			mgt = UtilisateurManager.getInstance();
			mgt.updatrProfil(u);
			session = request.getSession();
			session.setAttribute("userConnected", u);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);

		  } else {
			resultat = "Echec de la mise à jour";
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("resultat", resultat);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);
		}
	}

	/*
	 * Récuperer l'id de l'utilisateur
	 */
	private int retriveID(String pseudoEnMemoire, String emailEnMemoire) {
			UtilisateurManager mgt = UtilisateurManager.getInstance();
			
			return 0;
		}

	/*
	 * Valider l'adresse mail saisie
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}

	}

	/*
	 * Valider de mot de passe actuel saisie
	 */
	private void ValidationMotDepasseActuel(String motDePasseActuel) throws Exception {
		if (motDePasseActuel != null && motDePasseActuel.trim().length() != 0) {
			if (motDePasseActuel.trim().length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
			}
		}
	}

	/*
	 * Valider de nouveau mot de passe saisie
	 */
	private void validationMotDePasse(String motdepasse, String confirmation) throws Exception {
		if (motdepasse != null && motdepasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			if (!motdepasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motdepasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/*
	 * Valider de speudo de l'utilisateur
	 */
	private void validationPseudo(String pseudo) throws Exception {
		if (pseudo != null && pseudo.trim().length() < 3) {
			throw new Exception("Le pseudo de l'utilisateur doit contenir au moins 3 caractères");
		} else if (!pseudo.matches("[A-Za-z0-9]*"))
			;
		throw new Exception("Le pseudo ne doit contenir que les caractères alphanumériques");
	}

	private void existenceMotDepasse(String motDePasseActuel, String pseudoEnMemoire) {
		// TODO Auto-generated method stub

	}

	private void ExistencePseudo(String pseudo) {
		// TODO Auto-generated method stub

	}

	private void ExistenceEmail(String email) {
		// TODO Auto-generated method stub

	}

}
