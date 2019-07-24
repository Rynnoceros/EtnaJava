/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

import com.cours.ebenus.dao.entities.Utilisateur;

/**
 *
 * @author soubri_j/martin_m
 */
public class UserConnectedManager {
    
    private static Utilisateur loggedUser = null;
    
    private UserConnectedManager() {
    }
    
    private static class UserConnectedManagerHolder {
        private static final UserConnectedManager instance = new UserConnectedManager();
    }
    
    public static UserConnectedManager getInstance() {
        return UserConnectedManagerHolder.instance;
    }
    
    public void loginUser(Utilisateur user) {
        loggedUser = user;
    }
    
    public void logoutUser() {
        loggedUser = null;
    }
    
    public Utilisateur getLoggedUser() {
        return loggedUser;
    }
    
    public boolean isUserConnected() {
        return loggedUser != null ? true : false;
    }
    
    /**
     * Methode utilisée pour savoir si l'utilisateur connecté est administrateur ou non.
     * @return true si l'utilisateur est administrateur, false otherwise
     */
    public boolean isAdministrateur() {
        boolean retour = false;
        
        if (loggedUser != null && loggedUser.getRole().getIdentifiant().equals("Administrateur")) {
            retour = true;
        }
        
        return retour;
    }
}
