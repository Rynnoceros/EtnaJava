/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.IArticleCommandeDao;
import com.cours.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.utils.Constants;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ArticleCommande DAO
 * @author soubri_j/martin_m
 */
public class ArticleCommandeDao extends AbstractDao<ArticleCommande> implements IArticleCommandeDao {

    private static final Log log = LogFactory.getLog(ArticleCommandeDao.class);

    /**
     * Default constructor
     */
    private ArticleCommandeDao() {
        super(ArticleCommande.class);
    }
    
    /**
     * Holder class.
     */
    private static class ArticleCommandeDaoHolder {
        private static final ArticleCommandeDao instance = new ArticleCommandeDao();
    }
    
    /**
     * Method used to get a unique instance of ArticleCommandeDao.
     * @return A unique instance of ArticleCommandeDao
     */
    public static ArticleCommandeDao getInstance() {
        return ArticleCommandeDaoHolder.instance;
    }
    
    /**
     * Find all ArticleCommande.
     * @return List of all ArticleCommande in database
     */
    @Override
    public List<ArticleCommande> findAllArticleCommande() {
        return super.findByCriteria(Constants.SELECT_ALL_ARTICLE_COMMANDE, new String[]{}, new String[]{});
    }

    /**
     * Find ArticleCommande by its id.
     * @param idArticleCommande The id of the ArticleCommande to find
     * @return The ArticleCommande if found, null otherwise
     */
    @Override
    public ArticleCommande findArticleCommandeById(int idArticleCommande) {
        List<ArticleCommande> acs = super.findByCriteria(Constants.SELECT_ARTICLE_COMMANDE_BY_PARAMETER, new String[] { "idArticleCommande" }, new String[] { String.valueOf(idArticleCommande) });
        if (acs != null && acs.size() > 0) {
            return acs.get(0);
        }
        return null;
    }

    /**
     * Find ArticleCommande by idCommande.
     * @param idCommande idCommande to find
     * @return List of all ArticleCommande in idCommande
     */
    @Override
    public List<ArticleCommande> findArticleCommandeByIdCommande(Integer idCommande) {
        return super.findByCriteria(Constants.SELECT_ARTICLE_COMMANDE_BY_PARAMETER, new String[]{"ac.idCommande"}, new String[]{ String.valueOf(idCommande)});
    }

    /**
     * Create an ArticleCommande.
     * @param articleCommande The ArticleCommande to create
     * @return The created ArticleCommand if ok, null otherwise
     */
    @Override
    public ArticleCommande createArticleCommande(ArticleCommande articleCommande) {
        return super.create(articleCommande);
    }

    /**
     * Update an ArticleCommande.
     * @param articleCommande The ArticleCommande to update
     * @return The updated ArticleCommande if ok, null otherwise
     */
    @Override
    public ArticleCommande updateArticleCommande(ArticleCommande articleCommande) {
        return super.update(articleCommande);
    }

    /**
     * Delete an ArticleCommande.
     * @param articleCommande The ArticleCommande to delete
     * @return true if ArticleCommande was deleted, false otherwise
     */
    @Override
    public boolean deleteArticleCommande(ArticleCommande articleCommande) {
        return super.delete(articleCommande);
    }
    
}
