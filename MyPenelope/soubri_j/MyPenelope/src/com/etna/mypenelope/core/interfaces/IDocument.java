/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.interfaces;

/**
 * Document interface.
 * @author soubri_j/martin_m
 */
public interface IDocument {
    String getName();
    byte[] getContent();
    
    public enum DocumentType {
        Word,
        PDF,
        Excel,
        Image
    }
}
