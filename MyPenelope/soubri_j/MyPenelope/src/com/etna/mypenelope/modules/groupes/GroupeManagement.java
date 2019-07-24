package com.etna.mypenelope.modules.groupes;

import com.etna.mypenelope.core.modules.AbstractModule;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Groupe management module class.
 * @author soubri_j/martin_m
 */
public class GroupeManagement extends AbstractModule {

    @Override
    public String getName() {
        return "Groupe Management";
    }

    @Override
    public String getFXMLFileName() {
        return "com/etna/mypenelope/modules/groupes/FXMLGroupeManagement.fxml";
    }

    @Override
    public boolean hasRight() {
        return (user.getAdmin() == 1);
    }
    
}
