package fr.eni.encheres.dal;



import fr.eni.encheres.bll.bo.Utilisateurs;

public interface UtilisateurDAO {

	public void inserUtilisateur(Utilisateurs u);
	public Utilisateurs loginSession(String pseudo, String motDePasse);
	public Utilisateurs AfficherUtilisateur();
	public void updatrProfil(Utilisateurs u);
	public int findById(String pseudo, String motDePasse);
	public void delete(String pseudo);
	public int verifPseudo(String pseudo);
	public int verifEmail(String email);
	public int verifExtencePwd(String motDePasseActuel, String pseudoEnMemoire);   
}
