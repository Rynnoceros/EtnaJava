/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Message class
 * @author soubri_j/martin_m
 */
public class Message {
    protected Integer idMessage;
    protected Integer idExpediteur;
    protected String title;
    protected String content;
    
    public Message() {
    
    }
    
    public Message(Integer idExpediteur, String title, String content) {
        this.idMessage = 0;
        this.idExpediteur = idExpediteur;
        this.title = title;
        this.content = content;
    }
    
    public enum Status {
        NonLu,
        Lu
    }
    
    public void setExpediteur(Integer idExpediteur) {
        this.idExpediteur = idExpediteur;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getExpediteur() {
        return idExpediteur;
    }
    
    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
    
    public Integer getIdMessage() {
        return idMessage;
    }
    
    public String toString() {
        return title;
    }
}
