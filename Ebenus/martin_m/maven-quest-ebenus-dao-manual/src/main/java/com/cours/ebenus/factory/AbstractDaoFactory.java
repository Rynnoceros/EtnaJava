/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.factory;

import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public abstract class AbstractDaoFactory {

    public static String className = AbstractDaoFactory.class.getName();
    private static final Log log = LogFactory.getLog(AbstractDaoFactory.class);

    public enum FactoryDaoType {

        MANUAL_LIST_DAO_FACTORY, MANUAL_ARRAY_DAO_FACTORY, MANUAL_MAP_DAO_FACTORY;
    }

    public abstract IUtilisateurDao getUtilisateurDao();

    public abstract IRoleDao getRoleDao();

    /**
     * Méthode pour récupérer une factory de DAO
     *
     * @param daoType Type of Dao to return
     * @return AbstractDaoFactory if ok null otherwise
     */
    public static AbstractDaoFactory getFactory(FactoryDaoType daoType) {
    	AbstractDaoFactory daoFactory = null;
    	
        switch(daoType) {
        	case MANUAL_LIST_DAO_FACTORY :
        		daoFactory = new ManualListDaoFactory();
        		break;
        	case MANUAL_ARRAY_DAO_FACTORY :
        		daoFactory = new ManualArrayDaoFactory();
        		break;
        	case MANUAL_MAP_DAO_FACTORY :
        		daoFactory = new ManualMapDaoFactory();
        		break;
        };
        
        return daoFactory;
    }
}
