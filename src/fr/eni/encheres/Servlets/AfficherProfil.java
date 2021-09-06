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
 * Servlet implementation class AfficherProfi
 */
@WebServlet("/afficherProfil")
public class AfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        //Afficher le profil de l'utilisateur
		HttpSession session = request.getSession();	
		Utilisateurs u ;
		UtilisateurManager mgt;
		mgt = UtilisateurManager.getInstance();
		u=mgt.AfficherUtilisateur();
		session = request.getSession();
		session.setAttribute("userConnected", u);
	}

}
