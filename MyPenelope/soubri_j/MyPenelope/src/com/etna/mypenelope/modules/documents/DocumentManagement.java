/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.documents;

import com.etna.mypenelope.core.modules.AbstractModule;

/**
 * Document management class.
 * @author soubri_j/martin_m
 */
public class DocumentManagement extends AbstractModule {
    
    @Override
    public String getName() {
        return "Document Management";
    }

    @Override
    public String getFXMLFileName() {
        return "com/etna/mypenelope/modules/documents/FXMLDocumentManagement.fxml";
    }

    @Override
    public boolean hasRight() {
        return true;
    }
}
