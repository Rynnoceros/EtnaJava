/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core;

import java.sql.*;

/**
 * Connexion to the database 
 * @author soubri_j/martin_m
 */
public class Connexion {
    static Connexion connexion = null;
    static String urlPilote = "com.mysql.jdbc.Driver";
    static String urlBaseDonnes = "jdbc:mysql://localhost:3306/base_penelope";
    static String user = "root";
    static String password = "";
    static Connection con;
    static ConfigurationHelper helper = null;
    
    private Connexion(){
        helper = new ConfigurationHelper("/application.properties");
        try {
            urlPilote = helper.getPropertyValue("mysql.driver");
            Class.forName(urlPilote);
            LogManager.getInstance().log("Chargement du pilote réussie");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        
        try {
            urlBaseDonnes = helper.getPropertyValue("mysql.database.url");
            user = helper.getPropertyValue("mysql.root.user");
            password = helper.getPropertyValue("mysql.root.password");
            con = DriverManager.getConnection(urlBaseDonnes, user, password);
            LogManager.getInstance().log("Connexion à la base de données réussie");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    public static Connection ObtenirConnexion(){
        if (connexion == null || con == null) {
            connexion = new Connexion();
        }
        return con;
    }
}
