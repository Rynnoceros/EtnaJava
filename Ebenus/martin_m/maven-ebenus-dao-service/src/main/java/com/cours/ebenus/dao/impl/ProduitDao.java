/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.IProduitDao;
import com.cours.ebenus.dao.entities.Produit;
import com.cours.ebenus.utils.Constants;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Produit DAO.
 * @author soubri_j/martin_m
 */
public class ProduitDao extends AbstractDao<Produit> implements IProduitDao {

    private static final Log log = LogFactory.getLog(ProduitDao.class);

    /**
     * Default constructor
     */
    private ProduitDao() {
        super(Produit.class);
    }
    
    /**
     * Holder class.
     */
    private static class ProduitDaoHolder {
        private static final ProduitDao instance = new ProduitDao();
    }
    
    /**
     * Method used to get an instance of ProduitDao
     * @return A unique instance of ProduitDao
     */
    public static ProduitDao getInstance() {
        return ProduitDaoHolder.instance;
    }
    
    /**
     * Find all products in database.
     * @return List of all products
     */
    @Override
    public List<Produit> findAllProduits() {
        return super.findByCriteria(Constants.SELECT_ALL_PRODUIT, new String[]{}, new String[]{});
    }

    /**
     * Find product by id.
     * @param idProduit The id of the product to find
     * @return The product if found, null otherwise
     */
    @Override
    public Produit findProduitById(int idProduit) {
        List<Produit> produits = super.findByCriteria(Constants.SELECT_PRODUIT_BY_PARAMETER, new String[]{ "idProduit "}, new String[]{ String.valueOf(idProduit)});
        if (produits != null && produits.size() > 0) {
            return produits.get(0);
        }
        return null;
    }

    /**
     * Find product by reference
     * @param reference The reference of the products to find
     * @return List of all products corresponding to the reference
     */
    @Override
    public List<Produit> findProduitByReference(String reference) {
        return super.findByCriteria(Constants.SELECT_PRODUIT_BY_PARAMETER, new String[]{ "reference" }, new String[]{ String.valueOf(reference)});
    }
    
    /**
     * Create a product
     * @param produit The product to create
     * @return The created product if ok, null otherwise
     */
    @Override
    public Produit createProduit(Produit produit) {
        return super.create(produit);
    }

    /**
     * Update a product
     * @param produit The product to update
     * @return The updated product if ok, null otherwise
     */
    @Override
    public Produit updateProduit(Produit produit) {
        return super.update(produit);
    }

    /**
     * Delete a product
     * @param produit The product to delete
     * @return true if product was deleted, false otherwise
     */
    @Override
    public boolean deleteProduit(Produit produit) {
        return super.delete(produit);
    }
    
}
