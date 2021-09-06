package fr.eni.encheres.blll;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitsDAO;

public class RetraitsManager {
	
	private RetraitsDAO retraitsDAO;
	
	//Singleton
	public static RetraitsManager instance = null;
	private static RetraitsManager getInstance() {
		if(instance == null) {
			instance = new RetraitsManager();
		}
		return instance;
	}
	
	private RetraitsManager() {
		this.retraitsDAO = DAOFactory.getRetraitsDAO();
		System.out.println("je crée une UtiManager!");
	}


}
