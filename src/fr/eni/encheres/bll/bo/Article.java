package fr.eni.encheres.bll.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Article {

	private int no_article ;
	private String nom_article;
	private String description;
	private LocalDateTime date_debut_encheres;
	private LocalDateTime date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private int no_utilisateur;
	private int no_categorie;
	private String nom_img;
	private int acheteur;
	private List<Encheres> enchere;
	private Retraits retrait;

	//Constructeur par défault
	public Article() {
         this.enchere = new ArrayList<>();
	}

	/**
	 * @param no_article
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param prix_initial
	 * @param prix_vente
	 * @param no_utilisateur
	 * @param no_categorie
	 * @param nom_img
	 * @param acheteur
	 * @param enchere
	 * @param retrait
	 */
	public Article(int no_article, String nom_article, String description, LocalDateTime date_debut_encheres,
			LocalDateTime date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie,
			String nom_img, int acheteur, List<Encheres> enchere, Retraits retrait) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.nom_img = nom_img;
		this.acheteur = acheteur;
		this.enchere = enchere;
		this.retrait = retrait;
	}

	//Constructeur sans liste
	/**
	 * @param no_article
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param prix_initial
	 * @param prix_vente
	 * @param no_utilisateur
	 * @param no_categorie
	 * @param nom_img
	 * @param acheteur
	 * @param retrait
	 */
	public Article(int no_article, String nom_article, String description, LocalDateTime date_debut_encheres,
			LocalDateTime date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie,
			String nom_img, int acheteur) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.nom_img = nom_img;
		this.acheteur = acheteur;
		//this.retrait = retrait;
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
	 * @return the nom_article
	 */
	public String getNom_article() {
		return nom_article;
	}

	/**
	 * @param nom_article the nom_article to set
	 */
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date_debut_encheres
	 */
	public LocalDateTime getDate_debut_encheres() {
		return date_debut_encheres;
	}

	/**
	 * @param date_debut_encheres the date_debut_encheres to set
	 */
	public void setDate_debut_encheres(LocalDateTime date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	/**
	 * @return the date_fin_encheres
	 */
	public LocalDateTime getDate_fin_encheres() {
		return date_fin_encheres;
	}

	/**
	 * @param date_fin_encheres the date_fin_encheres to set
	 */
	public void setDate_fin_encheres(LocalDateTime date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	/**
	 * @return the prix_initial
	 */
	public int getPrix_initial() {
		return prix_initial;
	}

	/**
	 * @param prix_initial the prix_initial to set
	 */
	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	/**
	 * @return the prix_vente
	 */
	public int getPrix_vente() {
		return prix_vente;
	}

	/**
	 * @param prix_vente the prix_vente to set
	 */
	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
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
	 * @return the no_categorie
	 */
	public int getNo_categorie() {
		return no_categorie;
	}

	/**
	 * @param no_categorie the no_categorie to set
	 */
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	/**
	 * @return the nom_img
	 */
	public String getNom_img() {
		return nom_img;
	}

	/**
	 * @param nom_img the nom_img to set
	 */
	public void setNom_img(String nom_img) {
		this.nom_img = nom_img;
	}

	/**
	 * @return the acheteur
	 */
	public int getAcheteur() {
		return acheteur;
	}

	/**
	 * @param acheteur the acheteur to set
	 */
	public void setAcheteur(int acheteur) {
		this.acheteur = acheteur;
	}

	/**
	 * @return the enchere
	 */
	public List<Encheres> getEnchere() {
		return enchere;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setEnchere(List<Encheres> enchere) {
		this.enchere = enchere;
	}

	/**
	 * @return the retrait
	 */
	public Retraits getRetrait() {
		return retrait;
	}

	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retraits retrait) {
		this.retrait = retrait;
	}

	@Override
	public String toString() {
		return "Article [no_article=" + no_article + ", nom_article=" + nom_article + ", description=" + description
				+ ", date_debut_encheres=" + date_debut_encheres + ", date_fin_encheres=" + date_fin_encheres
				+ ", prix_initial=" + prix_initial + ", prix_vente=" + prix_vente + ", no_utilisateur=" + no_utilisateur
				+ ", no_categorie=" + no_categorie + ", nom_img=" + nom_img + ", acheteur=" + acheteur + ", enchere="
				+ enchere + ", retrait=" + retrait + "]";
	}

	
	
	
	

	
}