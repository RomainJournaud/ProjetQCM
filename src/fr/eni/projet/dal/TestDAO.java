package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bean.Test;
import fr.eni.projet.util.AccesBase;

public class TestDAO {

private static final String SQL_SELECT_BY_ID = "select * from test where id=?";
	
	/*
	 * Recherche par Id
	 */
	public static Test rechercherParId(Test test) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			rqt.setInt(1, test.getId());
			rs=rqt.executeQuery();
			// Si il y a au moins 1 résultat, prendre le 1er pour mettre à jour les informations du stagiaire utilisé pour la recherche.
			if (rs.next()){
				test.setNom(rs.getString("nom"));
				test.setDuree(rs.getInt("duree"));
				test.setSeuilReussite(rs.getFloat("seuil_reussite"));
			}
			// ...sinon renvoyer null
			else {
				test = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return test;
	}
	
	

}
