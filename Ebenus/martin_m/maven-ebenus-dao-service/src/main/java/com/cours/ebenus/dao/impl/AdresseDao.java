/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.IAdresseDao;
import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.utils.Constants;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Adresse DAO
 * @author soubri_j/martin_m
 */
public class AdresseDao extends AbstractDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(AdresseDao.class);
    
    /**
     * Default constructor
     */
    private AdresseDao() {
        super(Adresse.class);
    }
    
    /**
     * Holder class.
     */
    private static class AdresseDaoHolder {
        private static final AdresseDao instance = new AdresseDao();
    }
    
    /**
     * Method used to get a unique instance of AdresseDao
     * @return A unique instance of AdresseDao
     */
    public static AdresseDao getInstance() {
        return AdresseDaoHolder.instance;
    }

    /**
     * Find all adresses.
     * @return List of all addresses.
     */
    @Override
    public List<Adresse> findAllAdresses() {
        return super.findByCriteria(Constants.SELECT_ALL_ADRESSE, new String[] {}, new String[] {});
    }

    /**
     * Find an address by its id
     * @param idAdresse Id of the address to find
     * @return The address if found, null otherwise
     */
    @Override
    public Adresse findAdresseById(int idAdresse) {
        List<Adresse> adresses = super.findByCriteria(Constants.SELECT_ADRESSE_BY_PARAMETER, new String[] {"idAdresse"}, new String[] {String.valueOf(idAdresse)});
        if (adresses != null && adresses.size() > 0) {
            return adresses.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find address by rue
     * @param rue The rue to find
     * @return List of addresses corresponding
     */
    @Override
    public List<Adresse> findAdresseByRue(String rue) {
        return super.findByCriteria(Constants.SELECT_ADRESSE_BY_PARAMETER, new String[] {"rue"}, new String[] { rue });
    }
    
    /**
     * Find address by idUtilisateur
     * @param idUtilisateur Id utilisateur to find
     * @return List of addresses corresponding
     */
    @Override
    public List<Adresse> findAdresseByIdUtilisateur(int idUtilisateur) {
        return super.findByCriteria(Constants.SELECT_ADRESSE_BY_PARAMETER, new String[] {"a.idUtilisateur"}, new String[] { String.valueOf(idUtilisateur) });
    }
    
    /**
     * Find billing address by idUtilisateur
     * @param idUtilisateur Id utilisateur to find
     * @return Billing addresse
     */
    @Override
    public Adresse findAdresseFacturationByIdUtilisateur(int idUtilisateur) {
        List<Adresse> adresses = null;
        adresses = findAdresseByIdUtilisateur(idUtilisateur);
        
        if (adresses != null) {
            Optional<Adresse> adrFacturation = adresses.stream().filter(filterByTypeFacturation()).findFirst();
            if (adrFacturation.isPresent()) {
                return adrFacturation.get();
            }
        }
         
        return null;
    }
    
    private Predicate<Adresse> filterByTypeFacturation() {
        return adr -> adr.getTypeAdresse().equals(Adresse.TypeAdresse.Facturation.toString());
    }

    /**
     * Create an address in database.
     * @param adresse The address to create
     * @return The created address if ok, null otherwise
     */
    @Override
    public Adresse createAdresse(Adresse adresse) {
        return super.create(adresse);
    }

    /**
     * Update an address in database.
     * @param adresse The address to update
     * @return The updated address if ok, null otherwise
     */
    @Override
    public Adresse updateAdresse(Adresse adresse) {
        return super.update(adresse);
    }

    /**
     * Delete an address in database.
     * @param adresse The address to delete
     * @return true if address was deleted, false otherwise
     */
    @Override
    public boolean deleteAdresse(Adresse adresse) {
        return super.delete(adresse);
    }
    
}