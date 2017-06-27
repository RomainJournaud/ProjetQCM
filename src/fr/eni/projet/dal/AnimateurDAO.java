package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bean.Animateur;
import fr.eni.projet.util.AccesBase;

public class AnimateurDAO {

	private static final String SELECT_SINGLE_BY_EMAIL_AND_PASSWORD = "select id, nom, prenom from animateurs where email=? and motdepasse=?";
private static final String SQL_SELECT_BY_ID = "select * from animateurs where id=?";
	
	/*
	 * Recherche par Id
	 */
	public static Animateur rechercherParId(Animateur animateur) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			rqt.setInt(1, animateur.getId());
			rs=rqt.executeQuery();
			// Si il y a au moins 1 résultat, prendre le 1er pour mettre à jour les informations du stagiaire utilisé pour la recherche.
			if (rs.next()){
				animateur.setNom(rs.getString("nom"));
				animateur.setPrenom(rs.getString("prenom"));
				animateur.setEmail(rs.getString("email"));
				animateur.setMotDePasse(rs.getString("motdepasse"));
			}
			// ...sinon renvoyer null
			else {
				animateur = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return animateur;
	}
	
	public static Animateur rechercher(Animateur animateur) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_SINGLE_BY_EMAIL_AND_PASSWORD);
			rqt.setString(1, animateur.getEmail());
			rqt.setString(2, animateur.getMotDePasse());
			rs=rqt.executeQuery();
			// Si on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations de l'animateur utilisé pour la recherche.
			if (rs.next()){
				animateur.setId(rs.getInt("id"));
				animateur.setNom(rs.getString("nom"));
				animateur.setPrenom(rs.getString("prenom"));
			}
			// ...sinon on renvoie null
			else {
				animateur = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return animateur;
	}

}
