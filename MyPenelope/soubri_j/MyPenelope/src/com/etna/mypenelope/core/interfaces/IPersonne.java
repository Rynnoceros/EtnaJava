/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.interfaces;

/**
 * Peronne interface
 * @author soubri_j/martin_m
 */
public interface IPersonne {
    Integer getId();
    String getPrenom();
    String getNom();
    String getMail();
    
    public enum PersonType {
        Utilisateur,
        Contact,
        Groupe
    }
}
