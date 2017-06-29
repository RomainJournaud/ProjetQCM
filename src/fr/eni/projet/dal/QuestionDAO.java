package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bean.Question;
import fr.eni.projet.util.AccesBase;

public class QuestionDAO {

private static final String SQL_SELECT_BY_ID = "select * from question where id=?";
	
	/*
	 * Recherche par Id
	 */
	public static Question rechercherParId(Question question) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			rqt.setInt(1, question.getId());
			rs=rqt.executeQuery();
			// Si il y a au moins 1 rÃ©sultat, prendre le 1er pour mettre Ã  jour les informations du stagiaire utilisÃ© pour la recherche.
			if (rs.next()){
				question.setEnonce(rs.getString("enonce"));
				question.setImage(rs.getString("image"));
				question.setNbRep(rs.getInt("nb_reponse"));
			}
			// ...sinon renvoyer null
			else {
				question = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return question;
	}
	
	

}
