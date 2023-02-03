package com.example.enchere.ModelClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.enchere.Base.Connexion;

public class Stat_Utilisateur_Produit {
	private int idutilisateur ;
	private int rang;
	private int nbr_enchere;
	public int getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public int getNbr_enchere() {
		return nbr_enchere;
	}
	public void setNbr_enchere(int nbr_enchere) {
		this.nbr_enchere = nbr_enchere;
	}
	
	
	public ArrayList<Stat_Utilisateur_Produit> listeAll()
	{
		Connection connex = null;
		Statement state = null;
		String requete = "select * from stats_utilisateur_produit order by count desc limit 3";
		ArrayList<Stat_Utilisateur_Produit> liste = new ArrayList<Stat_Utilisateur_Produit>();
		try
		{
			connex = new Connexion().setConnect();
			state = connex.createStatement();
			ResultSet rs = state.executeQuery(requete);
			int rang = 1;
			while(rs.next())
			{
				Stat_Utilisateur_Produit stat = new Stat_Utilisateur_Produit();
				stat.setIdutilisateur(rs.getInt("idutilisateur"));
				stat.setNbr_enchere(rs.getInt("nbr_enchere"));
				stat.setRang(rang);
				liste.add(stat);
				rang++;
				
				
			}
		}
		catch(Exception e)
		{
			
		}
		return liste;
	}
}
