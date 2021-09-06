package fr.eni.encheres.dal;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Connection {
     
	  public static Connection getInstance() {
		
		  try {

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://127.0.0.1;database=AfficherContact";
				Connection cnx = (Connection) DriverManager.getConnection(url, "sa", "Pa$$w0rd");
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  return getInstance();
		  
	  }
}
