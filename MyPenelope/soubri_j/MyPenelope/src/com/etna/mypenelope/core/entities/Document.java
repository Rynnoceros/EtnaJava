/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IDocument;
import com.etna.mypenelope.core.interfaces.IPersonne.PersonType;

/**
 * Document class.
 * @author soubri_j/martin_m
 */
public class Document implements IDocument {
    protected Integer idDocument;
    protected Integer idDocumentOwner;
    protected String personType;
    protected String name;
    protected byte[] content;
    
    @Override
    public byte[] getContent() {
        return content;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public Integer getIdDocumentOwner() {
        return idDocumentOwner;
    }

    public PersonType getPersonType() {
        return PersonType.valueOf(personType);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    
    
    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setIdDocumentOwner(Integer idDocumentOwner) {
        this.idDocumentOwner = idDocumentOwner;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType.toString();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
