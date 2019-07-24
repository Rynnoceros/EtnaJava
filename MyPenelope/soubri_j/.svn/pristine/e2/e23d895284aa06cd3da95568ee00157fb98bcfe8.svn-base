/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.usermanagement;

import com.etna.mypenelope.core.LogManager;
import com.etna.mypenelope.core.entities.Utilisateur;
import com.etna.mypenelope.core.dao.impl.UtilisateurSQLDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.DepthTest;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 * User management controller class
 * @author soubri_j/martin_m
 */
public class FXMLUserManagementController implements Initializable {
    Tab tabUser = null;
    UtilisateurSQLDao utilisateurDao = new UtilisateurSQLDao(Utilisateur.class, "utilisateur");
    
    
    @FXML
    ListView lvUser;
    
    @FXML
    Button btnRemove;
    
    @FXML
    Button btnUpdate;
    
    @FXML
    TextField txtPrenom;
    
    @FXML
    TextField txtNom;
    
    @FXML
    TextField txtMail;
    
    @FXML
    TextField txtMdp;
    
    @FXML
    CheckBox checkAdmin;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvUser.getSelectionModel().selectedItemProperty().addListener(onContactSelectedChanged());
        btnRemove.setDisable(Boolean.TRUE);
        loadUsers();
    }
    
     
    private void loadUsers() {
        List<Utilisateur> allUsers = null;
        
        lvUser.getItems().clear();
        allUsers = utilisateurDao.findAll();
        if (allUsers != null && allUsers.size() > 0) {
            lvUser.getItems().setAll(allUsers);
        }
    }
    
    public void addUser() {
        txtPrenom.setText("");
        txtNom.setText("");
        txtMdp.setText("");
        txtMail.setText("");
        checkAdmin.setSelected(false);
        lvUser.getSelectionModel().clearSelection();
    }
    
    public void saveUser() {
        if (lvUser.getSelectionModel().getSelectedItem() != null) {
            updateUser();
        } else {
            createUser();
        }
    }
    
    public void removeUser() {
        Utilisateur toDelete = (Utilisateur)lvUser.getSelectionModel().getSelectedItem();
        if (toDelete != null) {
            utilisateurDao.delete(toDelete);
            lvUser.getItems().remove(toDelete);
        }
    }

    protected ChangeListener<Utilisateur> onContactSelectedChanged() {
        return (ObservableValue<? extends Utilisateur> observable, Utilisateur oldValue, Utilisateur newValue) -> {
            if (newValue != null) {
                loadUsers(newValue);
                btnRemove.setDisable(Boolean.FALSE);                
            } else {
                btnRemove.setDisable(Boolean.TRUE);
            }
        };
    }

    private void loadUsers(Utilisateur newValue) {
        if (newValue != null) {
            txtPrenom.setText(newValue.getPrenom());
            txtNom.setText(newValue.getNom());
            txtMdp.setText(newValue.getMdp());
            txtMail.setText(newValue.getMail());
            if (newValue.getAdmin() == 1)
                checkAdmin.setSelected(true);
            else 
                checkAdmin.setSelected(false);
        }
    }
    
    private void createUser() {
        Utilisateur toCreate = new Utilisateur();
        fillUser(toCreate);
        toCreate = utilisateurDao.create(toCreate);
        if (toCreate != null) {
            lvUser.getItems().add(toCreate);
        }
    }
    
    private void updateUser() {
        Utilisateur toUpdate = (Utilisateur)lvUser.getSelectionModel().getSelectedItem();
        if (toUpdate != null) {
            fillUser(toUpdate);
            utilisateurDao.update(toUpdate);
            lvUser.getItems().set(lvUser.getSelectionModel().getSelectedIndex(), toUpdate);
        }
    }
    
    private void fillUser(Utilisateur toFill) {
        if (toFill != null) {
            toFill.setPrenom(txtPrenom.getText());
            toFill.setNom(txtNom.getText());
            toFill.setMdp(txtMdp.getText());
            toFill.setMail(txtMail.getText());
            if (checkAdmin.isSelected())
                toFill.setAdmin(1);
            else 
                toFill.setAdmin(0);
        }
    }
}