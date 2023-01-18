package com.example.enchere.ModelClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.enchere.Base.Connexion;

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
	
	public ArrayList<Enchere> selection(String condition) throws Exception
	{
		String requete = "select * from enchere "+condition;
		Connection connex = null;
		Statement state = null;
		ArrayList<Enchere> liste = new ArrayList<>();
		try 
		{
			connex = new Connexion().setConnect();
			state = connex.createStatement();
			 ResultSet rs = state.executeQuery(requete);
			 while(rs.next())
			 {
				 Enchere enchere = new Enchere();
				 enchere.setIdenchere(rs.getInt("idenchere"));
				 enchere.setIdutilisateur(rs.getInt("idutilisateur"));
				 enchere.setIdcategorie(rs.getInt("idcategorie"));
				 enchere.setDureeenchere(rs.getDouble("dureeenchere"));
				 enchere.setDescription(rs.getString("description"));
				 enchere.setDateheureenchere(rs.getDate("dateheureenchere"));
				 enchere.setPrixdevente(rs.getFloat("prixdevente"));
				 enchere.setPrixminimum(rs.getFloat("prixminimum"));
				 enchere.setEtat(rs.getInt("etat"));
				 liste.add(enchere);
			 }
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			if(state != null)
			{
				
				state.close();
			}
			if(connex != null)
			{
				connex.close();
			}
		}
		return liste;
	}
	public ArrayList<Enchere> selectById(int id) throws Exception
	{
		return selection(" where idenchere='"+id+"'");
	}
	public ArrayList<Enchere> select_valide() throws Exception
	{
		return selection(" where dateheureenchere>now()");
	}
	public ArrayList<Enchere> selectall() throws Exception
	{
		return selection("");
	}
	public ArrayList<Enchere> selectRecherche(String recherche) throws Exception
	{
		return selection(" where description like '%"+recherche+"%'");
	}
	
}
