package com.cours.ebenus.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Adresse JUnit test class.
 * @author soubri_j/martin_m
 */
public class JUnitAdresseDao {
    private static final Log log = LogFactory.getLog(JUnitAdresseDao.class);
    private static IServiceFacade serviceFacade = null;
    
    private static final int NB_ADRESSES_LIST = 40;
    
    private static final int ADRESSE_FIND_BY_ID_1 = 1;
    private static final int NB_ADRESSES_FIND_BY_ID_1 = 1;
    private static final String RUE_FIND_BY_ID_1 = "5 rue du Paradis";
    private static final Integer ID_UTILISATEUR_FIND_BY_ID = 1;
    
    private static final String ADRESSE_FIND_BY_RUE_1 = "%rue du bonhneur%";
    private static final int NB_ADRESSES_FIND_BY_RUE_1 = 2;
    
    private static final String ADRESSE_FIND_BY_RUE_2 = "%rue Appert%";
    private static final int NB_ADRESSES_FIND_BY_RUE_2 = 3;
    
    private static final String ADRESSE_FIND_BY_RUE_3 = "%rue de la conscience%";
    private static final int NB_ADRESSES_FIND_BY_RUE_3 = 3;
    
    private static List<Adresse> adresses = null;
    
    /**
     * Default constructor
     */
    public JUnitAdresseDao() {
    }
    
    @BeforeClass
    public static void init() throws Exception {
        // Configuration de l'application
    	serviceFacade = new ServiceFacade();
    	adresses = serviceFacade.getAdresseDao().findAllAdresses();
    }
    
    /**
     * Method to verify Adresse consistency
     * @param adresse The address to verify
     */
    public void verifyAdresseDatas(Adresse adresse) {
        log.debug("Entree de la methode");
        if (adresse != null) {
            log.debug("idAdresse : " + adresse.getIdAdresse());
            Assert.assertNotNull(adresse.getIdAdresse());
            Assert.assertNotNull(adresse.getUtilisateur());
            Assert.assertNotNull(adresse.getStatut());
            Assert.assertNotNull(adresse.getTypeAdresse());
            Assert.assertNotNull(adresse.getPrincipale());
            Assert.assertNotNull(adresse.getVersion());
        } else if (adresse == null) {
            Assert.fail("Adresse null");
        }
        log.debug("Sortie de la methode");
    }
    
    /**
     * Method used to verify a list of address consistency
     * @param adresses The addresses list to check
     */
    public void verifyAdressesDatas(List<Adresse> adresses) {
        log.debug("Entree de la methode");
        if (adresses != null) {
            log.debug("adresses.size(): " + adresses.size());
            for (Adresse adresse : adresses) {
                verifyAdresseDatas(adresse);
            }
        } else if (adresses == null || adresses.isEmpty()) {
            Assert.fail("Aucune adresse n'a ete trouvee dans votre liste");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindAllAdresses() {
        log.debug("Entree de la methode");
        if (adresses != null) {
            log.debug("NB_ADRESSES_LIST: " + NB_ADRESSES_LIST + " , adresses.size(): " + adresses.size());
            Assert.assertEquals(NB_ADRESSES_LIST, adresses.size());
            verifyAdressesDatas(adresses);
        } else {
            Assert.fail("Aucune adresse n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testFindByCriteria() {
        log.debug("Entree de la methode");
        List<Adresse> rueBonheur = serviceFacade.getAdresseDao().findAdresseByRue(ADRESSE_FIND_BY_RUE_1);
        List<Adresse> rueAppert = serviceFacade.getAdresseDao().findAdresseByRue(ADRESSE_FIND_BY_RUE_2);
        List<Adresse> rueConscience = serviceFacade.getAdresseDao().findAdresseByRue(ADRESSE_FIND_BY_RUE_3);
        
        
        Adresse adresse = serviceFacade.getAdresseDao().findAdresseById(NB_ADRESSES_FIND_BY_ID_1);
        Assert.assertNotNull(adresse);
        Assert.assertEquals(adresse.getUtilisateur().getIdUtilisateur(), ID_UTILISATEUR_FIND_BY_ID);
        Assert.assertEquals(adresse.getRue(), RUE_FIND_BY_ID_1);
        
        if (rueBonheur != null && rueBonheur.size() > 0) {
            log.debug("NB_ADRESSES_FIND_BY_RUE_1: " + NB_ADRESSES_FIND_BY_RUE_1 + " , rueBonheur.size(): " + rueBonheur.size());
            Assert.assertNotNull(rueBonheur);
            Assert.assertEquals(rueBonheur.size(), NB_ADRESSES_FIND_BY_RUE_1);
            verifyAdressesDatas(rueBonheur);
        } else {
            Assert.fail("Aucune rue contenant '" + ADRESSE_FIND_BY_RUE_1 + "' n'a ete trouvee dans votre base de données");
        }
        
        if (rueAppert != null && rueAppert.size() > 0) {
            log.debug("NB_ADRESSES_FIND_BY_RUE_2: " + NB_ADRESSES_FIND_BY_RUE_2 + " , rueAppert.size(): " + rueAppert.size());
            Assert.assertNotNull(rueAppert);
            Assert.assertEquals(rueAppert.size(), NB_ADRESSES_FIND_BY_RUE_2);
            verifyAdressesDatas(rueAppert);
        } else {
            Assert.fail("Aucune rue contenant '" + ADRESSE_FIND_BY_RUE_2 + "' n'a ete trouvee dans votre base de données");
        }
        
        if (rueConscience != null && rueConscience.size() > 0) {
            log.debug("NB_ADRESSES_FIND_BY_RUE_3: " + NB_ADRESSES_FIND_BY_RUE_3 + " , rueConscience.size(): " + rueConscience.size());
            Assert.assertNotNull(rueConscience);
            Assert.assertEquals(rueConscience.size(), NB_ADRESSES_FIND_BY_RUE_3);
            verifyAdressesDatas(rueConscience);
        } else {
            Assert.fail("Aucune rue contenant '" + ADRESSE_FIND_BY_RUE_2 + "' n'a ete trouvee dans votre base de données");
        }
        log.debug("Sortie de la methode");
    }
    
    @Test
    public void testCreateUpdateDeleteAdresse() {
        log.debug("Entree de la methode");
        Role roleCRUD = new Role("Test", "Le rôle test");
        roleCRUD = serviceFacade.getRoleDao().createRole(roleCRUD);
        Utilisateur userCRUD = new Utilisateur("Mr", "Jordan", "Soubrier", "soubri_j@etna-alternance.net", "passw0rd", new Date(), roleCRUD);
        userCRUD = serviceFacade.getUtilisateurDao().createUtilisateur(userCRUD);
        Assert.assertNotNull(userCRUD);
        Adresse adrCRUD = new Adresse(userCRUD, "6 rue de l arbre", "63122", "Ceyrat", "FRANCE");
        adrCRUD = serviceFacade.getAdresseDao().createAdresse(adrCRUD);
        Assert.assertNotNull(adrCRUD);
        adrCRUD.setCodePostal("63123");
        adrCRUD.setPays("UK");
        adrCRUD = serviceFacade.getAdresseDao().updateAdresse(adrCRUD);
        Assert.assertNotNull(adrCRUD);
        adrCRUD = serviceFacade.getAdresseDao().findAdresseById(adrCRUD.getIdAdresse());
        log.debug("Updated adrCRUD : " + adrCRUD);
        Assert.assertEquals("63123", adrCRUD.getCodePostal());
        Assert.assertEquals("UK", adrCRUD.getPays());
        int idAdr = adrCRUD.getIdAdresse();
        Assert.assertTrue(serviceFacade.getAdresseDao().deleteAdresse(adrCRUD));
        adrCRUD = serviceFacade.getAdresseDao().findAdresseById(idAdr);
        Assert.assertNull(adrCRUD);
        int idUser = userCRUD.getIdUtilisateur();
        Assert.assertTrue(serviceFacade.getUtilisateurDao().deleteUtilisateur(userCRUD));
        userCRUD = serviceFacade.getUtilisateurDao().findUtilisateurById(idUser);
        Assert.assertNull(userCRUD);
        Assert.assertTrue(serviceFacade.getRoleDao().deleteRole(roleCRUD));
        roleCRUD = serviceFacade.getRoleDao().findRoleById(roleCRUD.getIdRole());
        Assert.assertNull(roleCRUD);
        List<Adresse> adressesFinal = serviceFacade.getAdresseDao().findAllAdresses();
        if (adressesFinal != null) {
            Assert.assertEquals(NB_ADRESSES_LIST, adressesFinal.size());
            log.debug("adressesFinal.size() : " + adressesFinal.size() + " , NB_ADRESSES_LIST: " + NB_ADRESSES_LIST);
        }
        log.debug("Sortie de la methode");
    }
    
    @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        serviceFacade = null;
        adresses = null;
        log.debug("Sortie de la methode");
    }
}
