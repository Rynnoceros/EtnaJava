/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.interfaces;

import com.etna.mypenelope.core.entities.Utilisateur;

/**
 *
 * @author soubri_j/martin_m
 */
public interface IRight {
    public void authenticate(Utilisateur user);
    
    public boolean hasRight();
}
