
package fr.eni.encheres.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.bo.Utilisateurs;
import fr.eni.encheres.blll.UtilisateurManager;

/**
 * Servlet implementation class SeConnecte
 */
@WebServlet("/seConnecter")
public class SeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Délagation
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/seConnecter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Créer une session
		HttpSession session;

		// Créer les variables pour le login
		String pseudo = request.getParameter("pseudo");
		System.out.println(pseudo);
		String motDePasse = request.getParameter("motDePasse");
		System.out.println(motDePasse);
		String sesouvenir = request.getParameter("sesouvenir");
		Utilisateurs u;
		UtilisateurManager mgt;
		mgt = UtilisateurManager.getInstance();
		u = mgt.loginSession(pseudo, motDePasse);

		// Condition
		if (pseudo.contains("@")) {
			u = mgt.loginSession(pseudo, motDePasse);
		} else {
			u = mgt.loginSession(pseudo, motDePasse);
		}

		// Créer un cookie avec l'utilisateur et si souvenir de moi est coche, on garde
		// en memoire utilisateur
		if (u != null) {
			session = request.getSession();
			session.setAttribute("userConnected", u);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connecter.jsp");
			rd.forward(request, response);
			if (u!= null && sesouvenir!= null) {
				Cookie userCookie;
				Cookie userPasswordCookie;
				userCookie = new Cookie("pseudo", pseudo);
				userPasswordCookie = new Cookie("motDePasse", motDePasse);
				response.addCookie(userCookie);
				response.addCookie(userPasswordCookie);
				session = request.getSession();
				session.setAttribute("userConnected", u);
				
				rd = request.getRequestDispatcher("/WEB-INF/connecter.jsp");
				rd.forward(request, response);
			}

		} 
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/seConnecter.jsp");
			request.setAttribute("erreur", "l'identifiant ou le mot de passe sont incorrectes");
			rd.forward(request, response);
		}
	}

}
