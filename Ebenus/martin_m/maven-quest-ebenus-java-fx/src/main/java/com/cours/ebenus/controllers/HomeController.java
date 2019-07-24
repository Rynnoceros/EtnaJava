/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.controllers;

import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.ihm.utils.Constants;
import com.cours.ebenus.ihm.utils.ModelConverter;
import com.cours.ebenus.ihm.utils.UtilisateurExportImportUtil;
import com.cours.ebenus.models.UserModel;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * FXML Controller class
 *
 * @author elhad
 */
public class HomeController implements Initializable {

    private static final Log logger = LogFactory.getLog(HomeController.class);
    private IServiceFacade service = null;

    @FXML
    private TableView<UserModel> tableViewUsers;

    @FXML
    private TableColumn<UserModel, Boolean> actionColumn;

    private ObservableList<UserModel> observableListUserModel = null;
    
    @FXML
    private Text loggedUser;
    
    private Utilisateur connectedUser;

    public HomeController() {
        super();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	service = new ServiceFacade();
    	initUserModels();
    	initUsersTableView();
    }

    private void initUserModels() {
    	if (service != null) {
    		IUtilisateurDao dao = service.getUtilisateurDao();
    		List<Utilisateur> utilisateurs = dao.findAllUtilisateurs();
    		if (observableListUserModel == null) {
    			observableListUserModel = FXCollections.observableArrayList();
    		}
    		observableListUserModel.clear();
    		for (Utilisateur user : utilisateurs) {
    			UserModel um = new UserModel();
    			um.setCivilite(user.getCivilite());
    			um.setDateCreation(um.getDateFormat().format(user.getDateCreation()));
    			um.setDateModification(um.getDateFormat().format(user.getDateModification()));
    			um.setDateNaissance(um.getDateFormat().format(user.getDateNaissance()));
    			um.setIdentifiant(user.getIdentifiant());
    			um.setIdUtilisateur(user.getIdUtilisateur());
    			um.setMotPasse(user.getMotPasse());
    			um.setNom(user.getNom());
    			um.setPrenom(user.getPrenom());
    			um.setRole(user.getRole().getIdentifiant());
    			observableListUserModel.add(um);
    		}
    	}
    }

    private void initUsersTableView() {
        actionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<UserModel, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<UserModel, Boolean> features) {
                return new SimpleBooleanProperty(features.getValue() != null);
            }
        });
        Callback<TableColumn<UserModel, Boolean>, TableCell<UserModel, Boolean>> cellFactory
                = //
                new Callback<TableColumn<UserModel, Boolean>, TableCell<UserModel, Boolean>>() {
                    @Override
                    public TableCell call(final TableColumn<UserModel, Boolean> param) {
                        final TableCell<UserModel, Boolean> cell = new TableCell<UserModel, Boolean>() {
                            InputStream editAsStream = getImage(Constants.APP_PATH + "/src/main/resources/edit.png");
                            Image edit = new Image(editAsStream);
                            final Button updatePersonneBtn = new Button();
                            InputStream deleteAsStream = getImage(Constants.APP_PATH + "/src/main/resources/delete.png");
                            Image delete = new Image(deleteAsStream);
                            final Button deletePersonneBtn = new Button();

                            @Override
                            public void updateItem(Boolean item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    updatePersonneBtn.setGraphic(new ImageView(edit));
                                    updatePersonneBtn.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                        	tableViewUsers.getSelectionModel().select(getTableRow().getIndex());
                                        	loadCrud("update", event);
                                        }
                                    });
                                    deletePersonneBtn.setGraphic(new ImageView(delete));
                                    deletePersonneBtn.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                        	tableViewUsers.getSelectionModel().select(getTableRow().getIndex());
                                        	deleteUser();
                                        }
                                    });
                                    HBox pane = new HBox(updatePersonneBtn, deletePersonneBtn);
                                    setGraphic(pane);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        actionColumn.setCellFactory(cellFactory);
        tableViewUsers.setItems(observableListUserModel);
    }
    
    private void loadCrud(String crudType, ActionEvent event) {
    	if (crudType == "update" && connectedUser != null && !connectedUser.getRole().getIdentifiant().equals("Administrateur")) {
    		Alert alert = new Alert(AlertType.ERROR, Constants.MSG_ERROR_CANNOT_UPDATE_USER);
    		alert.show();
    	} else {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/addUpdateUser.fxml"));
        	try {
    			Parent parent = loader.load();
    	    	CrudUserController controller = loader.getController();
    	    	if (controller != null) {
    	    		controller.setCrudType(crudType);
    	    		UserModel selectedUser = tableViewUsers.getSelectionModel().getSelectedItem();
        		    controller.setUserModelToUpdate(selectedUser);	
    	    		controller.setUtilisateur(connectedUser);
    	    		Scene scene = new Scene(parent);
    	    		Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    		current.setScene(scene);
    	    		current.show();
    	    	}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}    		
    	}
    }
    
    private void deleteUser() {
    	Alert alert = null;
    	UserModel selectedUser = tableViewUsers.getSelectionModel().getSelectedItem();
    	if (selectedUser != null) {
    		if (connectedUser != null && connectedUser.getRole().getIdentifiant().equals("Administrateur")) {
        		Utilisateur converted = ModelConverter.getInstance().convertUserModel(selectedUser);
        		if (!connectedUser.equals(converted)) {
        			boolean deleted = service.getUtilisateurDao().deleteUtilisateur(converted);
            		if (deleted) {
            			observableListUserModel.remove(selectedUser);
            		}
        		} else {
        			alert = new Alert(AlertType.ERROR, Constants.MSG_ERROR_CANNOT_DELETE_CONNECTED_USER);
        			alert.show();
        		}
    		} else {
        		alert = new Alert(AlertType.ERROR, Constants.MSG_ERROR_CANNOT_DELETE_USER);
    			alert.show();    			
    		}

    	}
    }

    private InputStream getImage(String path) {
        InputStream imageAsStream = null;
        try {
            imageAsStream = new FileInputStream(new File(path));
        } catch (Exception ex) {
            logger.error("--> Erreur lors de l'execution, Exception: " + ex.getMessage());
        }
        return imageAsStream;
    }
    
    public void setLoggedUser(String identifiant) {
    	loggedUser.setText(identifiant);
    }
    
    public void setConnectedUser(Utilisateur user) {
    	this.connectedUser = user;
    	setLoggedUser(user.getIdentifiant());
    }

    public void logout(ActionEvent event) {
    	setLoggedUser(null);
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
    	try {
			Parent parent = loader.load();
			Scene scene = new Scene(parent);		
			Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
			current.setScene(scene);
			current.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void addUser(ActionEvent event) {
    	loadCrud("add", event);
    }

    public void exportCsv(ActionEvent event) {
    	UtilisateurExportImportUtil uei = new UtilisateurExportImportUtil();
    	uei.CsvExport(event);
    	Alert alert = new Alert(AlertType.INFORMATION, Constants.MSG_OK_EXPORTED);
    	alert.show();
    }

    public void exportXml(ActionEvent event) {
    	UtilisateurExportImportUtil uei = new UtilisateurExportImportUtil();
    	uei.XmlExport(event);
    	Alert alert = new Alert(AlertType.INFORMATION, Constants.MSG_OK_EXPORTED);
    	alert.show();
    }

    public void exportJson(ActionEvent event) {
    	UtilisateurExportImportUtil uei = new UtilisateurExportImportUtil();
    	uei.JsonExport(event);
		Alert alert = new Alert(AlertType.INFORMATION, Constants.MSG_OK_EXPORTED);
		alert.show();
    }

    public void importCsv(ActionEvent event) {
    	UtilisateurExportImportUtil uei = new UtilisateurExportImportUtil();
    	uei.CsvImport(event);
    	initUserModels();
    	initUsersTableView();
    	Alert alert = new Alert(AlertType.INFORMATION, Constants.MSG_OK_CSV_IMPORTED);
    	alert.show();
    }
}
