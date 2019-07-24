package com.cours.ebenus.controllers;

import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.ihm.utils.Constants;
import com.cours.ebenus.ihm.utils.Constants.Civilite;
import com.cours.ebenus.ihm.utils.ModelConverter;
import com.cours.ebenus.models.UserModel;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CrudUserController implements Initializable {

    private static final Log logger = LogFactory.getLog(CrudUserController.class);

    @FXML
    private ComboBox civilite;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TextField identifiant;

    @FXML
    private PasswordField motPasse;

    @FXML
    private DatePicker dateNaissance;

    @FXML
    private ComboBox role;

    private UserModel userModelToUpdate;
    
    private String crudType;

    private Utilisateur utilisateur;
    
    private IServiceFacade serviceFacade = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	serviceFacade = new ServiceFacade();
    	initializeCombobox();
    }
    
    private void initializeCombobox() {
    	civilite.getItems().clear();
    	for (Civilite civ : Civilite.values()) {
    		civilite.getItems().add(civ.toString());
    	}
    	civilite.getSelectionModel().select(0);
    	
    	role.getItems().clear();
    	for (Role r : serviceFacade.getRoleDao().findAllRoles()) {
    		role.getItems().add(r.getIdentifiant());
    	}
    	role.getSelectionModel().select(0);
    }

    public void addUpdateUtilisateur(ActionEvent event) {
    	Alert alert = null;
    	Utilisateur user = null;
    	Utilisateur updated = null;
    	if (controleSaisie()) {
    		userModelToUpdate.setCivilite(civilite.getSelectionModel().getSelectedItem().toString());
    		userModelToUpdate.setRole(role.getSelectionModel().getSelectedItem().toString());
    		userModelToUpdate.setDateModification(userModelToUpdate.getDateFormat().format(new Date()));
    		userModelToUpdate.setIdentifiant(identifiant.getText());
    		userModelToUpdate.setMotPasse(motPasse.getText());
    		userModelToUpdate.setNom(nom.getText());
    		userModelToUpdate.setPrenom(prenom.getText());
    		Date date = Date.from(dateNaissance.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    		userModelToUpdate.setDateNaissance(userModelToUpdate.getDateFormat().format(date));
    		
    		user = ModelConverter.getInstance().convertUserModel(userModelToUpdate);
    		if (crudType.equals("update")) {
    			if (utilisateur != null && utilisateur.getRole().getIdentifiant().equals("Administrateur")) {
    				updated = serviceFacade.getUtilisateurDao().updateUserWithoutPassword(user);	
    			} else {
    				alert.show();
    			}
    		} else {
    			userModelToUpdate.setDateCreation(userModelToUpdate.getDateFormat().format(new Date()));
    			updated = serviceFacade.getUtilisateurDao().createUtilisateur(user);
    		}
    	} else {
    		alert = new Alert(AlertType.ERROR, Constants.MSG_ERROR_MANDATORY_FIELDS);
    		alert.show();
    	}
    	if (alert == null) {
    		FXMLLoader loader = new  FXMLLoader(getClass().getResource("/views/home.fxml"));
    		try {
				Parent parent = loader.load();
				HomeController home = loader.getController();
				if (this.utilisateur.equals(updated)) {
					home.setConnectedUser(updated);
				} else {
					home.setConnectedUser(this.utilisateur);
				}
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
    
    public boolean controleSaisie() {
    	boolean isOK = true;
    	
    	if (prenom.getText().isEmpty() || nom.getText().isEmpty() || 
    		identifiant.getText().isEmpty() || motPasse.getText().isEmpty()) {
    		
    		isOK = false;
    	}
    	
    	try {
    		Date.from(dateNaissance.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    	}
    	catch (Exception ex) {
    		isOK = false;
    	}
    	
    	return isOK;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
    	this.utilisateur = utilisateur;
    }
     
    public void setUserModelToUpdate(UserModel userModelToUpdate) {
    	if (crudType.equals("update")) {
            this.userModelToUpdate = userModelToUpdate;
            civilite.getSelectionModel().select(userModelToUpdate.getCivilite());
            role.getSelectionModel().select(userModelToUpdate.getRole());
            nom.setText(userModelToUpdate.getNom());
            prenom.setText(userModelToUpdate.getPrenom());
            identifiant.setText(userModelToUpdate.getIdentifiant());
            motPasse.setText(userModelToUpdate.getMotPasse());
            try {
    			dateNaissance.setValue(userModelToUpdate.getDateFormat().parse(userModelToUpdate.getDateNaissance()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}    		
    	} else {
    		this.userModelToUpdate = new UserModel();
    	}
    }
    
    public void setCrudType(String crudType) {
    	this.crudType = crudType;
    }
}
