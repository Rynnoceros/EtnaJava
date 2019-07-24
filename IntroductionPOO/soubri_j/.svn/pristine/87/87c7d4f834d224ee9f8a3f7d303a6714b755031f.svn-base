package com.cours.main;

import java.util.List;

import com.cours.dao.IPersonneDao;
import com.cours.dao.factory.AbstractDaoFactory;
import com.cours.dao.factory.AbstractDaoFactory.FactoryType;
import com.cours.entities.Personne;

public class MainDao {

    public static void main(String[] args) {
    	AbstractDaoFactory facto = AbstractDaoFactory.getDaoFactory(FactoryType.CSV_DAO);
    	IPersonneDao csv = facto.getPersonneDao();
    	List<Personne> personnes = csv.findAll();
    	for (Personne personne : personnes) {
    		System.out.println(personne);
    	}
    	
    	int id = 3;
    	Personne toFind = csv.findById(id);
    	if (toFind != null) {
    		System.out.println(String.format("Personne id %s found", id));
    		System.out.println(toFind);
    	}
    	
    	Personne newPerson = new Personne("Jordan", "SOUBRIER", 83.00, 185.00,
    			"Rue de l'arbre", "Ceyrat", "63122");
    	newPerson.setId(0);
    	newPerson = csv.create(newPerson);
    	if (newPerson != null) {
    		System.out.println(String.format("Personne created id : %d", newPerson.getId()));
    	}
    	
    	if (csv.delete(toFind)) {
    		System.out.println(String.format("Personne %d deleted", toFind.getId()));
    	}
    	
    	facto = AbstractDaoFactory.getDaoFactory(FactoryType.JSON_DAO);
    	IPersonneDao json = facto.getPersonneDao();
    	personnes = json.findAll();
    	for (Personne personne : personnes) {
    		System.out.println(personne);
    	}
    	
    	newPerson = new Personne("Jordan", "SOUBRIER", 83.00, 185.00,
    			"Rue de l'arbre", "Ceyrat", "63122");
    	newPerson.setId(0);
    	newPerson = json.create(newPerson);
    	if (newPerson != null) {
    		System.out.println(String.format("Personne created id : %d", newPerson.getId()));
    	}
    	
    	toFind = json.findById(4);
    	
    	if (json.delete(toFind)) {
    		System.out.println(String.format("Personne %d deleted", toFind.getId()));
    	}
    	
    	facto = AbstractDaoFactory.getDaoFactory(FactoryType.XML_DAO);
    	IPersonneDao xml = facto.getPersonneDao();
    	personnes = xml.findAll();
    	for (Personne personne : personnes) {
    		System.out.println(personne);
    	}
    	
    	newPerson = new Personne("Jordan", "SOUBRIER", 83.00, 185.00,
    			"Rue de l'arbre", "Ceyrat", "63122");
    	newPerson.setId(0);
    	newPerson = xml.create(newPerson);
    	if (newPerson != null) {
    		System.out.println(String.format("Personne created id : %d", newPerson.getId()));
    	}
    	
    	toFind = xml.findById(5);
    	if (xml.delete(toFind)) {
			System.out.println(String.format("Personne %d deleted", toFind.getId()));
		}
    }
}
