/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.factory;

import com.cours.singletons.AbstractSingleton;
import com.cours.singletons.CsvSingleton;
import com.cours.singletons.JsonSingleton;
import com.cours.singletons.XmlSingleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author ElHadji
 */
public class SingletonFactory {

    public static String className = SingletonFactory.class.getName();
    private static final Log log = LogFactory.getLog(SingletonFactory.class);

    public enum FactorySingletonType {

        CSV_SINGLETON_FACTORY, XML_SINGLETON_FACTORY, JSON_SINGLETON_FACTORY
    }

    /**
     * @param type
     * @return AbstractStatisticSingleton
     */
    public static AbstractSingleton getFactory(FactorySingletonType type) {
    	AbstractSingleton singleton = null;
    	
        switch (type) {
        	case CSV_SINGLETON_FACTORY:
        		singleton = CsvSingleton.getInstance();
        		break;
        	case XML_SINGLETON_FACTORY:
        		singleton = XmlSingleton.getInstance();
        		break;
        	case JSON_SINGLETON_FACTORY:
        		singleton = JsonSingleton.getInstance();
        		break;
        	default:
        		log.error("Unknown singleton type");
        }
        
        return singleton;
    }
}
