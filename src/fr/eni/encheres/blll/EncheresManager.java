package fr.eni.encheres.blll;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;

public class EncheresManager {
	
	private EncheresDAO encheresDAO;
	
	//Singleton
	public static EncheresManager instance = null;
	public static EncheresManager getInstance() {
		if(instance == null) {
			instance = new EncheresManager();
		}
		return instance;
	}
	
	private EncheresManager() {
		this.encheresDAO = DAOFactory.getEncheresDAO();
		System.out.println("je crée une UtiManager!");
	}

}
