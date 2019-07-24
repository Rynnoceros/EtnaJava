/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.service.impl;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.factory.AbstractDaoFactory;
import com.cours.ebenus.service.IServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Service facade. Used to get the right dao.
 * @author soubri_j/martin_m
 */
public class ServiceFacade implements IServiceFacade {

    private static final Log log = LogFactory.getLog(ServiceFacade.class);
    private final AbstractDaoFactory.FactoryDaoType DEFAULT_IMPLEMENTATION = AbstractDaoFactory.FactoryDaoType.JDBC_DAO_FACTORY;
    
    private IUtilisateurDao _utilisateurDao = null;
    private IRoleDao _roleDao = null;
    private IAdresseDao _adresseDao = null;
    private IArticleCommandeDao _articleCommandeDao = null;
    private ICommandeDao _commandeDao = null;
    private IProduitDao _produitDao = null;
    
    /**
     * Default constructor
     */
    public ServiceFacade () {
        _utilisateurDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getUtilisateurDao();
        _roleDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getRoleDao();
        _adresseDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getAdresseDao();
        _articleCommandeDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getArticleCommandeDao();
        _commandeDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getCommandeDao();
        _produitDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getProduitDao();
    }
    
    /**
     * Constructor taking the type of DAO.
     * @param daoType DAO Type
     */
    public ServiceFacade (AbstractDaoFactory.FactoryDaoType daoType) {
        _utilisateurDao = AbstractDaoFactory.getFactory(daoType).getUtilisateurDao();
        _roleDao = AbstractDaoFactory.getFactory(daoType).getRoleDao();
        _adresseDao = AbstractDaoFactory.getFactory(daoType).getAdresseDao();
        _articleCommandeDao = AbstractDaoFactory.getFactory(daoType).getArticleCommandeDao();
        _commandeDao = AbstractDaoFactory.getFactory(daoType).getCommandeDao();
        _produitDao = AbstractDaoFactory.getFactory(daoType).getProduitDao();
    }
    
    /**
     * @return UtilisateurDao instance
     */
    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return _utilisateurDao;
    }

    /**
     * @return RoleDao instance
     */
    @Override
    public IRoleDao getRoleDao() {
        return _roleDao;
    }

    /**
     * @return AdresseDao instance
     */
    @Override
    public IAdresseDao getAdresseDao() {
        return _adresseDao;
    }

    /**
     * @return ArticleCommandeDao instance
     */
    @Override
    public IArticleCommandeDao getArticleCommandeDao() {
        return _articleCommandeDao;
    }

    /**
     * @return ProduitDao instance
     */
    @Override
    public IProduitDao getProduitDao() {
        return _produitDao;
    }

    /**
     * @return CommandeDao instance
     */
    @Override
    public ICommandeDao getCommandeDao() {
        return _commandeDao;
    }
    

}
