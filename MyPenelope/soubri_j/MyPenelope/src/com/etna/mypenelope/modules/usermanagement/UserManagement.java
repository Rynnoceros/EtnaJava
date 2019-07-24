/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.usermanagement;

import com.etna.mypenelope.core.modules.AbstractModule;
import javafx.scene.layout.AnchorPane;

/**
 * @author soubri_j/martin_m
 */
public class UserManagement extends AbstractModule {
    
    public UserManagement() {
        super();
    }

    public String getName() {
        return "User Management";
    }

    public String getFXMLFileName() {
        return "com/etna/mypenelope/modules/usermanagement/FXMLUserManagement.fxml";
    }

    @Override
    public boolean hasRight() {
        return (user.getAdmin() == 1);
    }
}
