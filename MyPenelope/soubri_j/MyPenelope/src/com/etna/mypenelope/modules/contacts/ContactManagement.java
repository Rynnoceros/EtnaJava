/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.contacts;

import com.etna.mypenelope.core.modules.AbstractModule;

/**
 * Contact Management module class.
 * @author soubri_j/martin_m
 */
public class ContactManagement extends AbstractModule {
    
    @Override
    public String getName() {
        return "Contact Management";
    }

    @Override
    public String getFXMLFileName() {
        return "com/etna/mypenelope/modules/contacts/FXMLContactManagement.fxml";
    }

    @Override
    public boolean hasRight() {
        return true;
    }
}
