package fr.eni.encheres.blll;

import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManage {
	
    private CategorieDAO categorieDAO; 
	//Singleton
	public static CategorieManage instance = null;
	public static CategorieManage getInstance() {
		if(instance == null) {
			instance = new CategorieManage();
		}
		return instance;
	}
	
	private CategorieManage() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
		System.out.println("je crée une UtiManager!");
	}

}
