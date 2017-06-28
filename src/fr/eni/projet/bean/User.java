package fr.eni.projet.bean;

import java.io.*;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String identifiant;
	private String mdp;
	private int admin;

	public User() {
		super();
	}

	public User(int id, String nom, String prenom, String mail,
			String identifiant, String mdp, int admin) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.admin = admin;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
