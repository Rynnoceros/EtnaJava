/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IGroupe;

/**
 *
 * @author soubri_j/martin_m
 */
public class AbstractProjectGroupe {
    protected IGroupe groupe;

    public IGroupe getGroupe() {
        return groupe;
    }
    
    public void setGroupe(IGroupe groupe) {
        this.groupe = groupe;
    }
}
