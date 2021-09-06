package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bll.bo.Utilisateurs;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static UtilisateurDAOJdbcImpl instance = null;
	
	// Singleton
	private UtilisateurDAOJdbcImpl() {
	}

	public static UtilisateurDAOJdbcImpl getInstance() {
		if (instance == null) {
			instance = new UtilisateurDAOJdbcImpl();
		}
		return instance;
	}

	@Override
	public void inserUtilisateur(Utilisateurs u) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1;database=ENI-Encheres";
			Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO  Utilisateurs VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getCredit());
			pstmt.setBoolean(11, u.isAdministrateur());
       
			pstmt.executeUpdate();
			pstmt.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateurs loginSession(String pseudo, String motDePasse) {
		Utilisateurs utilisateur = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1;database=ENI-Encheres";
			Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			PreparedStatement pstmt = cnx
					.prepareStatement("SELECT * FROM Utilisateurs WHERE  pseudo=? and  motDePasse=?");
			// FABRIQUER LA execution
			pstmt.setString(1, pseudo);
			pstmt.setString(2, motDePasse);
			ResultSet rs = pstmt.executeQuery();
			// BOUCLE
			if (rs.next()) {

				utilisateur = new Utilisateurs();
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));	
				utilisateur.setCodePostal(rs.getString("codePostal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("motDePasse"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
			}
			// FERME
			cnx.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur; // retourne le niveau contact
	}

	
	

	@Override
	public void updatrProfil(Utilisateurs u) {	

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1;database=ENI-Encheres";
			Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			PreparedStatement pstmt = cnx.prepareStatement("UPDATE Utilisateurs SET pseudo=?, nom=?,prenom=?,email=?,telephone=?,rue=?,codePostal=?,ville=?,motDePasse=?,credit=?,administrateur=?  where noUtilisateur=?");
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getCredit());
			pstmt.setBoolean(11, u.isAdministrateur());
			pstmt.setInt(12, u.getNoUtilisateur());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int findById(String pseudo, String motDePasse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String pseudo) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1;database=ENI-Encheres";
			Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Utilisateurs WHERE pseudo=?");
			pstmt.setString(1, pseudo);
			
			pstmt.executeUpdate();
			pstmt.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateurs AfficherUtilisateur() {
		
			Utilisateurs utilisateur = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://127.0.0.1;database=ENI-Encheres";
				Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

				PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Utilisateurs");
				// FABRIQUER LA execution
				ResultSet rs = pstmt.executeQuery();
				// BOUCLE
			if (rs.next()) {

					utilisateur = new Utilisateurs();
					// utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("codePostal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("motDePasse"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				}
				// FERME
				cnx.close();

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return utilisateur; // retourne le niveau contact
		}

	@Override
	public int verifPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int verifEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int verifExtencePwd(String motDePasseActuel, String pseudoEnMemoire) {
		// TODO Auto-generated method stub
		return 0;
	}

	}


