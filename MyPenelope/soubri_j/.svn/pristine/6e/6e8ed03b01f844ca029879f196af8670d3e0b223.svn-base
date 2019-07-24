/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.entities.Message;
import com.etna.mypenelope.core.entities.MessageDestinataire;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author soubri_j/martin_m
 */
public class MessageSQLDao extends AbstractSQLDao<Message> {
    private MessageDestinataireSQLDao destinataires = new MessageDestinataireSQLDao(MessageDestinataire.class, "messages_destinataires");
    
    public MessageSQLDao(Class<Message> t, String tableName) {
        super(t, tableName);
    }
    
    public List<Message> findAllMessage() {
        List<Message> toReturn = new ArrayList<Message>();
        
        toReturn = super.findAll();
        return toReturn;
    }
    
    public Message findByIdMessage(Integer idMessage) {
        Message toReturn = null;
        
        toReturn = super.findById(idMessage);
        return toReturn;
    }
    
    public List<Message> findByCriteriaMessage(String criteria, Object value) {
        List<Message> toReturn = null;
        
        toReturn = super.findByCriteria(criteria, value);
        return toReturn;
    }
    
    public List<Message> findReceivedMessages(Integer idUtilisateur) {
        List<Message> toReturn = findAllMessage();
        List<MessageDestinataire> dest = destinataires.findAll();
        
        dest = dest.stream().filter(destinataires.filterByIdUtilisateur(idUtilisateur))
                            .collect(Collectors.toList());
        
        toReturn = toReturn.stream().filter(filterByIdMessage(dest))
                                    .collect(Collectors.toList());
        return toReturn;
    }
    
    public List<Message> findSentMessages(Integer idExpediteur) {
        List<Message> toReturn = findAllMessage();
        
        toReturn = toReturn.stream().filter(filterByIdExpediteur(idExpediteur))
                                    .collect(Collectors.toList());
        return toReturn;
    }
    
    public boolean deleteReceivedMessage(Integer idMessage, Integer idDestinataire) {
        boolean deleted = false;
        List<MessageDestinataire> all = destinataires.findByCriteria(Constants.ID + this.myUtil.getClassName(), idMessage);
        
        Optional<MessageDestinataire> toDelete = all.stream().filter(destinataires.filterByIdMessageAndIdDestinataire(idMessage, idDestinataire))
                                                    .findFirst();
        if (toDelete.isPresent()) {
            deleted = destinataires.delete(toDelete.get());
        }
        return deleted;
    }
    
    public boolean deleteSentMessage(Message message) {
        boolean deleted = false;
        
        deleted = delete(message);
        List<MessageDestinataire> allReceivers = destinataires.findByCriteria("idMessage", message.getIdMessage());
        for (MessageDestinataire md : allReceivers)
        {
            deleted &= destinataires.delete(md);
        }
        return deleted;
    }
    
    public Predicate<Message> filterByIdExpediteur(Integer idExpediteur) {
        return p -> p.getExpediteur() == idExpediteur;
    }
    
    public Predicate<Message> filterByIdMessage(List<MessageDestinataire> mds) {
        return p -> containsIdMessage(p, mds);
    }

    private boolean containsIdMessage(Message message, List<MessageDestinataire> mds) {
        boolean toReturn = false;
        for (MessageDestinataire md : mds) {
            if (md.getIdMessage() == message.getIdMessage()) {
                return true;
            }
        }
        return toReturn;
    }
}
