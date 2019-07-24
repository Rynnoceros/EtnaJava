/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

/**
 * Project Document class.
 * @author soubri_j/martin_m
 */
public class ProjectDocument extends AbstractProjectMember {
    protected Integer idProjectDocument;
    protected Integer idProject;
    protected Integer idDocument;

    public Integer getIdProject() {
        return idProject;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }
    
    @Override
    public String toString() {
        return getDocument().getName();
    }
}
