/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.projects;

import com.etna.mypenelope.core.modules.AbstractModule;

/**
 * Project Management module.
 * @author soubri_j/martin_m
 */
public class ProjectManagement extends AbstractModule {

    @Override
    public String getName() {
        return "Project Management";
    }

    @Override
    public String getFXMLFileName() {
        return "com/etna/mypenelope/modules/projects/FXMLProjectManagement.fxml";
    }

    @Override
    public boolean hasRight() {
        return (user.getAdmin() == 1);
    }
    
    
}
