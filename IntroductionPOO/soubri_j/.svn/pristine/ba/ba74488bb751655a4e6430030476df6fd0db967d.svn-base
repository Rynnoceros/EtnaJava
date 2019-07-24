package com.cours.entities;

import com.cours.utils.Constants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ElHadji
 */
public class Personne {
	// Attributes
	private Integer id;
	private String prenom;
	private String nom;
	private Double poids;
	private Double taille;
	private String rue;
	private String ville;
	private String codePostal;
	
	public Personne () {
		
	}
	
	public Personne(String prenom, String nom, Double poids, Double taille,
					String rue, String ville, String codePostal) {
		this.id = null;
		this.prenom = prenom;
		this.nom = nom;
		this.poids = poids;
		this.taille = taille;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	// Getters and setters
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Double getPoids() {
		return poids;
	}
	
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	
	public Double getTaille() {
		return taille / 100;
	}
	
	public void setTaille(Double taille) {
		this.taille = taille;
	}
	
	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	// Methods
	/**
	 * Method to print Personne description.
	 */
	public String toString() {
		return String.format("%d;%s;%s;%.0f;%.0f;%s;%s;%s",id, prenom, nom, poids, taille,
				rue, ville, codePostal);
	}
	
	/**
	 * Method to test if a Personne is equal to another
	 * @param personne The person to compare
	 * @return true if personne is equal, false otherwise
	 */
	public boolean equals(Personne personne) {
		boolean isEqual = false;
		
		if (personne != null) {
			isEqual = personne.getId() == id;
		}
		
		return isEqual;
	}
	
	/**
	 * Method used to compare 2 Personne
	 * @param personne Personne to compare
	 * @return return -1 if instance before personne, 1 if after 0 if equal.
	 */
	public int compareTo(Personne personne) {
		return Integer.compare(id, personne.id);
	}
	
	/**
	 * Method to return hashCode of the personne.
	 */
	public int hashCode() {
		return 13 * id.hashCode();
	}
	
	/**
	 * Method to get Imc value of a person
	 * @return Imc of the person if ok, 0 otherwise.
	 */
	public Double getImc() {
		Double dImc = 0.0;
		Double t = getTaille();
		
		if (t > 0) {
			dImc = poids / (t * t);
		}
		
		return dImc;
	}
	
	/**
	 * Method that returns if a person is slim
	 * @return true if the person is slim, false otherwise.
	 */
	public boolean isMaigre() {
		Double dImc = getImc();
		
		return (dImc >= Constants.LIMITE_INF_MAIGRE && dImc < Constants.LIMITE_SUP_MAIGRE);
	}
	
	/**
	 * Method that returns if a person is fat
	 * @return true if the person is fat, false otherwise.
	 */
	public boolean isSurpoids() {
		Double dImc = getImc();
		
		return (dImc >= Constants.LIMITE_INF_SURPOIDS && dImc < Constants.LIMITE_SUP_SURPOIDS);
	}
	
	/**
	 * Method that return if a person is very fat
	 * @return true if the person is very fat, false otherwise.
	 */
	public boolean isObese() {
		return getImc() >= Constants.LIMITE_SUP_SURPOIDS;
	}
}
