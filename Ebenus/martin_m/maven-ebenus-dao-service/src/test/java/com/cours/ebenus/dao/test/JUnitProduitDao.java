package com.cours.ebenus.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.cours.ebenus.dao.entities.Produit;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Produit JUnit test class.
 * @author soubri_j/martin_m
 */
public class JUnitProduitDao {
    private static final Log log = LogFactory.getLog(JUnitProduitDao.class);
    private static IServiceFacade serviceFacade = null;
    
    private static final int NB_PRODUITS_LIST = 35;
    
    private static final int PRODUIT_FIND_BY_ID_1 = 1;
    private static final int NB_PRODUIT_FIND_BY_ID_1 = 1;
    private static final String REF_FIND_BY_ID_1 = "REF-IPHONE-3GS";
    
    private static final String PRODUIT_FIND_BY_REF_1 = "%REF-IPHONE%";
    private static final int NB_PRODUITS_FIND_BY_REF_1 = 5;
    
    private static final String PRODUIT_FIND_BY_REF_2 = "%REF-NOKIA%";
    private static final int NB_PRODUITS_FIND_BY_REF_2 = 1;
    
    private static final String PRODUIT_FIND_BY_REF_3 = "%REF-ORDINATEUR%";
    private static final int NB_PRODUITS_FIND_BY_REF_3 = 6;
    
    private static List<Produit> produits = null;
    
    /**
     * Default constructor
     */
    public JUnitProduitDao() {
    }
    
    @BeforeClass
    public static void init() throws Exception {
        // Configuration de l'application
    	serviceFacade = new ServiceFacade();
    	produits = serviceFacade.getProduitDao().findAllProduits();
    }
    
    /**
     * Method to verify Produit consistency
     * @param produit The product to verify
     */
    public void verifyProduitDatas(Produit produit) {
        log.debug("Entree de la methode");
        if (produit != null) {
            log.debug("idProduit : " + produit.getIdProduit());
            Assert.assertNotNull(produit.getIdProduit());
            Assert.assertNotNull(produit.getMarquerEffacer());
            Assert.assertNotNull(produit.getVersion());
        } else if (produit == null) {
            Assert.fail("Produit null");
        }
        log.debug("Sortie de la methode");
    }
    
    /**
     * Method used to verify a list of product consistency
     * @param produits The product list to check
     */
    public void verifyProduitsDatas(List<Produit> produits) {
        log.debug("Entree de la methode");
        if (produits != null) {
            log.debug("produits.size(): " + produits.size());
            for (Produit produit : produits) {
                verifyProduitDatas(produit);
            }
        } else if (produits == null || produits.isEmpty()) {
            Assert.fail("Aucun produit n'a ete trouve dans votre liste");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllProduits() {
        log.debug("Entree de la methode");
        if (produits != null) {
            log.debug("NB_PRODUITS_LIST: " + NB_PRODUITS_LIST + " , produits.size(): " + produits.size());
            Assert.assertEquals(NB_PRODUITS_LIST, produits.size());
            verifyProduitsDatas(produits);
        } else {
            Assert.fail("Aucun produit n'a ete trouve dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindByCriteria() {
        log.debug("Entree de la methode");
        List<Produit> refIphone = serviceFacade.getProduitDao().findProduitByReference(PRODUIT_FIND_BY_REF_1);
        List<Produit> refNokia = serviceFacade.getProduitDao().findProduitByReference(PRODUIT_FIND_BY_REF_2);
        List<Produit> refOrdinateur = serviceFacade.getProduitDao().findProduitByReference(PRODUIT_FIND_BY_REF_3);
        
        
        Produit produit = serviceFacade.getProduitDao().findProduitById(PRODUIT_FIND_BY_ID_1);
        Assert.assertNotNull(produit);
        Assert.assertTrue(produit.getIdProduit() == PRODUIT_FIND_BY_ID_1);
        Assert.assertEquals(produit.getReference(), REF_FIND_BY_ID_1);
        
        if (refIphone != null && refIphone.size() > 0) {
            log.debug("NB_PRODUITS_FIND_BY_REF_1: " + NB_PRODUITS_FIND_BY_REF_1 + " , refIphone.size(): " + refIphone.size());
            Assert.assertNotNull(refIphone);
            Assert.assertEquals(refIphone.size(), NB_PRODUITS_FIND_BY_REF_1);
            verifyProduitsDatas(refIphone);
        } else {
            Assert.fail("Aucune reference contenant '" + REF_FIND_BY_ID_1 + "' n'a ete trouvee dans votre base de données");
        }
        
        if (refNokia != null && refNokia.size() > 0) {
            log.debug("NB_PRODUITS_FIND_BY_REF_2: " + NB_PRODUITS_FIND_BY_REF_2 + " , refNokia.size(): " + refNokia.size());
            Assert.assertNotNull(refNokia);
            Assert.assertEquals(refNokia.size(), NB_PRODUITS_FIND_BY_REF_2);
            verifyProduitsDatas(refNokia);
        } else {
            Assert.fail("Aucune reference contenant '" + NB_PRODUITS_FIND_BY_REF_2 + "' n'a ete trouvee dans votre base de données");
        }
        
        if (refOrdinateur != null && refOrdinateur.size() > 0) {
            log.debug("NB_PRODUITS_FIND_BY_REF_3: " + NB_PRODUITS_FIND_BY_REF_3 + " , refOrdinateur.size(): " + refOrdinateur.size());
            Assert.assertNotNull(refOrdinateur);
            Assert.assertEquals(refOrdinateur.size(), NB_PRODUITS_FIND_BY_REF_3);
            verifyProduitsDatas(refOrdinateur);
        } else {
            Assert.fail("Aucune reference contenant '" + NB_PRODUITS_FIND_BY_REF_3 + "' n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testCreateUpdateDeleteProduit() {
        log.debug("Entree de la methode");
        Produit prodCRUD = new Produit("TEST PRODUIT", 15.0, "Le JSR", "Produit JSR de test description");
        prodCRUD = serviceFacade.getProduitDao().createProduit(prodCRUD);
        Assert.assertNotNull(prodCRUD);
        prodCRUD.setPrix(18.0);
        prodCRUD.setReference("TEST PRODUIT UPDATED");
        prodCRUD = serviceFacade.getProduitDao().updateProduit(prodCRUD);
        Assert.assertNotNull(prodCRUD);
        prodCRUD = serviceFacade.getProduitDao().findProduitById(prodCRUD.getIdProduit());
        log.debug("Updated prodCRUD : " + prodCRUD);
        Assert.assertTrue(18.0 == prodCRUD.getPrix());
        Assert.assertEquals("TEST PRODUIT UPDATED", prodCRUD.getReference());
        Assert.assertTrue(serviceFacade.getProduitDao().deleteProduit(prodCRUD));
        prodCRUD = serviceFacade.getProduitDao().findProduitById(prodCRUD.getIdProduit());
        Assert.assertNull(prodCRUD);
        List<Produit> produitsFinal = serviceFacade.getProduitDao().findAllProduits();
        if (produitsFinal != null) {
            Assert.assertEquals(NB_PRODUITS_LIST, produitsFinal.size());
            log.debug("produitsFinal.size() : " + produitsFinal.size() + " , NB_PRODUITS_LIST: " + NB_PRODUITS_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
    @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        serviceFacade = null;
        produits = null;
        log.debug("Sortie de la methode");
    }
}
