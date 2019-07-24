/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IPersonne;
import com.etna.mypenelope.core.interfaces.IPersonne.PersonType;

/**
 * Groupe membre class. Used to associate a group to different persons.
 * @author soubri_j/martin_m
 */
public class GroupeMember extends AbstractGroupeMember {
    protected Integer idGroupeMember;
    protected Integer idGroupe;
    protected Integer idPersonne;
    protected String personType;

    public Integer getIdGroupeMember() {
        return idGroupeMember;
    }

    public Integer getIdGroupe() {
        return idGroupe;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public PersonType getPersonType() {
        return PersonType.valueOf(personType);
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
    
    public String toString() {
        return this.getMember().getPrenom() + " " + this.getMember().getNom();
    }
}
