/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

/**
 * Class used to centralize all Constants used by the application.
 * @author soubri_j/martin_m
 */
public class Constants {

    // Url de connexion en base de donnée
    public static String DATABASE_URL = "jdbc:mysql://localhost:3306/base_site_commerce_ebenus?useSSL=false";
    // Utilisateur de la base de données
    public static String DATABASE_USER = "application";
    // Mot de passe de la base de données
    public static String DATABASE_PASSWORD = "passw0rd";
    
    public static Integer DATABASE_MAX_CONNECTIONS = 20; 

    // Drivers Jdbc
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static String SQL_JUNIT_PATH_FILE = "script_base_site_commerce_ebenus.sql";

    public static int EXCEPTION_CODE_USER_ALREADY_EXIST = -1;
    
    public static String ERROR_MSG_ROLE_EXISTING = "Le role avec l'identifiant %s existe deja";
    public static String ERROR_MSG_USER_EXISTING = "L'utilisateur avec l'identifiant %s existe deja";
    
    public static int EXCEPTION_CODE_ELEMENT_ALREADY_EXIST = -1;
    
    public static String ID = "id";
    public static String DATE_PATTERN = "dd/MM/yyyy";
    
    public static String SELECT_ALL = "SELECT * FROM %s";
    public static String SELECT_WHERE_PARAMETER = "SELECT * FROM %s WHERE %s = ?";
    public static String WHERE_PARAMETER = " WHERE %s LIKE ?";
    public static String INSERT_INTO = "INSERT INTO %s (";
    public static String UPDATE_QUERY = "UPDATE %s SET ";
    public static String DELETE_QUERY = "DELETE FROM %s WHERE ";
    public static String SELECT_MAX_ID = "SELECT MAX(%s) FROM %s;";
    
    public static String FIELDS_ROLE = " r.idRole, r.identifiant as identifiantRole, r.description as descriptionRole, "
                                     + " r.marquerEffacer as marquerEffacerRole, r.version as versionRole";
    
    public static String FIELDS_UTILISATEUR = " u.idUtilisateur, u.civilite as civiliteUtilisateur, u.prenom as prenomUtilisateur, u.nom as nomUtilisateur,"
                                            + " u.identifiant as identifiantUtilisateur, u.motPasse as motPasseUtilisateur,"
                                            + " u.dateNaissance as dateNaissanceUtilisateur, u.dateCreation as dateCreationUtilisateur, "
                                            + " u.dateModification as dateModificationUtilisateur, u.actif as actifUtilisateur, u.marquerEffacer as marquerEffacerUtilisateur,"
                                            + " u.version as versionUtilisateur";
    
    public static String FIELDS_ADRESSE = " a.idAdresse, a.idUtilisateur, a.rue, a.codePostal, a.ville, a.pays, a.statut, a.typeAdresse, "
                                        + "a.principale, a.version as versionAdresse";
    
    public static String FIELDS_ARTICLE_COMMANDE = " ac.idArticleCommande, ac.totalArticleCommande, ac.reference as referenceArticleCommande,"
                                                 + " ac.quantite as quantiteArticleCommande, ac.statut as statutArticleCommande, "
                                                 + " ac.dateModification as dateModificationArticleCommande, ac.version as versionArticleCommande, "
                                                 + " ac.idCommande, ac.idUtilisateur, ac.idAdresse, ac.idProduit";
    
    public static String FIELDS_COMMANDE = " c.idCommande, c.totalCommande, c.statut as statutCommande,"
                                         + " c.dateCommande, c.dateModification as dateModificationCommande, "
                                         + " c.version as versionCommande, c.idUtilisateur, c.idAdresse";
    
    public static String FIELDS_PRODUIT = " p.idProduit, p.reference as referenceProduit, p.prix as prixProduit,"
                                        + " p.nom as nomProduit, p.description as descriptionProduit, p.stock as stockProduit,"
                                        + " p.active as activeProduit, p.marquerEffacer as marquerEffacerProduit, p.version as versionProduit";
    
    public static String SELECT_ALL_ROLE = "SELECT " + FIELDS_ROLE + " FROM Role r";
    public static String SELECT_ROLE_BY_IDENTIFIANT = SELECT_ALL_ROLE + " WHERE identifiant = ?";
    public static String SELECT_ROLE_BY_ROLE = SELECT_ALL_ROLE + WHERE_PARAMETER;
    public static String SELECT_FIND_UTILISATEUR_BY_CRITERIA = "SELECT " + FIELDS_UTILISATEUR + "," + FIELDS_ROLE
                                                             + " FROM Utilisateur u LEFT JOIN Role r ON u.idRole = r.idRole "
                                                             + " WHERE %s = ?";
    
    public static String SELECT_ALL_UTILISATEUR_ROLE = "SELECT " + FIELDS_UTILISATEUR + ", " + FIELDS_ROLE
                                                     + " FROM Utilisateur u LEFT JOIN Role r ON u.idRole = r.idRole";

    public static String SELECT_ALL_ADRESSE = "SELECT " + FIELDS_ADRESSE + ", " + FIELDS_UTILISATEUR + ", " + FIELDS_ROLE
                                            + " FROM Adresse a LEFT JOIN Utilisateur u ON u.idUtilisateur = a.idUtilisateur"
                                            + " LEFT JOIN Role r ON u.idRole = r.idRole";
    
    public static String SELECT_ADRESSE_BY_PARAMETER = SELECT_ALL_ADRESSE + WHERE_PARAMETER;
    
    public static String SELECT_ALL_ARTICLE_COMMANDE = "SELECT " + FIELDS_ARTICLE_COMMANDE + ", " + FIELDS_UTILISATEUR + ", " + FIELDS_ROLE + ", "
                                                     + FIELDS_COMMANDE + ", " + FIELDS_PRODUIT + ", " + FIELDS_ADRESSE
                                                     + " FROM ArticleCommande ac LEFT JOIN Commande c ON c.idCommande = ac.idCommande"
                                                     + " LEFT JOIN Utilisateur u ON u.idUtilisateur = ac.idUtilisateur"
                                                     + " LEFT JOIN Role r ON u.idRole = r.idRole"
                                                     + " LEFT JOIN Adresse a ON a.idAdresse = ac.idAdresse"
                                                     + " LEFT JOIN Produit p ON p.idProduit = ac.idProduit";
    
    public static String SELECT_ARTICLE_COMMANDE_BY_PARAMETER =  SELECT_ALL_ARTICLE_COMMANDE + WHERE_PARAMETER;
    
    public static String SELECT_ALL_COMMANDE = "SELECT " + FIELDS_COMMANDE + ", " + FIELDS_UTILISATEUR + ", " 
                                             + FIELDS_ROLE + ", " + FIELDS_ADRESSE
                                             + " FROM Commande c LEFT JOIN Utilisateur u ON c.idUtilisateur = u.idUtilisateur"
                                             + " LEFT JOIN Role r ON u.idRole = r.idRole LEFT JOIN Adresse a ON a.idAdresse = c.idAdresse ";
    
    public static String SELECT_COMMANDE_BY_PRODUCT_PARAMETER = SELECT_ALL_COMMANDE + " LEFT JOIN ArticleCommande ac ON ac.idCommande = c.idCommande " + WHERE_PARAMETER;
    
    public static String SELECT_COMMANDE_BY_PARAMETER = SELECT_ALL_COMMANDE + WHERE_PARAMETER;
    
    public static String SELECT_ALL_PRODUIT = "SELECT " + FIELDS_PRODUIT + " FROM Produit p";
    
    public static String SELECT_PRODUIT_BY_PARAMETER = SELECT_ALL_PRODUIT + WHERE_PARAMETER;
    
    public static String CSV_SEPARATOR = ";";  
}
