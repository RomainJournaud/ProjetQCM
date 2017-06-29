package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bean.User;
import fr.eni.projet.util.AccesBase;

public class UserDAO {

	private static final String SELECT_SINGLE_BY_EMAIL_AND_PASSWORD = "select id, nom, prenom from Utilisateur where identifiant=? and mdp=?";
    private static final String SQL_SELECT_BY_ID = "select * from utilisateur where id=?";
	
	/*
	 * Recherche par Id
	 */
	public static User rechercherParId(User user) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			rqt.setInt(1, user.getId());
			rs=rqt.executeQuery();
			// Si il y a au moins 1 résultat, prendre le 1er pour mettre à jour les informations du user utilisé pour la recherche.
			if (rs.next()){
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
<<<<<<< HEAD:src/fr/eni/projet/dal/UserDAO.java
				user.setEmail(rs.getString("email"));
				user.setMotDePasse(rs.getString("motdepasse"));
=======
				user.setIdentifiant(rs.getString("identifiant"));
				user.setMdp(rs.getString("mdp"));
>>>>>>> master:src/fr/eni/projet/dal/UserDAO.java
			}
			// ...sinon renvoyer null
			else {
				user = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return user;
	}
	
	public static User rechercher(User user) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_SINGLE_BY_EMAIL_AND_PASSWORD);
<<<<<<< HEAD:src/fr/eni/projet/dal/UserDAO.java
			rqt.setString(1, user.getEmail());
			rqt.setString(2, user.getMotDePasse());
=======
			rqt.setString(1, user.getIdentifiant());
			rqt.setString(2, user.getMdp());
>>>>>>> master:src/fr/eni/projet/dal/UserDAO.java
			rs=rqt.executeQuery();
			// Si on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations du user utilisé pour la recherche.
			if (rs.next()){
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
			}
			// ...sinon on renvoie null
			else {
				user = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return user;
	}

}
