package com.example.enchere.Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "jdbc:postgresql://	floppy.db.elephantsql.com/msreixuv";
    private static String user="msreixuv";
    private static String passwd = "OPAyJLGk6dUqOqgTMwMR0rBa31AyjYY0";
	private static Connection connect;
	public static Connection setConnect()
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
