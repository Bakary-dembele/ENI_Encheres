package fr.eni.encheres.dal;

public class DAOFactory {

	// Utilisateur
	public static UtilisateurDAO getUtilisateurDAO() {
		return UtilisateurDAOJdbcImpl.getInstance();
	}

	// Article
	public static ArticleDAO getArticleDAO() {
		return ArticleDAOJdbcImpl.getInstance();
	}

	//Encheres
	public static EncheresDAO getEncheresDAO() {
		return EncheresDAOJdbcImpl.getInstance();
	}

	//Retraits
	public static RetraitsDAO getRetraitsDAO() {
		return RetraitsDAOJdbcImpl.getInstance();
	}
    
	//Categorie
	public static CategorieDAO getCategorieDAO() {
		return CategorieDAOJdbcImpl.getInstance();
	}

	

}