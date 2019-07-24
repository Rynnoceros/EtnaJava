/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.singletons;

import com.cours.entities.Personne;
import com.cours.utils.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ElHadji
 */
public class JsonSingleton extends AbstractSingleton {

    final String personnesJsonPathFile = Constants.PERSONNES_JSON_PATH_FILE;

    private JsonSingleton() {
    	extractPersonnesDatas();
    }
    
    /* Holder */
    private static class JsonSingletonHolder {
    	private final static JsonSingleton instance = new JsonSingleton();
    }
    
    /**
     * Method to get a unique instance of JsonSingleton
     * @return A unique instance of JsonSingleton
     */
    public static JsonSingleton getInstance() {
    	return JsonSingletonHolder.instance;
    }

    /**
     * Method to create a person using a JSONObject
     * @param jsonObjectPerson a person JSON formated
     * @return an instanciated person if ok, null otherwise.
     */
    public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
        Personne personToReturn = null;
        
        if (jsonObjectPerson != null) {
        	try {        	
        		personToReturn = new Personne();
        		personToReturn.setIdPersonne(Integer.parseInt(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_ID).toString()));
        		personToReturn.setPrenom(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_PRENOM).toString());
        		personToReturn.setNom(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_NOM).toString());
        		personToReturn.setPoids(Double.parseDouble(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_POIDS).toString()));
        		personToReturn.setTaille(Double.parseDouble(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_TAILLE).toString()));
        		personToReturn.setRue(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_RUE).toString());
        		personToReturn.setVille(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_VILLE).toString());
        		personToReturn.setCodePostal(jsonObjectPerson.get(Constants.XML_JSON_ATTRIBUTE_CODE_POSTAL).toString());
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	}
        }
        
        return personToReturn;
    }

    /**
     * Method used to load persons from a JSON file and save it in memory
     */
    @Override
    protected void extractPersonnesDatas() {
    	FileReader fr = null;
    	JSONParser parser = new JSONParser();
    	JSONObject jsonObject = null;
    	JSONArray list = null;
    	Personne personToAdd = null;
    	
    	try {
    		fr = new FileReader(personnesJsonPathFile);
    		if (fr != null) {
    			jsonObject = (JSONObject)parser.parse(fr);
    			if (jsonObject != null) {
    				list = (JSONArray)jsonObject.get(Constants.JSON_PERSONNES);
    				if (list != null && list.size() > 0) {
    					personnes = new ArrayList<Personne>();
    					for (Object personne : list) {
    						personToAdd = createPersonneWithFileObject((JSONObject)personne);
    						if (personToAdd != null) {
    							personnes.add(personToAdd);
    						}
    					}
    				}
    			}
    		}
    	} catch (FileNotFoundException ex) {
    		ex.printStackTrace();
    	} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
}
