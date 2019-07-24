package com.cours.ebenus.dao.test;

import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.dao.entities.Commande;
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

public class JUnitCommandeDao {

    private static final Log log = LogFactory.getLog(JUnitCommandeDao.class);
    private static IServiceFacade serviceFacade = null;
    // Compter le nombre d'utilisateurs et de roles dans votre base de données.
    private static final int NB_COMMANDES_LIST = 621;

    private static final int COMMANDE_FIND_BY_ID = 1;

    private static final int COMMANDE_FIND_BY_UTILISATEUR = 4;
    private static final int NB_COMMANDES_FIND_BY_UTILISATEUR = 162;

    private static final int COMMANDE_FIND_BY_PRODUIT = 9;
    private static final int NB_COMMANDES_FIND_BY_PRODUIT = 297;

    private static List<Commande> commandes = null;

    @BeforeClass
    public static void init() throws Exception {
        // Configuration de l'application
    	serviceFacade = new ServiceFacade();
    	commandes = serviceFacade.getCommandeDao().findAllCommandes();
    }
    
    public void verifyCommandeDatas(Commande commande) {
        log.debug("Entree de la methode");
        if (commande != null) {
            log.debug("idCommande : " + commande.getIdCommande());
            Assert.assertNotNull(commande.getIdCommande());
            Assert.assertNotNull(commande.getUtilisateur());
            Assert.assertNotNull(commande.getAdresse());
            Assert.assertNotNull(commande.getDateCommande());
            Assert.assertNotNull(commande.getDateModification());
        } else if (commande == null) {
            Assert.fail("Commande null");
        }
        log.debug("Sortie de la methode");
    }
    
    public void verifyCommandesDatas(List<Commande> commandes) {
        log.debug("Entree de la methode");
        if (commandes != null) {
            log.debug("commandes.size(): " + commandes.size());
            for (Commande commande : commandes) {
                verifyCommandeDatas(commande);
            }
        } else if (commandes == null || commandes.isEmpty()) {
            Assert.fail("Aucune commande n'a ete trouvee dans votre liste");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllCommandes() {
        log.debug("Entree de la methode");
        if (commandes != null) {
            log.debug("NB_COMMANDES_LIST: " + NB_COMMANDES_LIST + " , commandes.size(): " + commandes.size());
            Assert.assertEquals(NB_COMMANDES_LIST, commandes.size());
            verifyCommandesDatas(commandes);
        } else {
            Assert.fail("Aucune commande n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindByCriteria() {
        log.debug("Entree de la methode");
        Commande commandeById = serviceFacade.getCommandeDao().findCommandeById(COMMANDE_FIND_BY_ID);
        List<Commande> commandesByProduit = serviceFacade.getCommandeDao().findCommandeByIdProduit(COMMANDE_FIND_BY_PRODUIT);
        List<Commande> commandesByUtilisateur = serviceFacade.getCommandeDao().findCommandeByIdUtilisateur(COMMANDE_FIND_BY_UTILISATEUR);
        
        if (commandeById != null) {
            log.debug("Commande id " + COMMANDE_FIND_BY_ID + " found");
            Assert.assertNotNull(commandeById);
            verifyCommandeDatas(commandeById);
        } else {
            Assert.fail("Commande id " + COMMANDE_FIND_BY_ID + " non trouvee dans la base de données");
        }
        
        if (commandesByProduit != null && !commandesByProduit.isEmpty()) {
            log.debug("NB_COMMANDES_FIND_BY_PRODUIT: " + NB_COMMANDES_FIND_BY_PRODUIT + " , commandesByProduit.size(): " + commandesByProduit.size());
            Assert.assertEquals(NB_COMMANDES_FIND_BY_PRODUIT, commandesByProduit.size());
            verifyCommandesDatas(commandesByProduit);
        } else {
            Assert.fail("Aucune commande avec le produit id '" + COMMANDE_FIND_BY_PRODUIT + "' n'a ete trouvee dans votre base de données");
        }
        if (commandesByUtilisateur != null && !commandesByUtilisateur.isEmpty()) {
            log.debug("NB_COMMANDES_FIND_BY_UTILISATEUR: " + NB_COMMANDES_FIND_BY_UTILISATEUR + " , commandesByUtilisateur.size(): " + commandesByUtilisateur.size());
            Assert.assertEquals(NB_COMMANDES_FIND_BY_UTILISATEUR, commandesByUtilisateur.size());
            verifyCommandesDatas(commandesByUtilisateur);
        } else {
            Assert.fail("Aucune commande l'utilisateur id '" + COMMANDE_FIND_BY_UTILISATEUR + "' n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testCreateUpdateDeleteCommande() {
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
        commandeCRUD.setStatut(Commande.CommandeStatut.Valide.toString());
        commandeCRUD.setTotalCommande(1300.0);
        commandeCRUD = serviceFacade.getCommandeDao().updateCommande(commandeCRUD);
        Assert.assertNotNull(commandeCRUD);
        log.debug("Updated commandeCRUD : " + commandeCRUD);
        Assert.assertEquals(Commande.CommandeStatut.Valide.toString(), commandeCRUD.getStatut());
        Assert.assertTrue(1300 == commandeCRUD.getTotalCommande());
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
        List<Commande> commandesFinal = serviceFacade.getCommandeDao().findAllCommandes();
        if (commandesFinal != null) {
            Assert.assertEquals(NB_COMMANDES_LIST, commandesFinal.size());
            log.debug("commandesFinal.size() : " + commandesFinal.size() + " , NB_COMMANDES_LIST: " + NB_COMMANDES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
    @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        serviceFacade = null;
        commandes = null;
        log.debug("Sortie de la methode");
    }
}
