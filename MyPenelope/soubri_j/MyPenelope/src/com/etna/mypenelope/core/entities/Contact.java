/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IPersonne;

/**
 * Contact class.
 * @author soubri_j/martin_m
 */
public class Contact implements IPersonne {
    protected Integer idContact;
    protected String prenom;
    protected String nom;
    protected String mail;

    public Integer getIdContact() {
        return idContact;
    }

    @Override
    public String getPrenom() {
        return this.prenom;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getMail() {
        return this.mail;
    }
    
    @Override
    public Integer getId() {
        return getIdContact();
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    } 
    
    public String toString() {
        return this.prenom + " " + this.nom;
    }
}
