/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

/**
 *
 * @author ElHadji
 */
public class Constants {

    // Url de connexion en base de donnée
    public static String DATABASE_URL = "jdbc:mysql://localhost:3306/base_quest_ebenus?useSSL=false";
    // Utilisateur de la base de données
    public static String DATABASE_USER = "application";
    // Mot de passe de la base de données
    public static String DATABASE_PASSWORD = "passw0rd";
    
    public static Integer DATABASE_MAX_CONNECTIONS = 20; 

    // Drivers Jdbc
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static String SQL_JUNIT_PATH_FILE = "script_base_test_junit_quest_ebenus.sql";

    public static int EXCEPTION_CODE_USER_ALREADY_EXIST = -1;
    
    public static String ERROR_MSG_ROLE_EXISTING = "Le role avec l'identifiant %s existe deja";
    public static String ERROR_MSG_USER_EXISTING = "L'utilisateur avec l'identifiant %s existe deja";
    
    public static int EXCEPTION_CODE_ELEMENT_ALREADY_EXIST = -1;
    
    public static String ID = "id";
    public static String DATE_PATTERN = "dd/MM/yyyy";
    
    public static String SELECT_ALL = "SELECT * FROM %s";
    public static String SELECT_WHERE_PARAMETER = "SELECT * FROM %s WHERE %s = ?";
    public static String INSERT_INTO = "INSERT INTO %s (";
    public static String UPDATE_QUERY = "UPDATE %s SET ";
    public static String DELETE_QUERY = "DELETE FROM %s WHERE ";
    public static String SELECT_MAX_ID = "SELECT MAX(%s) FROM %s;";
    public static String SELECT_ALL_ROLE = "SELECT idRole, identifiant as identifiantRole, description, "
    		+ " version as versionRole FROM Role";
    public static String SELECT_ROLE_BY_IDENTIFIANT = SELECT_ALL_ROLE + " WHERE identifiant = ?";
    public static String SELECT_ROLE_BY_ROLE = SELECT_ALL_ROLE + " WHERE idRole = ?";
    public static String SELECT_FIND_UTILISATEUR_BY_CRITERIA = 
    		"SELECT u.idUtilisateur, u.civilite, u.prenom, u.nom, u.identifiant, u.motPasse,"
    		+ "u.dateNaissance, u.dateCreation, u.dateModification, u.actif, u.marquerEffacer,"
    		+ " u.version, r.idRole, r.identifiant as identifiantRole, r.description, "
    		+ "r.version as versionRole "
    		+ " FROM Utilisateur u LEFT JOIN Role r ON u.idRole = r.idRole "
    		+ " WHERE %s = ?";
    
    public static String SELECT_ALL_UTILISATEUR_ROLE = 
    		"SELECT u.idUtilisateur, u.civilite, u.prenom, u.nom, u.identifiant, u.motPasse,"
    		+ "u.dateNaissance, u.dateCreation, u.dateModification, u.actif, u.marquerEffacer,"
    		+ " u.version, r.idRole, r.identifiant as identifiantRole, r.description, "
    		+ "r.version as versionRole "
    		+ " FROM Utilisateur u LEFT JOIN Role r ON u.idRole = r.idRole";

    public static String CSV_SEPARATOR = ";";
}
