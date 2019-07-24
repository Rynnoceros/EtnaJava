package com.cours.ebenus.dao.test;

import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.dao.entities.Commande;
import com.cours.ebenus.dao.entities.Produit;
import com.cours.ebenus.dao.entities.Role;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import java.util.Date;

public class JUnitArticleCommandeDao {

    private static final Log log = LogFactory.getLog(JUnitArticleCommandeDao.class);
    private static IServiceFacade serviceFacade = null;
    // Compter le nombre d'utilisateurs et de roles dans votre base de données.
    private static final int NB_ARTICLES_COMMANDES_LIST = 1647;

    private static final int ARTICLE_COMMANDE_FIND_BY_ID = 1;

    private static final int ARTICLE_COMMANDE_FIND_BY_ID_COMMANDE = 604;
    private static final int NB_ARTICLES_COMMANDES_FIND_BY_ID_COMMANDE = 3;

    private static List<ArticleCommande> articlesCommandes = null;

    @BeforeClass
    public static void init() throws Exception {
        // Configuration de l'application
    	serviceFacade = new ServiceFacade();
    	articlesCommandes = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
    }
    
    public void verifyArticleCommandeDatas(ArticleCommande articleCommande) {
        log.debug("Entree de la methode");
        if (articleCommande != null) {
            log.debug("idArticleCommande : " + articleCommande.getIdArticleCommande());
            Assert.assertNotNull(articleCommande.getIdArticleCommande());
            Assert.assertNotNull(articleCommande.getUtilisateur());
            Assert.assertNotNull(articleCommande.getAdresse());
            Assert.assertNotNull(articleCommande.getCommande());
            Assert.assertNotNull(articleCommande.getProduit());
            Assert.assertNotNull(articleCommande.getDateModification());
        } else if (articleCommande == null) {
            Assert.fail("ArticleCommande null");
        }
        log.debug("Sortie de la methode");
    }
    
    public void verifyArticlesCommandesDatas(List<ArticleCommande> articlesCommandes) {
        log.debug("Entree de la methode");
        if (articlesCommandes != null) {
            log.debug("articlesCommandes.size(): " + articlesCommandes.size());
            for (ArticleCommande articleCommande : articlesCommandes) {
                verifyArticleCommandeDatas(articleCommande);
            }
        } else if (articlesCommandes == null || articlesCommandes.isEmpty()) {
            Assert.fail("Aucune association article/commande n'a ete trouvee dans votre liste");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllCommandes() {
        log.debug("Entree de la methode");
        if (articlesCommandes != null) {
            log.debug("NB_COMMANDES_LIST: " + NB_ARTICLES_COMMANDES_LIST + " , articlesCommandes.size(): " + articlesCommandes.size());
            Assert.assertEquals(NB_ARTICLES_COMMANDES_LIST, articlesCommandes.size());
            verifyArticlesCommandesDatas(articlesCommandes);
        } else {
            Assert.fail("Aucune association article/commande n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindByCriteria() {
        log.debug("Entree de la methode");
        ArticleCommande articleCommandeById = serviceFacade.getArticleCommandeDao().findArticleCommandeById(ARTICLE_COMMANDE_FIND_BY_ID);
        List<ArticleCommande> articlesCommandesByIdCommande = serviceFacade.getArticleCommandeDao().findArticleCommandeByIdCommande(ARTICLE_COMMANDE_FIND_BY_ID_COMMANDE);
        
        if (articleCommandeById != null) {
            log.debug("ArticleCommande id " + ARTICLE_COMMANDE_FIND_BY_ID + " found");
            Assert.assertNotNull(articleCommandeById);
            verifyArticleCommandeDatas(articleCommandeById);
        } else {
            Assert.fail("ArticleCommande id " + ARTICLE_COMMANDE_FIND_BY_ID + " non trouvee dans la base de données");
        }
        
        if (articlesCommandesByIdCommande != null && !articlesCommandesByIdCommande.isEmpty()) {
            log.debug("NB_ARTICLES_COMMANDES_FIND_BY_ID_COMMANDE: " + NB_ARTICLES_COMMANDES_FIND_BY_ID_COMMANDE + " , articlesCommandesByIdCommande.size(): " + articlesCommandesByIdCommande.size());
            Assert.assertEquals(NB_ARTICLES_COMMANDES_FIND_BY_ID_COMMANDE, articlesCommandesByIdCommande.size());
            verifyArticlesCommandesDatas(articlesCommandesByIdCommande);
        } else {
            Assert.fail("Aucune association aricle/commande avec le commande id '" + ARTICLE_COMMANDE_FIND_BY_ID_COMMANDE + "' n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testCreateUpdateDeleteArticleCommande() {
        log.debug("Entree de la methode");        
        Role roleCRUD = serviceFacade.getRoleDao().createRole(new Role("Test", "Test role"));
        Assert.assertNotNull(roleCRUD);
        Utilisateur userCRUD = new Utilisateur("Mme", "Nicole", "Valentine", "nicole.valentine@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), roleCRUD);
        userCRUD = serviceFacade.getUtilisateurDao().createUtilisateur(userCRUD);
        Assert.assertNotNull(userCRUD);
        log.debug("Created userCRUD : " + userCRUD);
        Adresse adrCRUD = new Adresse(userCRUD, "6 rue de l arbre", "63122", "Ceyrat", "FRANCE");
        adrCRUD = serviceFacade.getAdresseDao().createAdresse(adrCRUD);
        Assert.assertNotNull(adrCRUD);
        Commande commandeCRUD = new Commande(0, 1260.0, Commande.CommandeStatut.Temporaire.toString(), new Date(), new Date(), 1, userCRUD, adrCRUD);
        commandeCRUD = serviceFacade.getCommandeDao().createCommande(commandeCRUD);
        Assert.assertNotNull(commandeCRUD);
        commandeCRUD = serviceFacade.getCommandeDao().findCommandeById(commandeCRUD.getIdCommande());
        Assert.assertNotNull(commandeCRUD);
        Produit produitCRUD = new Produit("REF_PIGEON", 24.99, "Pigeon", "Pigeon en peluche");
        produitCRUD = serviceFacade.getProduitDao().createProduit(produitCRUD);
        Assert.assertNotNull(produitCRUD);
        ArticleCommande articleCommandeCRUD = new ArticleCommande(300.90, "CMD_PIGEON", 12, Commande.CommandeStatut.Valide.toString(), commandeCRUD, userCRUD, adrCRUD, produitCRUD);
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().createArticleCommande(articleCommandeCRUD);
        Assert.assertNotNull(articleCommandeCRUD);
        verifyArticleCommandeDatas(articleCommandeCRUD);
        articleCommandeCRUD.setQuantite(20);
        articleCommandeCRUD.setTotalArticleCommande(400.00);
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().updateArticleCommande(articleCommandeCRUD);
        log.debug("Updated articleCommandeCRUD : " + articleCommandeCRUD);
        Assert.assertNotNull(articleCommandeCRUD);
        Assert.assertTrue(400.00 == articleCommandeCRUD.getTotalArticleCommande());
        Assert.assertTrue(20.00 == articleCommandeCRUD.getQuantite());
        commandeCRUD.setStatut(Commande.CommandeStatut.Valide.toString());
        commandeCRUD.setTotalCommande(1300.0);
        commandeCRUD = serviceFacade.getCommandeDao().updateCommande(commandeCRUD);
        Assert.assertNotNull(commandeCRUD);
        Assert.assertTrue(serviceFacade.getArticleCommandeDao().deleteArticleCommande(articleCommandeCRUD));
        articleCommandeCRUD = serviceFacade.getArticleCommandeDao().findArticleCommandeById(articleCommandeCRUD.getIdArticleCommande());
        Assert.assertNull(articleCommandeCRUD);
        Assert.assertTrue(serviceFacade.getCommandeDao().deleteCommande(commandeCRUD));
        commandeCRUD = serviceFacade.getCommandeDao().findCommandeById(commandeCRUD.getIdCommande());
        Assert.assertNull(commandeCRUD);
        Assert.assertTrue(serviceFacade.getAdresseDao().deleteAdresse(adrCRUD));
        adrCRUD = serviceFacade.getAdresseDao().findAdresseById(adrCRUD.getIdAdresse());
        Assert.assertNull(adrCRUD);
        Assert.assertTrue(serviceFacade.getUtilisateurDao().deleteUtilisateur(userCRUD));
        userCRUD = serviceFacade.getUtilisateurDao().findUtilisateurById(userCRUD.getIdUtilisateur());
        Assert.assertNull(userCRUD);
        Assert.assertTrue(serviceFacade.getRoleDao().deleteRole(roleCRUD));
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        Assert.assertNull(roleCRUD);
        List<ArticleCommande> articlesCommandesFinal = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
        if (articlesCommandesFinal != null) {
            Assert.assertEquals(NB_ARTICLES_COMMANDES_LIST, articlesCommandesFinal.size());
            log.debug("articlesCommandesFinal.size() : " + articlesCommandesFinal.size() + " , NB_ARTICLES_COMMANDES_LIST: " + NB_ARTICLES_COMMANDES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
    @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        serviceFacade = null;
        articlesCommandes = null;
        log.debug("Sortie de la methode");
    }
}
