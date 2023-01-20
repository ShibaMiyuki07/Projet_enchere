package com.example.enchere.Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "jdbc:postgresql://containers-us-west-185.railway.app:5889/railway";
    private static String user="postgres";
    private static String passwd = "NxPX0hpksmxrlYaTnqg5";
	private  Connection connect;
	public  Connection setConnect()
	{
		if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connect;
	}
}
