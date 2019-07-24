/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.entities.MessageDestinataire;
import java.util.function.Predicate;

/**
 *
 * @author soubri_j/martin_m
 */
public class MessageDestinataireSQLDao extends AbstractSQLDao<MessageDestinataire> {
    
    public MessageDestinataireSQLDao(Class<MessageDestinataire> t, String tableName) {
        super(t, tableName);
    }
    
    public Predicate<MessageDestinataire> filterByIdMessageAndIdDestinataire(Integer idMessage, Integer idDestinataire) {
        return p -> (p.getIdMessage() == idMessage && p.getIdUtilisateur() == idDestinataire);
    }
    
    public Predicate<MessageDestinataire> filterByIdUtilisateur(Integer idUtilisateur) {
        return p -> p.getIdUtilisateur() == idUtilisateur;
    }
}
