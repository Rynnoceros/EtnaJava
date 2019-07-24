/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.messages;

import com.etna.mypenelope.core.modules.AbstractModule;

/**
 * Message Management module
 * @author soubri_j/martin_m
 */
public class MessageManagement extends AbstractModule {
    public MessageManagement() {
        super();
    }
    
    @Override
    public String getName() {
        return "Message Management";
    }
    
    public String getFXMLFileName() {
        return "com/etna/mypenelope/modules/messages/FXMLMessageManagement.fxml";
    }

    @Override
    public boolean hasRight() {
        return true;
    }
}
