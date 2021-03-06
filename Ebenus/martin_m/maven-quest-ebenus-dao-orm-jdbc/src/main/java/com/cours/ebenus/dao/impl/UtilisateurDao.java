/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.exception.EbenusException;
import com.cours.ebenus.utils.Constants;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class UtilisateurDao extends AbstractDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(UtilisateurDao.class);

    private UtilisateurDao() {
        super(Utilisateur.class);
    }
    
    private static class UtilisateurDaoHolder {
    	private static final UtilisateurDao instance = new UtilisateurDao();
    }
    
    public static UtilisateurDao getInstance() {
    	return UtilisateurDaoHolder.instance;
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
    	return findUtilisateurByCriteria(Constants.SELECT_ALL_UTILISATEUR_ROLE, new String[] { }, new Object[] { });
    }

    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
    	Utilisateur toFind = null;
    	List<Utilisateur> all = findUtilisateurByCriteria(Constants.SELECT_FIND_UTILISATEUR_BY_CRITERIA, new String[] { "idUtilisateur" }, new Object[] { idUtilisateur });
    	if (all != null && all.size() > 0) {
    		toFind = all.get(0);
    	}
    	return toFind;
    }

    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
    	return findUtilisateurByCriteria(Constants.SELECT_FIND_UTILISATEUR_BY_CRITERIA, new String[] { "prenom" }, new Object[] { prenom });
    }

    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
    	return findUtilisateurByCriteria(Constants.SELECT_FIND_UTILISATEUR_BY_CRITERIA, new String[] { "nom" }, new Object[] { nom });
    }

    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
    	return findUtilisateurByCriteria(Constants.SELECT_FIND_UTILISATEUR_BY_CRITERIA, new String[] { "u.identifiant" }, new Object[] { identifiant });
    }

    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {
    	return findUtilisateurByCriteria(Constants.SELECT_FIND_UTILISATEUR_BY_CRITERIA, new String[] { "idRole" }, new Object[] { idRole });
    }

    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {
    	return findUtilisateurByCriteria(Constants.SELECT_FIND_UTILISATEUR_BY_CRITERIA, new String[] { "r.identifiant" }, new Object[] { identifiantRole });
    }
    
    public List<Utilisateur> findUtilisateurByCriteria(String request, String[] criterias, Object[] values) {
    	return super.findByCriteria(request, criterias, values);
    }
    
    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
    	Utilisateur toCreate = null;
    	if (user != null) {
    		List<Utilisateur> toFind = findUtilisateurByIdentifiant(user.getIdentifiant());
    		if (toFind == null || toFind.size() <= 0) {
    			user.setVersion(1);
        		toCreate = super.create(user);
    		} else {
    			throw new EbenusException(String.format(Constants.ERROR_MSG_USER_EXISTING, user.getIdentifiant()), Constants.EXCEPTION_CODE_ELEMENT_ALREADY_EXIST);
    		}
    	}
        return toCreate;
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
    	if (user != null) {
    		return super.update(user);
    	}
        return null;
    }

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
        return super.delete(user);
    }

    /**
     * Méthode qui vérifie les logs email / password d'un utilisateur dans la
     * base de données
     *
     * @param email L'email de l'utilisateur
     * @param password Le password de l'utilisateur
     * @return L'utilisateur qui tente de se logger si trouvé, null sinon
     */
    @Override
    public Utilisateur authenticate(String email, String password) {
    	List<Utilisateur> toFind = findUtilisateurByIdentifiant(email);
    	if (toFind != null && toFind.size() > 0) {
    		if (toFind.get(0).getMotPasse().equals(password)) {
    			return toFind.get(0);
    		}
		}
        return null;
    }
    
    /**
     * Method used to update a user without changing its password
     */
    public Utilisateur updateUserWithoutPassword(Utilisateur user) {
    	if (user != null) {
            user.setDateModification(new Date());
            Utilisateur existing = super.findById(user.getIdUtilisateur());
            if (existing != null) {
                user.setMotPasse(existing.getMotPasse());
            }
            return super.update(user);
    	}
    	return user;
    }
}
