package com.example.enchere.ModelClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.enchere.Base.Connexion;

public class Utilisateur {
	private int idutiilisateur;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private float solde_compte;
	public int getIdutiilisateur() {
		return idutiilisateur;
	}
	public void setIdutiilisateur(int idutiilisateur) {
		this.idutiilisateur = idutiilisateur;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public float getSolde_compte() {
		return solde_compte;
	}
	public void setSolde_compte(float solde_compte) {
		this.solde_compte = solde_compte;
	}
	
	public Utilisateur login(Utilisateur user) throws Exception
	{
		String requete = "select * from utilisateur where email='"+user.getEmail()+"' and mdp='"+user.getMdp()+"'";
		Utilisateur utilisateur = new Utilisateur();
		Connection connex = null;
		Statement state = null;
		try
		{
			connex = new Connexion().setConnect();
			state = connex.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				utilisateur.setIdutiilisateur(rs.getInt("idutilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setSolde_compte(rs.getFloat("solde_compte"));
			}
			
		}
		catch(Exception e)
		{
			throw e;
		}
		return utilisateur;
	}
}
