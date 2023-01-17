package com.example.enchere.ModelAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.enchere.Base.Connexion;

public class Categorie {
	private int idcategorie;
	private String categorie;
	private double dureeEnchereCategorie;
	public int getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public double getDureeEnchereCategorie() {
		return dureeEnchereCategorie;
	}
	public void setDureeEnchereCategorie(double dureeEnchereCategorie) {
		this.dureeEnchereCategorie = dureeEnchereCategorie;
	}
	
	public boolean insert(Categorie categorie) throws Exception
	{
		String requete ="insert into categorie values(default,'"+categorie.getCategorie()+"','"+categorie.getDureeEnchereCategorie()+"')";
		Connection connex = null;
		Statement state = null;
		boolean retour = false;
		try
		{
			connex = Connexion.setConnect();
			state = connex.createStatement();
			state.execute(requete);
			retour = true;
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			connex.close();
			state.close();
		}
		return retour;
	}
}
