/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core;

/**
 * View Manager class. It manage all components displayed on the screen
 * @author soubri_j/martin_m
 */
import com.etna.mypenelope.main.FXMLMyPenelopeController;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class ViewManager {
    private FXMLMyPenelopeController mainPageController;
    /**
     * Singleton implementation with Holder
     * @author soubri_j/martin_m
     */
    private static class ViewManagerHolder {
        private static final ViewManager instance = new ViewManager();		
    }
 
    /**
     * Returns a unique instance of ViewManager.
     * @return The unique instance of ViewManager.
     */
    public static ViewManager getInstance() {
        return ViewManagerHolder.instance;
    }
 
    /**
     * Service initialization.
     */
    public void init() {
        
    }
    
    public void setMainPageController(FXMLMyPenelopeController mainPageController) {
        this.mainPageController = mainPageController;
    }

    /**
     * Method used to add graphical elements to the view
     * @param module The module to load
     */
    public void loadGraphicalElement(IModule module) {
        if (module != null) {
            AnchorPane anchor = module.getPanel();
            Tab tabToAdd = new Tab(module.getName());
            tabToAdd.setContent(anchor);
            mainPageController.addTab(tabToAdd);
        }
    }
    
    public void deleteGraphicalElement(IModule module) {
        if (module != null) {
            mainPageController.removeTab(module.getName());
        }
    }
}

