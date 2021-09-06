package fr.eni.encheres.bll.bo;

import java.time.LocalDateTime;

public class Encheres {
	
	private int no_utilisateur;
	private int no_article ;
	private LocalDateTime date_enchere;
	private int montant_enchere;
	
	//Constructeur par défault
	public Encheres() {
		
	}

	/**
	 * @param no_utilisateur
	 * @param no_article
	 * @param date_enchere
	 * @param montant_enchere
	 */
	public Encheres(int no_utilisateur, int no_article, LocalDateTime date_enchere, int montant_enchere) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	/**
	 * @return the no_utilisateur
	 */
	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	/**
	 * @param no_utilisateur the no_utilisateur to set
	 */
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	/**
	 * @return the no_article
	 */
	public int getNo_article() {
		return no_article;
	}

	/**
	 * @param no_article the no_article to set
	 */
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	/**
	 * @return the date_enchere
	 */
	public LocalDateTime getDate_enchere() {
		return date_enchere;
	}

	/**
	 * @param date_enchere the date_enchere to set
	 */
	public void setDate_enchere(LocalDateTime date_enchere) {
		this.date_enchere = date_enchere;
	}

	/**
	 * @return the montant_enchere
	 */
	public int getMontant_enchere() {
		return montant_enchere;
	}

	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		return "Encheres [no_utilisateur=" + no_utilisateur + ", no_article=" + no_article + ", date_enchere="
				+ date_enchere + ", montant_enchere=" + montant_enchere + "]";
	}
	
	

}
