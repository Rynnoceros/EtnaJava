/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.modules;

import com.etna.mypenelope.core.IModule;
import com.etna.mypenelope.core.LogManager;
import com.etna.mypenelope.core.ViewManager;
import com.etna.mypenelope.core.entities.Utilisateur;
import com.etna.mypenelope.core.interfaces.IRight;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author soubri_j/martin_m
 */
public abstract class AbstractModule implements IModule, IRight {
    protected AnchorPane panel;
    protected Utilisateur user;
    
    public AbstractModule() {
        try {
            FXMLLoader loader = new FXMLLoader();
            panel = loader.load(getClass().getClassLoader().getResourceAsStream(getFXMLFileName()));
        } catch (IOException ex) {
            LogManager.getInstance().log("Error loading module " + getClass().getName());
        }
    }
    
    @Override
    public void plug() {
        LogManager.getInstance().log("Loading " + getName() + " module.");
        ViewManager.getInstance().loadGraphicalElement(this);
    }

    @Override
    public void unplug() {
        LogManager.getInstance().log("Unloading " + getName() + " module");
        ViewManager.getInstance().deleteGraphicalElement(this);
    }

    @Override
    public AnchorPane getPanel() {
        return this.panel;
    }
    
    @Override
    public abstract String getName();
    
    @Override
    public abstract String getFXMLFileName();
    
    @Override
    public void authenticate(Utilisateur user) {
        if (user != null) {
            this.user = user;
        }
    }
    
    @Override
    public abstract boolean hasRight();
}
