/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IDocument;

/**
 *
 * @author soubri_j/martin_m
 */
public class AbstractProjectMember {
    protected IDocument document;

    public IDocument getDocument() {
        return document;
    }

    public void setDocument(IDocument document) {
        this.document = document;
    }
    
    
}
