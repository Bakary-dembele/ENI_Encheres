package fr.eni.encheres.dal;

public class EncheresDAOJdbcImpl implements EncheresDAO {
	
	
	//Singleton
	public static EncheresDAOJdbcImpl instance = null;
	private EncheresDAOJdbcImpl() {	
	}

	public static EncheresDAO getInstance() {
		if(instance == null) {
			instance = new EncheresDAOJdbcImpl();
		}
		return instance;
	}

}
