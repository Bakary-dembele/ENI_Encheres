package fr.eni.encheres.Servlets;

import java.io.IOException;

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
 * Servlet implementation class SuprimerCompte
 */
@WebServlet("/suprimerCompte")
public class SuprimerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Supprimer le compte
		HttpSession session = request.getSession();
		String pseudo = ((Utilisateurs) session.getAttribute("userConnected")).getPseudo(); //cast utilisateur en recuperant son Pseudo en memoire
		//Appeler utilisateurManager
		UtilisateurManager mgt;
		mgt = UtilisateurManager.getInstance();
		mgt.delete(pseudo);
		// Fermer la session
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		request.setAttribute("supprimer-compte", "Votre compte a bien été supprimer"); //Afficher un message de supprission de compte 
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
