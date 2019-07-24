/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.utils;

/**
 *
 * @author ElHadji
 */
public class Constants {

    public static String PERSONNES_CSV_PATH_FILE = "personnesCsv.csv";
    public static String PERSONNES_XML_PATH_FILE = "personnesXml.xml";
    public static String PERSONNES_JSON_PATH_FILE = "personnesJson.json";
    public static String IMPLEMENTATION_METIER_FACADE = "metier.MetierFacade";
    public static String CSV_SEPARATOR = ";";
    public static String CSV_HEADER = "idPersonne;Prenom;Nom;Poids;Taille;Rue;Ville;Code Postal";
    public static String CSV_ATTRIBUTE_ID = "idPersonne";
    public static String CSV_ATTRIBUTE_PRENOM = "Prenom";
    public static String CSV_ATTRIBUTE_NOM = "Nom";
    public static String CSV_ATTRIBUTE_POIDS = "Poids";
    public static String CSV_ATTRIBUTE_TAILLE = "Taille";
    public static String CSV_ATTRIBUTE_RUE = "Rue";
    public static String CSV_ATTRIBUTE_VILLE = "Ville";
    public static String CSV_ATTRIBUTE_CODE_POSTAL = "Code Postal";
    public static String XML_JSON_ATTRIBUTE_ID = "id";
    public static String XML_JSON_ATTRIBUTE_PRENOM = "prenom";
    public static String XML_JSON_ATTRIBUTE_NOM = "nom";
    public static String XML_JSON_ATTRIBUTE_POIDS = "poids";
    public static String XML_JSON_ATTRIBUTE_TAILLE = "taille";
    public static String XML_JSON_ATTRIBUTE_RUE = "rue";
    public static String XML_JSON_ATTRIBUTE_VILLE = "ville";
    public static String XML_JSON_ATTRIBUTE_CODE_POSTAL = "codePostal";
    public static String XML_TAG_PERSONNE = "personne";
    public static String JSON_PERSONNES = "personnes";
    // Constante IMC
    public static double LIMITE_INF_MAIGRE = 16.5;
    public static double LIMITE_SUP_MAIGRE = 18.5;

    public static double LIMITE_INF_SURPOIDS = 25;
    public static double LIMITE_SUP_SURPOIDS = 30;
}
