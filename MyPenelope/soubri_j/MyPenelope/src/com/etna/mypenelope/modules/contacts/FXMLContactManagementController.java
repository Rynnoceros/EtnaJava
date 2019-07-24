/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.contacts;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.dao.impl.ContactSQLDao;
import com.etna.mypenelope.core.entities.Contact;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author soubri_j/martin_m
 */
public class FXMLContactManagementController implements Initializable {
    private final ContactSQLDao contactDao = new ContactSQLDao(Contact.class, Constants.TABLE_CONTACTS);
    
    @FXML
    ListView lvContacts;
    
    @FXML
    Button btnRemove;
    
    @FXML
    TextField txtPrenom;
    
    @FXML
    TextField txtNom;
    
    @FXML
    TextField txtMail;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvContacts.getSelectionModel().selectedItemProperty().addListener(onContactSelectedChanged());
        btnRemove.setDisable(Boolean.TRUE);
        loadContacts();
    }    
    
    
    private void loadContacts() {
        List<Contact> allContacts = null;
        
        lvContacts.getItems().clear();
        allContacts = contactDao.findAll();
        if (allContacts != null && allContacts.size() > 0) {
            lvContacts.getItems().setAll(allContacts);
        }
    }
    
    public void addContact() {
        txtPrenom.setText("");
        txtNom.setText("");
        txtMail.setText("");
        lvContacts.getSelectionModel().clearSelection();
    }
    
    public void saveContact() {
        if (lvContacts.getSelectionModel().getSelectedItem() != null) {
            updateContact();
        } else {
            createContact();
        }
    }
    
    public void removeContact() {
        Contact toDelete = (Contact)lvContacts.getSelectionModel().getSelectedItem();
        if (toDelete != null) {
            contactDao.delete(toDelete);
            lvContacts.getItems().remove(toDelete);
        }
    }

    protected ChangeListener<Contact> onContactSelectedChanged() {
        return (ObservableValue<? extends Contact> observable, Contact oldValue, Contact newValue) -> {
            if (newValue != null) {
                loadContact(newValue);
                btnRemove.setDisable(Boolean.FALSE);                
            } else {
                btnRemove.setDisable(Boolean.TRUE);
            }
        };
    }

    private void loadContact(Contact newValue) {
        if (newValue != null) {
            txtPrenom.setText(newValue.getPrenom());
            txtNom.setText(newValue.getNom());
            txtMail.setText(newValue.getMail());
        }
    }
    
    private void createContact() {
        Contact toCreate = new Contact();
        fillContact(toCreate);
        toCreate = contactDao.create(toCreate);
        if (toCreate != null) {
            lvContacts.getItems().add(toCreate);
        }
    }
    
    private void updateContact() {
        Contact toUpdate = (Contact)lvContacts.getSelectionModel().getSelectedItem();
        if (toUpdate != null) {
            fillContact(toUpdate);
            contactDao.update(toUpdate);
            lvContacts.getItems().set(lvContacts.getSelectionModel().getSelectedIndex(), toUpdate);
        }
    }
    
    private void fillContact(Contact toFill) {
        if (toFill != null) {
            toFill.setPrenom(txtPrenom.getText());
            toFill.setNom(txtNom.getText());
            toFill.setMail(txtMail.getText());
        }
    }
}
