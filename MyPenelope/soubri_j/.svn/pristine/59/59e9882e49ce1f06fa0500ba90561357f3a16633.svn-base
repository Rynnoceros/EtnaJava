/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.documents;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.LogManager;
import com.etna.mypenelope.core.dao.impl.ContactSQLDao;
import com.etna.mypenelope.core.dao.impl.DocumentSQLDao;
import com.etna.mypenelope.core.dao.impl.GroupeSQLDao;
import com.etna.mypenelope.core.dao.impl.ProjectDocumentSQLDao;
import com.etna.mypenelope.core.dao.impl.ProjectSQLDao;
import com.etna.mypenelope.core.dao.impl.UtilisateurSQLDao;
import com.etna.mypenelope.core.entities.Document;
import com.etna.mypenelope.core.entities.Project;
import com.etna.mypenelope.core.entities.ProjectDocument;
import com.etna.mypenelope.core.entities.Groupe;
import com.etna.mypenelope.core.entities.Utilisateur;
import com.etna.mypenelope.core.entities.Contact;
import com.etna.mypenelope.core.interfaces.IPersonne.PersonType;
import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author soubri_j/martin_m
 */
public class FXMLDocumentManagementController implements Initializable {
    private final ProjectSQLDao projectDao = new ProjectSQLDao(Project.class, Constants.TABLE_PROJECTS);
    private final ProjectDocumentSQLDao projectDocumentDao = new ProjectDocumentSQLDao(ProjectDocument.class, Constants.TABLE_PROJECTS_DOCUMENTS);
    private final DocumentSQLDao documentDao = new DocumentSQLDao(Document.class, Constants.TABLE_DOCUMENTS);
    private final GroupeSQLDao groupeDao = new GroupeSQLDao(Groupe.class, Constants.TABLE_GROUPES);
    private final UtilisateurSQLDao utilisateurDao = new UtilisateurSQLDao(Utilisateur.class, Constants.TABLE_UTILISATEUR);
    private final ContactSQLDao contactDao = new ContactSQLDao(Contact.class, Constants.TABLE_CONTACTS);
    
    @FXML
    AnchorPane panel;
    
    @FXML
    ListView lvProjects;
    
    @FXML
    ListView lvDocuments;
    
    @FXML
    ComboBox cbPersonType;
    
    @FXML
    ComboBox cbOwner;
    
    @FXML
    Button btnBrowse;
    
    @FXML
    Button btnAdd;
    
    @FXML
    Button btnEdit;
    
    @FXML
    Button btnRemove;
    
    @FXML
    TextField txtDocument;
    
    @FXML
    TextArea txtaContent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadProjects();
        loadPersonType();
        lvProjects.getSelectionModel().selectedItemProperty().addListener(onProjectSelectedChanged());
        lvDocuments.getSelectionModel().selectedItemProperty().addListener(onDocumentSelectedChanged());
        cbPersonType.getSelectionModel().selectedItemProperty().addListener(onPersonTypeSelectedChanged());
        btnBrowse.setDisable(Boolean.TRUE);
        btnEdit.setDisable(Boolean.TRUE);
        btnRemove.setDisable(Boolean.TRUE);
    }    
    
    public void addDocument() {
        txtDocument.setEditable(Boolean.TRUE);
        btnBrowse.setDisable(Boolean.FALSE);
    }
    
    public void editDocument() {
        txtDocument.setEditable(Boolean.FALSE);
        btnBrowse.setDisable(Boolean.TRUE);
    }
    
    public void removeDocument() {
        txtDocument.setEditable(Boolean.FALSE);
        btnBrowse.setDisable(Boolean.TRUE);
        ProjectDocument toDelete = (ProjectDocument) lvDocuments.getSelectionModel().getSelectedItem();
        if (toDelete != null) {
            Document docToDelete = documentDao.findById(toDelete.getIdDocument());
            if (docToDelete != null) {
                projectDocumentDao.deleteWhereDocument(docToDelete);
                documentDao.delete(docToDelete);
                lvDocuments.getItems().remove(toDelete);
            }
        }
    }
    
    public void browseDocument() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(panel.getScene().getWindow());
        if (selectedFile != null) {
           txtDocument.setText(selectedFile.getAbsolutePath());
        }
    }
    
    public void saveDocument() {
        if (txtDocument.isEditable()) {
            createDocument();
        } else {
            updateDocument();
        }
    }
    
    private void createDocument() {
        Document toAdd = new Document();
        ProjectDocument toAddDoc = new ProjectDocument();
        String selectedPersonType = cbPersonType.getSelectionModel().getSelectedItem().toString();
        toAdd.setPersonType(PersonType.valueOf(selectedPersonType));
        toAdd.setIdDocumentOwner(getIdOwner(cbOwner.getSelectionModel().getSelectedItem()));
        toAdd.setName(Paths.get(txtDocument.textProperty().getValueSafe()).getFileName().toString());
        if (txtDocument.textProperty() != null) {
            try {
                toAdd.setContent(Files.readAllBytes(Paths.get(txtDocument.textProperty().getValueSafe())));
            } catch (IOException ex) {
                LogManager.getInstance().log(ex.getLocalizedMessage());
            }
        }
        toAdd = documentDao.create(toAdd);
        if (toAdd != null) {
            Project selectedProject = (Project)lvProjects.getSelectionModel().getSelectedItem();
            toAddDoc.setIdDocument(toAdd.getIdDocument());
            toAddDoc.setIdProject(selectedProject.getIdProject());
            toAddDoc.setDocument(toAdd);
            toAddDoc = projectDocumentDao.create(toAddDoc);
            if (toAddDoc != null) {
                lvDocuments.getItems().add(toAddDoc);
            }
        }
    }
    
    private Integer getIdOwner(Object owner) {
        Integer idOwner = -1;
        if (owner.getClass() == Utilisateur.class) {
            idOwner = ((Utilisateur)owner).getIdUtilisateur();
        } else if (owner.getClass() == Contact.class) {
            idOwner = ((Contact)owner).getIdContact();
        } else if (owner.getClass() == Groupe.class) {
            idOwner = ((Groupe)owner).getIdGroupe();
        }
        return idOwner;
    }
    
    private void updateDocument() {
        String selectedPersonType = cbPersonType.getSelectionModel().getSelectedItem().toString();
        ProjectDocument tmp = (ProjectDocument)lvDocuments.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            Document toUpdate = documentDao.findById(tmp.getIdDocument());
            if (toUpdate != null) {
                toUpdate.setPersonType(PersonType.valueOf(selectedPersonType));
                toUpdate.setIdDocumentOwner(getIdOwner(cbOwner.getSelectionModel().getSelectedItem()));
                documentDao.update(toUpdate);                
            }
        }
    }
    
    private void loadProjects() {
        this.lvProjects.getItems().setAll(projectDao.findAll());
    }
    
    private void loadDocuments(Project project) {
        List<ProjectDocument> all = projectDocumentDao.findAllDocuments();
        
        if (project != null) {
            lvDocuments.getItems().setAll(all.stream()
                                  .filter(projectDocumentDao.filterByIdProject(project.getIdProject()))
                                  .collect(Collectors.toList()));
        }
    }
    
    private void loadPersonType() {
        for (PersonType pt : PersonType.values()) {
            this.cbPersonType.getItems().add(pt.toString());
        }
    }
    
    protected ChangeListener<Project> onProjectSelectedChanged() {
        return (ObservableValue<? extends Project> observable, Project oldValue, Project newValue) -> {
            loadDocuments(newValue);
        };
    }  
    
    protected ChangeListener<ProjectDocument> onDocumentSelectedChanged() {
        return (ObservableValue<? extends ProjectDocument> observable, ProjectDocument oldValue, ProjectDocument newValue) -> {
            updateScreenAuthorization();
            loadDocumentInformations();
        };
    }
    
    protected ChangeListener<String> onPersonTypeSelectedChanged() {
        return (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.equals(oldValue)) {
                cbOwner.getSelectionModel().clearSelection();
                loadOwner(newValue);
            }
        };
    }
    
    private void loadOwner(String personType) {
        if (personType.equals(PersonType.Contact.toString())) {
            cbOwner.getItems().setAll(contactDao.findAll());
        } else if (personType.equals(PersonType.Groupe.toString())) {
            cbOwner.getItems().setAll(groupeDao.findAll());
        } else if (personType.equals(PersonType.Utilisateur.toString())) {
            cbOwner.getItems().setAll(utilisateurDao.findAll());
        }
    }

    private void updateScreenAuthorization() {
        if (lvDocuments.getSelectionModel().getSelectedItem() != null) {
            txtDocument.setEditable(Boolean.FALSE);
            btnEdit.setDisable(Boolean.FALSE);
            btnRemove.setDisable(Boolean.FALSE);
        } else {
            btnEdit.setDisable(Boolean.FALSE);
            btnRemove.setDisable(Boolean.FALSE);
        }
    }
    
    private void loadDocumentInformations() {
        ProjectDocument tmp = (ProjectDocument)lvDocuments.getSelectionModel().getSelectedItem();
        if (tmp != null) {
            Document tmpDoc = documentDao.findById(tmp.getIdDocument());
            if (tmpDoc != null) {
                PersonType tmpType = tmpDoc.getPersonType();
                cbPersonType.getSelectionModel().select(tmpType.toString());
                switch (tmpType) {
                    case Utilisateur:
                        Utilisateur tmpUtil = utilisateurDao.findById(tmpDoc.getIdDocumentOwner());
                        if (tmpUtil != null) {
                            cbOwner.getSelectionModel().select(tmpUtil);
                        }   break;
                    case Groupe:
                        Groupe tmpGroupe = groupeDao.findById(tmpDoc.getIdDocumentOwner());
                        if (tmpGroupe != null) {
                            cbOwner.getSelectionModel().select(tmpGroupe);
                        }   break;
                    case Contact:
                        Contact tmpContact = contactDao.findById(tmpDoc.getIdDocumentOwner());
                        if (tmpContact != null) {
                            cbOwner.getSelectionModel().select(tmpContact);
                        }   break;
                    default:
                        break;
                }
                txtaContent.setText(new String(tmpDoc.getContent(), StandardCharsets.UTF_8));
            }
        }
    }
}
