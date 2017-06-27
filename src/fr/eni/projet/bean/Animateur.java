package fr.eni.projet.bean;

import java.io.*;

public class Animateur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String email;

	public Animateur(){
		super();
	}
	
	public Animateur(int id, String nom, String prenom, String motDePasse, String email){
		this();
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setMotDePasse(motDePasse);
		setEmail(email);		
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String premnom) {
		this.prenom = premnom;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
