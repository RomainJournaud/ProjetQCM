package fr.eni.projet.bean;

import java.io.Serializable;

public class Reponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String reponse;
	private int valide;
	private int idQuestion;
	
	public Reponse(int id, String reponse, int valide, int idQuestion) {
		this.id = id;
		this.reponse = reponse;
		this.valide = valide;
		this.idQuestion = idQuestion;
	}

	public Reponse() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public int getValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
}
