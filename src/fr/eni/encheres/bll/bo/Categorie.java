package fr.eni.encheres.bll.bo;

public class Categorie {
     
	private int no_article;
	private int no_categorie;
	private String libelle;
	
	//Constructeur par défaut
	public Categorie() {
		
	}

	/**
	 * @param no_article
	 * @param no_categorie
	 * @param libelle
	 */
	public Categorie(int no_article, int no_categorie, String libelle) {
		super();
		this.no_article = no_article;
		this.no_categorie = no_categorie;
		this.libelle = libelle;
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [no_article=" + no_article + ", no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}
	
	
}
