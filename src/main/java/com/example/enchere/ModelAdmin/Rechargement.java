package com.example.enchere.ModelAdmin;

import java.sql.Date;

public class Rechargement {
	private int idutilisateur;
	private float montantrecharge;
	private Date dateheurechargement;
	private int validation;
	public int getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public float getMontantrecharge() {
		return montantrecharge;
	}
	public void setMontantrecharge(float montantrecharge) {
		this.montantrecharge = montantrecharge;
	}
	public Date getDateheurechargement() {
		return dateheurechargement;
	}
	public void setDateheurechargement(Date dateheurechargement) {
		this.dateheurechargement = dateheurechargement;
	}
	public int getValidation() {
		return validation;
	}
	public void setValidation(int validation) {
		this.validation = validation;
	}
	
	
	
}
