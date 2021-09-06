package fr.eni.encheres.blll;

import java.util.List;

import fr.eni.encheres.bll.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;



public class UtilisateurManager {	
	private UtilisateurDAO utilisateurDAO;
	   
	//Singleton
		public static UtilisateurManager instance = null;
		public static UtilisateurManager getInstance() {
			if (instance == null) {
				instance = new UtilisateurManager();
			}
			return instance;
		}

		private UtilisateurManager() {
			this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
			System.out.println("je crée une UtiManager!");
		}


		//Méthode save
		public void inserUtilisateur(Utilisateurs u) {
			//u.setNom(u.getNom().toUpperCase());
			utilisateurDAO.inserUtilisateur(u);
		}
		
		public Utilisateurs AfficherUtilisateur() {
			return utilisateurDAO.AfficherUtilisateur();
		}


		//Méthode l'email doit contenir un @
		public boolean verificationEmail(String email) {
			if (email.contains("@")) {
				return true;
			}
			return false;
		}

		//session
		public Utilisateurs loginSession(String pseudo, String motDePasse) {
			return utilisateurDAO.loginSession(pseudo, motDePasse);
		}
		
		//Verification de pseudo unique
		public int verifPseudoUnique(String pseudo) {
			return this.utilisateurDAO.verifPseudo(pseudo);		
		}
		
		//Verification de pseudo email unique
		public int verifEmailUnique(String email) {
			return this.utilisateurDAO.verifEmail(email);
		}
		
		//Verification de pseudo email unique
		public int verfiExixtenceMotDePasse(String motDePasseActuel, String pseudoEnMemoire) {
			return this.utilisateurDAO.verifExtencePwd(motDePasseActuel, pseudoEnMemoire);
		}
		
	 
		//Méthode modifier
		public void updatrProfil(Utilisateurs u) {
			utilisateurDAO.updatrProfil(u);
		}
	   
		//Méthode modifier par id
		public int findById(String pseudoEnMemoire, String emailEnMemoire) {
			return utilisateurDAO.findById(pseudoEnMemoire, emailEnMemoire);
		}

		//Méthode supprimer
		public void delete(String pseudo) {
			utilisateurDAO.delete(pseudo);
		}
}
