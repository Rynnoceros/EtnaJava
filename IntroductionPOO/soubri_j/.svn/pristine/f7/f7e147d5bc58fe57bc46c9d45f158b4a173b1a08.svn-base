/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author elhad
 */
public class Animal {
	private int idAnimal;
	private String nom;
	private double poids;
	private Date dateNaissance;
	private String couleur;
	private int nombrePattes;
	private boolean estCarnivore;
	
	public Animal(int id, String nom, double poids, Date date, 
					String couleur, int nbPattes, boolean estCarnivore) {
		this.idAnimal = id;
		this.nom = nom;
		this.poids = poids;
		this.dateNaissance = date;
		this.couleur = couleur;
		this.nombrePattes = nbPattes;
		this.estCarnivore = estCarnivore;
	}
	
	public void marcher() {
		System.out.println(String.format("l'animal %s marche avec %d pattes", nom, nombrePattes));
	}
	
	public void description() {
		System.out.println(String.format("l'animal %s est née le %d, il pèse %d, il est de couleur %s, il a %d pattes, il %s.",
				nom, dateNaissance, poids, couleur, nombrePattes, estCarnivore ? "est carnivore" : "n'est pas carnivore"));
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format(Locale.ROOT, "%d, %s, %.2f, %s, %s, %d, %s", 
							idAnimal,
							nom,
							poids,
							sdf.format(dateNaissance),
							couleur,
							nombrePattes,
							estCarnivore);
	}
	
	public boolean equals(Animal animal) {
		return animal.idAnimal == animal.getIdAnimal();
	}

	public int hashCode() {
		return 50 * idAnimal;
	}
	
	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getNombrePattes() {
		return nombrePattes;
	}

	public void setNombrePattes(int nombrePattes) {
		this.nombrePattes = nombrePattes;
	}

	public boolean isEstCarnivore() {
		return estCarnivore;
	}

	public void setEstCarnivore(boolean estCarnivore) {
		this.estCarnivore = estCarnivore;
	}
}
