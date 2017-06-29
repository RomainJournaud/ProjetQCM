package fr.eni.projet.bean;

import java.io.*;

public class Test implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private int duree;
	private float seuilReussite;

	public Test(){
		super();
	}
	

	public Test(int id, String nom, int duree, float seuilReussite) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.seuilReussite = seuilReussite;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getSeuilReussite() {
		return seuilReussite;
	}

	public void setSeuilReussite(float seuilReussite) {
		this.seuilReussite = seuilReussite;
	}
	
	

}
