package fr.eni.encheres.blll;

import java.util.List;

import fr.eni.encheres.bll.bo.Article;
import fr.eni.encheres.bll.bo.Retraits;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {

	private ArticleDAO articleDAO;

	// Singleton
	public static ArticleManager instance = null;
	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}

	private ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
		System.out.println("je crée une UtiManager!");
	}

	// Inser les articles
	public void inserArticle(Article art, Retraits ret) {
		this.articleDAO.inserArticle(art, ret);
	}

	// Récupper la liste des articles
	public List<Article> selectAll() {
		return this.articleDAO.selectAll();
	}

}
