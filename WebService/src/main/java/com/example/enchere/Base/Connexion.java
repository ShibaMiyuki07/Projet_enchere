package com.example.enchere.Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "jdbc:postgresql://containers-us-west-169.railway.app:6010/railway";
    private static String user="postgres";
    private static String passwd = "6lEIuUsFZ8ntNcu1wNyA";
	private  Connection connect;
	public  Connection setConnect() throws Exception
	{
		if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (Exception e) {
                throw e;
            }
        }
        return connect;
	}
}
