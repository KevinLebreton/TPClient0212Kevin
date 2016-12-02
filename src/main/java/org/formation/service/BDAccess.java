package org.formation.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDAccess {

	String url = "jdbc:mysql://localhost/proxibanque";
	String user = "root";
	String password = "";
	Connection con = null;

	public Connection seConnecter() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			//System.out.println("Vous êtes connecté");
			return con;
		} catch (ClassNotFoundException ex) {
			System.out.println("Impossible de se connecter");
            //Logger.getLogger(BDAccess.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace(); 
			return null;
		}
	}
	
//	public void seDeconnecter() throws SQLException{
//		
//			con.close();
//			System.out.println("Vous êtes deconnecté");
//			
//	}
}
