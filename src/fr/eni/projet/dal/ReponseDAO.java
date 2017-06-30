package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bean.Reponse;
import fr.eni.projet.util.AccesBase;

public class ReponseDAO {

private static final String SQL_SELECT_BY_ID = "select * from question where id=?";
	
	/*
	 * Recherche par Id
	 */
	public static Reponse rechercherParId(Reponse reponse) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			rqt.setInt(1, reponse.getId());
			rs=rqt.executeQuery();
			// Si il y a au moins 1 rÃ©sultat, prendre le 1er pour mettre Ã  jour les informations du stagiaire utilisÃ© pour la recherche.
			if (rs.next()){
				reponse.setReponse(rs.getString("reponse"));
				reponse.setValide(rs.getInt("valide"));
				reponse.setIdQuestion(rs.getInt("idQuestion"));
			}
			// ...sinon renvoyer null
			else {
				reponse = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return reponse;
	}
	
	

}
