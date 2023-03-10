package com.example.enchere.ModelClient;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.enchere.Base.Connexion;
import com.example.enchere.ModelAdmin.Categorie;

import ch.qos.logback.classic.Logger;

@Component
public class Enchere {
	private static final Logger log = (Logger) LoggerFactory.getLogger(Enchere.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	private int idenchere;
	private int idutilisateur;
	private double dureeenchere;
	private String description;
	private int idcategorie;
	private LocalDateTime dateheureenchere;
	private LocalDateTime datefinenchere;
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
	
	public LocalDateTime getDateheureenchere() {
		return dateheureenchere;
	}
	public void setDateheureenchere(LocalDateTime dateheureenchere) {
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
	
	
	public LocalDateTime getDatefinenchere() {
		return datefinenchere;
	}
	public void setDatefinenchere(LocalDateTime datefinenchere) {
		this.datefinenchere = datefinenchere;
	}
	public ArrayList<Enchere> selection(String condition) throws Exception
	{
		String requete = "select * from "+condition;
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
				 enchere.setDateheureenchere(rs.getTimestamp("dateheureenchere").toLocalDateTime());
				 enchere.setPrixdevente(rs.getFloat("prixdevente"));
				 enchere.setPrixminimum(rs.getFloat("prixminimum"));
				 enchere.setDatefinenchere(rs.getTimestamp("datefinenchere").toLocalDateTime());
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
		return selection(" enchere where idenchere='"+id+"'");
	}
	public ArrayList<Enchere> selectByIdDate(int id) throws Exception
	{
		return selection(" enchere where idutilisateur='"+id+"' order by dateheureenchere desc ");
	}
	public ArrayList<Enchere> select_valide() throws Exception
	{
		return selection(" enchere where datefinenchere>now()");
	}
	public ArrayList<Enchere> selectall() throws Exception
	{
		return selection(" enchere");
	}
	public ArrayList<Enchere> selectRecherche(String recherche) throws Exception
	{
		return selection(" v_enchere_categorie where description like '%"+recherche+"%' or categorie like '%"+recherche+"%'");
	}

	
	public void updateEtatById(int idenchere) throws Exception
	{
		String requete = "update enchere set etat = '1' where idenchere ='"+idenchere+"'";
		Connection connex = null;
		Statement state = null;
		try
		{
			connex = new Connexion().setConnect();
			state = connex.createStatement();
			state.execute(requete);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Scheduled(fixedRate =1)
	public void changeEtat() throws Exception
	{
			//log.info("Test de validite {}",dateFormat.format(new Date()));
			ArrayList<Enchere> liste_valide = new Enchere().select_valide();
			
			for(int i=0;i<liste_valide.size();i++)
			{
				LocalDateTime date = LocalDateTime.now();
				if(date.compareTo(liste_valide.get(i).getDatefinenchere()) == 0)
				{	
					updateEtatById(liste_valide.get(i).getIdenchere());
					
				}
			}
	}
	
	/*@Scheduled(fixedRate = 10)
	public void sendNotification() throws Exception
	{
		try
		{
			URL url = new URL("https://onesignal.com/api/v1/notifications");
			HttpURLConnection co = (HttpURLConnection) url.openConnection();
			co.setRequestMethod("POST");
			co.setRequestProperty("Accept", "application/json");
			co.setDoOutput(true);
			String app_id = "30cdf2db-0abc-4fcd-b9a0-fa8e2cef546b";
			String JsonInput = "{"+
					" app_id : " +app_id+ ","+
					"included_segments :["
					+ "Suscribed Users"
					+ "], "+
					"contents :{"
					+ "en : Mety"
					+ "},"
					+ "name : Test faharoa"+
					"}";
			try(OutputStream os = co.getOutputStream())
			{
				byte[] input = JsonInput.getBytes("utf-8");
				os.write(input,0,input.length);
			}
			catch(Exception ex)
			{
				System.out.print(ex.getMessage());
			}
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	*/
	public boolean insertion(Enchere enchere) throws Exception
	{
		LocalDateTime now = java.time.LocalDateTime.now();
		Long ajout = new Long((long) enchere.getDureeenchere());
		LocalDateTime fin = now.plusHours(ajout);
		boolean retour = false;
		Categorie categorie = new Categorie().selectById(enchere.getIdcategorie());
		System.out.println(now);
		System.out.println(fin);
		String requete = "insert into enchere values(default,'"+enchere.getIdutilisateur()+"','"+enchere.getDureeenchere()+"','"+enchere.getDescription()+"','"+enchere.getIdcategorie()+"','"+now+"','"+enchere.getPrixdevente()+"','"+enchere.getPrixminimum()+"',0,'"+fin+"')";
		Connection connex = null;
		Statement state = null;
		try
		{
			if(enchere.getDureeenchere()>categorie.getDureeEnchereCategorie())
			{
				return false;
			}
			else
			{
				connex = new Connexion().setConnect();
				state = connex.createStatement();
				state.execute(requete);
				retour = true;
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
		return retour;
	}
}
