/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.main;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.Core;
import com.etna.mypenelope.core.IModule;
import com.etna.mypenelope.core.dao.impl.UtilisateurSQLDao;
import com.etna.mypenelope.core.entities.Utilisateur;
import com.etna.mypenelope.core.modules.AbstractModule;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 * Main page controller
 * @author soubri_j/martin_m
 */
public class FXMLMyPenelopeController implements Initializable { 
    private final UtilisateurSQLDao utilisateurDao = new UtilisateurSQLDao(Utilisateur.class, Constants.TABLE_UTILISATEUR);
    protected Utilisateur user;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    Label lblUser;
    
    @FXML
    Label lblPlsLogin;
    
    @FXML
    Label lblLogin;
     
    @FXML
    TextField txtLogin;
    
    @FXML
    Label lblPassword;
     
    @FXML
    PasswordField txtPassword;
     
    @FXML
    Button btConnection;
            
    @FXML
    Button btDeconnection;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        lblPlsLogin.setManaged(true);
        lblUser.setManaged(false);
        btDeconnection.setVisible(false);
        txtLogin.setManaged(true);
    }
    
    /**
     * Method used to add a tab to the elements
     * @param tabToAdd The tab to add
     */
    public void addTab(Tab tabToAdd) {
        if (tabToAdd != null) {
            tabPane.getTabs().add(tabToAdd);
        }
    }
    
    /**
     * Method used to remove a tab from the elements
     * @param name Tab name to remove
     */
    public void removeTab(String name) {
        if (name != null) {
            tabPane.getTabs().removeIf(filterByName(name));
        }
    }
    
    private Predicate<Tab> filterByName(String name) {
        return p -> p.getText().equals(name);
    }
    
    public void connection() {
        if (!txtLogin.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            List<Utilisateur> users = utilisateurDao.findByCriteria("mail", txtLogin.getText());
            if (users != null && users.size() == 1) {
                Utilisateur utilisateur = users.get(0);
                if (utilisateur.getMdp().equals(txtPassword.getText())) {
                    this.user = utilisateur;
                    loadAuthorizedModules();
                    lblUser.setText(utilisateur.toString());
                    lblUser.setManaged(true);
                    lblPlsLogin.setText("Logged user :");
                    btDeconnection.setVisible(true);
                    btConnection.setVisible(false);
                    lblLogin.setVisible(false);
                    txtLogin.setVisible(false);
                    lblPassword.setVisible(false);
                    txtPassword.setVisible(false);
                }
            }
        }
    }
    public void deconnection() {
        lblUser.setText("");
        lblUser.setManaged(false);
        lblPlsLogin.setText("Please login to use the application");
        btDeconnection.setVisible(false);
        btConnection.setVisible(true);
        lblLogin.setVisible(true);
        txtLogin.setVisible(true);
        lblPassword.setVisible(true);
        txtPassword.setVisible(true);
        unloadModules();
    }
    
    private void loadAuthorizedModules() {
        List<IModule> modules = Core.getInstance().getModules();
        
        for (IModule module : modules) {
            AbstractModule am = (AbstractModule)module;
            am.unplug();
            am.authenticate(this.user);
            if (am.hasRight()) {
                am.plug();
            }
        }
    }
    
    private void unloadModules() {
        List<IModule> modules = Core.getInstance().getModules();
        
        for (IModule module : modules) {
            AbstractModule am = (AbstractModule)module;
            am.unplug();
            
        }
    }
}
