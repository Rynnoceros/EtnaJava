/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

/**
 * Project class.
 * @author soubri_j/martin_m
 */
public class Project {
    protected Integer idProject;
    protected String projectName;

    public Integer getIdProject() {
        return idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String toString() {
        return projectName;
    }
}
