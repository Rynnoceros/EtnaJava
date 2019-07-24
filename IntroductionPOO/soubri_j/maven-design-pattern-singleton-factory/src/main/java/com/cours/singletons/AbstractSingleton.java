/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.singletons;

import com.cours.entities.Personne;
import java.util.List;

/**
 *
 * @author ElHadji
 */
public abstract class AbstractSingleton {

    protected List<Personne> personnes = null;

    public List<Personne> getPersonnes() {
        return personnes;
    }

    protected abstract void extractPersonnesDatas();
}