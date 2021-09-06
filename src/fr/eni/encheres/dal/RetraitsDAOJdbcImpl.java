package fr.eni.encheres.dal;

public class RetraitsDAOJdbcImpl implements RetraitsDAO {
    
	//Singlet
	public static RetraitsDAOJdbcImpl instance = null;
	public RetraitsDAOJdbcImpl() {
	}
	public static RetraitsDAO getInstance() {
		if(instance == null) {
			instance = new RetraitsDAOJdbcImpl();
		}
		return instance;
	}
	
	

}
