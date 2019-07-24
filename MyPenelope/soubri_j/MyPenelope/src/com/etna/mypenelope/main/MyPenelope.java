/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.main;

import com.etna.mypenelope.core.Core;
import com.etna.mypenelope.core.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author soubri_j/martin_m
 */
public class MyPenelope extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("FXMLMyPenelope.fxml").openStream());
        ViewManager.getInstance().setMainPageController((FXMLMyPenelopeController)fxmlLoader.getController());
        Core.getInstance().setApplicationFolder(System.getProperty("user.dir"));
        Core.getInstance().setApplicationName("Application modulaire 1.0. ");
        Core.getInstance().launch();
        
        Scene scene = new Scene(root);
        
        stage.setTitle(Core.getInstance().getApplicationName());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
