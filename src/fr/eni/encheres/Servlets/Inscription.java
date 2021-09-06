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
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// Pour acceullir les erreurs du formailaire
		Map<String, String> erreurs = new HashMap<String, String>();

		// Par défault le crédit est à 0 et administrateur à false
		int credit = 0;
		boolean administrateur = false;

		// Ajouter utilisateurs
		String resultat; // récuperer des champs du formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");

		HttpSession session;
		Utilisateurs u;
		u = new Utilisateurs(0, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit,
				administrateur);
		UtilisateurManager utilisateurManager;
		utilisateurManager = UtilisateurManager.getInstance();
		utilisateurManager.inserUtilisateur(u);
		session = request.getSession();
		session.setAttribute("userConnected", u);

		
		 /* Validation du champ email. */
        try {
            validationEmail(email);
        } catch ( Exception e ) {
            erreurs.put(email, e.getMessage());
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            erreurs.put(motDePasse, e.getMessage() );
        }
		
		
		// Verification de password
		motDePasse = request.getParameter("motDePasse");
		confirmation = request.getParameter("confirmation");

		if (motDePasse.equals(confirmation))
		{	
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connecter.jsp");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			request.setAttribute("erreur", "Les mots de passe entrés sont différents , merci de les saisir à nouveau");
			rd.forward(request, response);
		}

	}

	/**
	 * Valide l'adresse mail saisie.
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

	
	
	
	/**
	 * Valide les mots de passe saisis.
	 */
	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/**
	 * Valide le nom d'utilisateur saisi.
	 */
	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

}
