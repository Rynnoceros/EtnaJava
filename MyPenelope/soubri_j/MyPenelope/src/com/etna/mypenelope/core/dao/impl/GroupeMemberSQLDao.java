/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.entities.Contact;
import com.etna.mypenelope.core.entities.Groupe;
import com.etna.mypenelope.core.entities.GroupeMember;
import com.etna.mypenelope.core.entities.Utilisateur;
import com.etna.mypenelope.core.interfaces.IPersonne;
import java.util.List;

/**
 * 
 * @author soubri_j/martin_m
 */
public class GroupeMemberSQLDao extends AbstractSQLDao<GroupeMember>{
    private final UtilisateurSQLDao utilisateurDao = new UtilisateurSQLDao(Utilisateur.class, Constants.TABLE_UTILISATEUR);
    private final ContactSQLDao contactDao = new ContactSQLDao(Contact.class, Constants.TABLE_CONTACTS);
    
    public GroupeMemberSQLDao(Class<GroupeMember> t, String tableName) {
        super(t, tableName);
    }
    
    public List<GroupeMember> findAllMembers() {
        List<GroupeMember> toReturn = super.findAll();
        
        for (GroupeMember member : toReturn) {
            member.setMember(getMember(member));
        }
        return toReturn;
    }
    
    public boolean deleteWhereGroup(Groupe toDelete) {
        boolean deleted = true;
        List<GroupeMember> all = findByCriteria("idGroupe", toDelete.getIdGroupe());
        
        for (GroupeMember member : all) {
            deleted &= delete(member);
        }
        return deleted;
    }
    
    private IPersonne getMember(GroupeMember member) {
        IPersonne toReturn = null;
        
        if (member != null) {
            switch (member.getPersonType()) {
                case Utilisateur:
                    toReturn = utilisateurDao.findById(member.getIdPersonne());
                    break;
                case Contact:
                    toReturn = contactDao.findById(member.getIdPersonne());
                    break;
            }
        }
        return toReturn;
    }
}
