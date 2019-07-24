/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.LogManager;
import com.etna.mypenelope.core.entities.Document;
import com.etna.mypenelope.core.entities.ProjectDocument;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

/**
 * ProjectDocumentSQLDao class.
 * @author soubri_j/martin_m
 */
public class ProjectDocumentSQLDao extends AbstractSQLDao<ProjectDocument>{
    private final DocumentSQLDao documentDao = new DocumentSQLDao(Document.class, Constants.TABLE_DOCUMENTS); 
    
    public ProjectDocumentSQLDao(Class<ProjectDocument> t, String tableName) {
        super(t, tableName);
    }
    
    public List<ProjectDocument> findAllDocuments() {
        List<ProjectDocument> allDocuments = super.findAll();
        
        for (ProjectDocument tmp : allDocuments) {
            Document toFind = documentDao.findById(tmp.getIdDocument());
            if (toFind != null) {
                tmp.setDocument(toFind);
            }
        }
        return allDocuments;
    }
    
    public Predicate<ProjectDocument> filterByIdProject(Integer idProject) {
        return p -> p.getIdProject() == idProject;
    }
    
    public boolean deleteWhereDocument(Document document) {
        boolean toReturn = false;
        
        if (document != null) {
            try {
                String strRequete = constructDeleteQuery(Document.class.getSimpleName());
                PreparedStatement ps = this.connexion.ObtenirConnexion().prepareStatement(strRequete);
                this.myUtil.fillPreparedStatement(ps, Constants.ID + document.getClass().getSimpleName(), document.getIdDocument(), 1);
                if (ps != null) {
                    toReturn = ps.execute();
                }
            } catch (SQLException ex) {
                LogManager.getInstance().log(ex.getLocalizedMessage());
            }
        }
        
        return toReturn;
    }
}
