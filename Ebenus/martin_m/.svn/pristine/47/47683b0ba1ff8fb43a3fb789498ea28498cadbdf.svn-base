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
import com.cours.ebenus.dao.impl.AdresseDao;
import com.cours.ebenus.dao.impl.ArticleCommandeDao;
import com.cours.ebenus.dao.impl.CommandeDao;
import com.cours.ebenus.dao.impl.ProduitDao;
import com.cours.ebenus.dao.impl.RoleDao;
import com.cours.ebenus.dao.impl.UtilisateurDao;

/**
 * DaoFactory 
 * @author soubri_j/martin_m
 */
public class DaoFactory extends AbstractDaoFactory {
    
    private DaoFactory() {
        
    }

    /**
     * Holder class for thread safe Singleton
     */
    private static class DaoFactoryHolder {
        private static final DaoFactory instance = new DaoFactory();
    }
    
    /**
     * Method used to get a unique instance of DaoFactory.
     * @return A unique DaoFactory
     */
    public static AbstractDaoFactory getInstance() {
        return DaoFactoryHolder.instance;
    }
    
    /**
     * Method used to get an instance of UtilisateurDao.
     * @return A unique instance of UtilisateurDao
     */
    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return UtilisateurDao.getInstance();
    }

    /**
     * Method used to get an instance of RoleDao.
     * @return A unique instance of RoleDao
     */
    @Override
    public IRoleDao getRoleDao() {
        return RoleDao.getInstance();
    }

    /**
     * Method used to get an instance of AdresseDao.
     * @return A unique instance of AdresseDao
     */
    @Override
    public IAdresseDao getAdresseDao() {
        return AdresseDao.getInstance();
    }

    /**
     * Method used to get an instance of ArticleCommandeDao
     * @return A unique instance of ArticleCommandeDao
     */
    @Override
    public IArticleCommandeDao getArticleCommandeDao() {
        return ArticleCommandeDao.getInstance();
    }

    /**
     * Method used to get an instance of ProduitDao
     * @return A unique instance of ProduitDao
     */
    @Override
    public IProduitDao getProduitDao() {
        return ProduitDao.getInstance();
    }

    /**
     * Method used to get an instance of CommandeDao
     * @return a unique instance of CommandeDao
     */
    @Override
    public ICommandeDao getCommandeDao() {
        return CommandeDao.getInstance();
    }
}
