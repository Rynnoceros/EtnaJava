/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import com.cours.singletons.AbstractSingleton;
import com.cours.entities.Personne;
import com.cours.factory.SingletonFactory;
import com.cours.factory.SingletonFactory.FactorySingletonType;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author elhad
 */
public class MainSingleton {

    private static final Log log = LogFactory.getLog(MainSingleton.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	BasicConfigurator.configure();
    	
        AbstractSingleton mySingletonCsv = SingletonFactory.getFactory(FactorySingletonType.CSV_SINGLETON_FACTORY);
        List<Personne> persons = mySingletonCsv.getPersonnes();
        for (Personne person : persons) {
        	log.debug(String.format("CsvSingleton : \n%s\n", person));
        }
        
        AbstractSingleton myXmlSingleton = SingletonFactory.getFactory(FactorySingletonType.XML_SINGLETON_FACTORY);
        List<Personne> persons1 = myXmlSingleton.getPersonnes();
        for (Personne person : persons1) {
        	log.debug(String.format("XmlSingleton : \n%s\n", person));
        }
        log.debug(String.format("Csv person %s\n Xml person %s\nEquals : %b\n Hashcode : %d/%d", persons.get(0), 
        			persons1.get(0), persons.get(0).equals(persons1.get(0)),
        			persons.get(0).hashCode(), persons1.get(0).hashCode()));
        
        AbstractSingleton myJsonSingleton = SingletonFactory.getFactory(FactorySingletonType.JSON_SINGLETON_FACTORY);
        List<Personne> persons2 = myJsonSingleton.getPersonnes();
        for (Personne person : persons2) {
        	log.debug(String.format("JsonSingleton : \n%s\n",person));
        }
    }
}