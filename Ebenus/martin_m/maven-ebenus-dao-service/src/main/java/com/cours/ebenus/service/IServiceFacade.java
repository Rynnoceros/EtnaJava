/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.service;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.ICommandeDao;
import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;

/**
 * Interface for service facade.
 * @author soubri_j/martin_m
 */
public interface IServiceFacade {
    IUtilisateurDao getUtilisateurDao();
    
    IRoleDao getRoleDao();
    
    IAdresseDao getAdresseDao();
    
    IArticleCommandeDao getArticleCommandeDao();
    
    IProduitDao getProduitDao();
    
    ICommandeDao getCommandeDao();
}
