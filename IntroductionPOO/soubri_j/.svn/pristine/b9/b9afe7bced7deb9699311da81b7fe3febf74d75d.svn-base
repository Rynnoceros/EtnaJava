package com.cours.dao.factory;

import com.cours.dao.IPersonneDao;
import com.cours.observer.MyObserver;
import com.cours.observer.MySubjectObserver;

public abstract class AbstractDaoFactory extends MyObserver {

    public abstract IPersonneDao getPersonneDao();

    public enum FactoryType {

        MANUAL_DAO, CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO
    }

    public static AbstractDaoFactory getDaoFactory(FactoryType type) {
    	AbstractDaoFactory toReturn = null;
        MySubjectObserver sujet = new MySubjectObserver();
        MySubjectObserver sujet2 = new MySubjectObserver();
        MySubjectObserver sujet3 = new MySubjectObserver();
        CsvDaoFactory csvDaoFactory = CsvDaoFactory.getInstance(sujet);
        XmlDaoFactory xmlDaoFactory = XmlDaoFactory.getInstance(sujet2);
        JsonDaoFactory jsonDaoFactory = JsonDaoFactory.getInstance(sujet3);
        
        sujet.addObserveur(xmlDaoFactory);
        sujet.addObserveur(jsonDaoFactory);
        sujet2.addObserveur(csvDaoFactory);
        sujet2.addObserveur(jsonDaoFactory);
        sujet3.addObserveur(csvDaoFactory);
	    sujet3.addObserveur(xmlDaoFactory);
	    
	    switch (type) {
        	case CSV_DAO : 		
                toReturn = csvDaoFactory;
        		break;
        	case XML_DAO :
        		toReturn = xmlDaoFactory;
        		break;
        	case JSON_DAO :
                toReturn = jsonDaoFactory;
        		break;
        	default:
        		toReturn = null;
        		break;
        }
        return toReturn;
    }
}
