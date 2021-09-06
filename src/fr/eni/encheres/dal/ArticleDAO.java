package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bll.bo.Article;
import fr.eni.encheres.bll.bo.Retraits;

public interface ArticleDAO {
     
	//Récup la liste des articles
	List<Article> selectAll();
    //Inser les articles
	void inserArticle(Article art, Retraits ret);

}
