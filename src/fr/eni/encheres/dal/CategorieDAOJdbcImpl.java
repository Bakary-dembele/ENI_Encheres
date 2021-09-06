package fr.eni.encheres.dal;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	//Singleton
	public static CategorieDAOJdbcImpl instance = null;
	private CategorieDAOJdbcImpl() {	
	}
	public static CategorieDAO getInstance() {
		if(instance == null) {
			instance = new CategorieDAOJdbcImpl();
		}
		return instance;
	}

}
