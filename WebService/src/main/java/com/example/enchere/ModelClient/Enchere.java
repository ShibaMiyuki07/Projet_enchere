package com.example.enchere.ModelClient;

import java.sql.Date;

public class Enchere {
	private int idenchere;
	private int idutilisateur;
	private double dureeenchere;
	private String description;
	private int idcategorie;
	private Date dateheureenchere;
	private float prixdevente;
	private float prixminimum;
	private int etat;
	public int getIdenchere() {
		return idenchere;
	}
	public void setIdenchere(int idenchere) {
		this.idenchere = idenchere;
	}
	public int getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public double getDureeenchere() {
		return dureeenchere;
	}
	public void setDureeenchere(double dureeenchere) {
		this.dureeenchere = dureeenchere;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}
	public Date getDateheureenchere() {
		return dateheureenchere;
	}
	public void setDateheureenchere(Date dateheureenchere) {
		this.dateheureenchere = dateheureenchere;
	}
	public float getPrixdevente() {
		return prixdevente;
	}
	public void setPrixdevente(float prixdevente) {
		this.prixdevente = prixdevente;
	}
	public float getPrixminimum() {
		return prixminimum;
	}
	public void setPrixminimum(float prixminimum) {
		this.prixminimum = prixminimum;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
}
