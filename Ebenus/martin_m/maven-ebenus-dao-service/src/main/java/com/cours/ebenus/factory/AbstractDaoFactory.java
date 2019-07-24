/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.factory;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * AbstractDaoFactory class.
 * @author soubri_j/martin_m
 */
public abstract class AbstractDaoFactory {
    
    private static final Log log = LogFactory.getLog(AbstractDaoFactory.class);
    
    public enum FactoryDaoType {
        JDBC_DAO_FACTORY
    }
    
    public abstract IUtilisateurDao getUtilisateurDao();
    
    public abstract IRoleDao getRoleDao();
    
    public abstract IAdresseDao getAdresseDao();
    
    public abstract IArticleCommandeDao getArticleCommandeDao();
    
    public abstract IProduitDao getProduitDao();
    
    public abstract ICommandeDao getCommandeDao();
    
    /**
     * Méthode pour récupérer une factory de DAO
     *
     * @param daoType
     * @return AbstractDaoFactory
     */
    public static AbstractDaoFactory getFactory(FactoryDaoType daoType) {
        switch (daoType) {
            case JDBC_DAO_FACTORY:
                return DaoFactory.getInstance();
            default:
                return DaoFactory.getInstance();
        }
    }
}
