/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.list.impl;

import com.cours.ebenus.dao.DataSource;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.utils.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualListUtilisateurDao extends AbstractListDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(ManualListUtilisateurDao.class);
    private List<Utilisateur> utilisateursListDataSource = null;

    public ManualListUtilisateurDao() {
        super(Utilisateur.class, DataSource.getInstance().getUtilisateursListDataSource());
    }
    /**
     * Méthode qui retourne la liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource)
     *
     * @return La liste de tous les utilisateurs de la database
     */
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return super.findAll();
    }

    /**
     * Méthode qui retourne l'utilisateur d'id passé en paramètre de la database
     * (ici utilisateursListDataSource)
     *
     * @param idUtilisateur L'id de l'user à récupérer
     * @return L'utilisateur d'id passé en paramètre, null si non trouvé
     */
    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
        return super.findById(idUtilisateur);
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le prénom est égal au paramètre
     * passé
     *
     * @param prenom Le prénom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le prénom est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
        return super.findByCriteria("prenom", prenom);
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le nom est égal au paramètre passé
     *
     * @param nom Le nom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le nom est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
        return super.findByCriteria("nom", nom);
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont l'identifiant est égal au paramètre
     * passé
     *
     * @param identifiant Le nom des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont l'identifiant est égal au
     * paramètre passé
     */
    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
        return super.findByCriteria("identifiant", identifiant);
    }

    /**
     * Méthode qui permet d'ajouter un utilisateur dans la database (ici
     * utilisateursListDataSource)
     *
     * @param user L'utilisateur à ajouter
     * @return L'utilisateur ajouté ou null si échec
     */
    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
    	List<Utilisateur> users = null;
    	Utilisateur toCreate = user;
    	
    	if (user != null) {    		
    		user.setDateCreation(new Date(System.currentTimeMillis()));
    		user.setDateModification(new Date(System.currentTimeMillis()));
    		users = findUtilisateurByIdentifiant(user.getIdentifiant());
    		if (users == null || users.size() <= 0) {
    			toCreate = super.create(user);
    		} else {
    			throw new com.cours.ebenus.dao.exception.CustomException(String.format(Constants.ERROR_MSG_USER_EXISTING, user.getIdentifiant()), Constants.EXCEPTION_CODE_ELEMENT_ALREADY_EXIST);
    		}
    	}
        return toCreate;
    }

    /**
     * Méthode qui permet d'update un utilisateur existant dans la database (ici
     * utilisateursListDataSource)
     *
     * @param user L'utilisateur à modifier
     * @return L'utilisateur modifié ou null si ce dernier n'existe pas dans la
     * database
     */
    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
    	if (user != null) {    		
    		user.setDateModification(new Date(System.currentTimeMillis()));
    	}
        return super.update(user);
    }

    /**
     * Méthode qui permet de supprimer un utilisateur existant dans la database
     * (ici utilisateursListDataSource)
     *
     * @param user L'utilisateur à supprimer
     * @return True si suppression effectuée, false sinon
     */
    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
        return super.delete(user);
    }

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le rôle a comme id celui passé en
     * paramètre
     *
     * @param idRole L'id du rôle des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le rôle a comme id celui
     * passé en paramètre
     */
    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {
    	List<Utilisateur> toReturn = new ArrayList<Utilisateur>();
    	utilisateursListDataSource = super.findAll();
    	if (utilisateursListDataSource != null) { 
    		for (Utilisateur user : utilisateursListDataSource) {
    			if (user.getRole() != null && user.getRole().getIdRole() == idRole) {
    				toReturn.add(user);
    			}
    		}
    	}
        return toReturn;
    }
    
    /**
	 * Method used to filter a user on role id
	 * @param criteria The criteria to filter
	 * @param valueCriteria Criteria's value
	 * @return true if criteria is equal to searched value, false otherwise
	 */
	public Predicate<Utilisateur> filterByIdRole(int idRole) {
		return p -> {
			Role toFind = null;
			boolean found = false;
			
			toFind = p.getRole();
			if (toFind != null) {
				found = (toFind.getIdRole() == idRole);
			}
			return found;
		};
	}

    /**
     * Méthode qui retourne une liste de tous les utilisateurs de la database
     * (ici utilisateursListDataSource) dont le rôle a comme identifiant celui
     * passé en paramètre
     *
     * @param identifiantRole L'identifiant du rôle des utilisateurs à récupérer
     * @return Une liste de tous les utilisateurs dont le rôle a comme
     * identifiant celui passé en paramètre
     */
    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {
        List<Utilisateur> toReturn = new ArrayList<Utilisateur>();
        utilisateursListDataSource = findAll();
        if (utilisateursListDataSource != null) {  
        	for (Utilisateur user : utilisateursListDataSource) {
        		if (user.getRole() != null && user.getRole().getIdentifiant().equals(identifiantRole)) {
        			toReturn.add(user);
        		}
        	}
        }
        return toReturn;
    }
    
    /**
	 * Method used to filter a user on role identifiant
	 * @param criteria The criteria to filter
	 * @param valueCriteria Criteria's value
	 * @return true if criteria is equal to searched value, false otherwise
	 */
	public Predicate<Utilisateur> filterByIdentifiantRole(String identifiantRole) {
		return p -> {
			Role toFind = null;
			boolean found = false;
			
			toFind = p.getRole();
			if (toFind != null) {
				found = (toFind.getIdentifiant().equals(identifiantRole));
			}
			return found;
		};
	}
}
