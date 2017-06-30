package fr.eni.projet.bean;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String enonce;
	private String image;
	private int nbRep;
	private List<Reponse> listeReponse;
	
	
	public Question() {
		super();
	}

	public Question(int id, String enonce, String image, int nbRep,
			List<Reponse> listeReponse) {
		super();
		this.id = id;
		this.enonce = enonce;
		this.image = image;
		this.nbRep = nbRep;
		this.listeReponse = listeReponse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbRep() {
		return nbRep;
	}

	public void setNbRep(int nbRep) {
		this.nbRep = nbRep;
	}

	public List<Reponse> getListeReponse() {
		return listeReponse;
	}

	public void setListeReponse(List<Reponse> listeReponse) {
		this.listeReponse = listeReponse;
	}
	
	

}
