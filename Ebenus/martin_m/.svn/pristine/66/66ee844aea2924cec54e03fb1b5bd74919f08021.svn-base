/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.main.MainApp;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

/**
 * FXML Controller class
 *
 * @author elhad
 */
public class LoginController implements Initializable {

    private static final Log logger = LogFactory.getLog(LoginController.class);
    private IServiceFacade service = null;

    @FXML
    private Label label;
    
    @FXML
    private TextField identifiant;

    @FXML
    private PasswordField motPasse;

    //private IServiceFacade serviceFacade = null;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	service = new ServiceFacade();
    }

    public void authenticate(ActionEvent event) {
    	if (service != null) {
    		IUtilisateurDao utilisateur = service.getUtilisateurDao();
    		if (utilisateur != null) {
    			Utilisateur user = utilisateur.authenticate(identifiant.getText(), motPasse.getText());
    			if (user != null) {
    				loginUser(user, event);
    			}
    		}
    	}
    }
    
    private void loginUser(Utilisateur user, ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
    	try {
			Parent parent = loader.load();
			HomeController home = loader.getController();
			home.setConnectedUser(user);
			Scene scene = new Scene(parent);
			Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
			current.setScene(scene);
			current.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
