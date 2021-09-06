package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bll.bo.Article;
import fr.eni.encheres.bll.bo.Retraits;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	public static ArticleDAOJdbcImpl  instance = null; 
	private static final String INSERT_ARTICLES = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,nom_img,acheteur) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere,montant_encher) (?,?,?,?)";
	private static final String INSERT_RETRAINT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) (?,?,?,?)";
	private static final String RECUPER_ARTICLES = "SELECT * FROM ARTICLES_VENDUS";
	
	// Singleton
		private ArticleDAOJdbcImpl() {
		}

		public static ArticleDAO getInstance() {
			if (instance == null) {
				instance = new ArticleDAOJdbcImpl();
			}
			return instance;
		}

		//Méthode inser les articles
		@Override
		public void inserArticle(Article art, Retraits ret) {
			
			try {
				//Connexion
				Connection cnx = connexionBDD();
                
				cnx.setAutoCommit(false);//Je fais de transaction en faisant un boolean en cas d'erreur je géner  une exception
				PreparedStatement pstmt = cnx.prepareStatement( INSERT_ARTICLES);
				pstmt.setString(1, art.getNom_article());
				pstmt.setString(2, art.getDescription());
				pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(art.getDate_debut_encheres())); //java.sql.Timestamp.valueOf
				pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(art.getDate_fin_encheres()));
				pstmt.setInt(5, art.getPrix_initial());
				pstmt.setInt(6, art.getPrix_vente());
				pstmt.setInt(7, art.getNo_utilisateur());
				pstmt.setInt(8, art.getNo_categorie());
				pstmt.setString(9, art.getNom_img());
				pstmt.setInt(10, art.getAcheteur());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys(); //
				if(rs.next()) {
					art.setNo_article(rs.getInt(1)); //
				}
				rs.close();//fermer rs
				pstmt.close();//ferme pstmt
				
				//Insert les incheres
				pstmt = cnx.prepareStatement( INSERT_ENCHERE );
				pstmt.setInt(1, art.getNo_utilisateur());
				pstmt.setInt(2, art.getNo_article());
				pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(art.getDate_debut_encheres()));
				pstmt.setInt(4, art.getPrix_initial());
				pstmt.executeUpdate();
				pstmt.close();
				
				//Insert les retrats
				pstmt = cnx.prepareStatement( INSERT_RETRAINT );
				pstmt.setInt(1, ret.getNo_article());
				pstmt.setString(2, ret.getRue());
				pstmt.setString(3, ret.getCode_postal());
				pstmt.setString(4, ret.getVille());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				//cnx.rollback(); //Ici faire un retour en arrière en cas des heures
				e.printStackTrace();
			}
			
		}

		
		
		//Méthode récupper la liste des articles
		@Override
		public List<Article> selectAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
		public Connection connexionBDD() throws ClassNotFoundException, SQLException {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1;database=ENI-Encheres";
			Connection cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			return cnx;
		}
		

		

		
		
		

}


