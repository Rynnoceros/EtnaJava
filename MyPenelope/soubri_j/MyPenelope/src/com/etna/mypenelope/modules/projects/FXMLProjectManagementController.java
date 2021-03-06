/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.projects;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.dao.impl.GroupeSQLDao;
import com.etna.mypenelope.core.dao.impl.ProjectGroupeSQLDao;
import com.etna.mypenelope.core.dao.impl.ProjectSQLDao;
import com.etna.mypenelope.core.entities.Groupe;
import com.etna.mypenelope.core.entities.Project;
import com.etna.mypenelope.core.entities.ProjectGroupe;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author soubri_j/martin_m
 */
public class FXMLProjectManagementController implements Initializable {
    private final ProjectGroupeSQLDao projectGroupeDao = new ProjectGroupeSQLDao(ProjectGroupe.class, Constants.TABLE_PROJECTS_GROUPES);
    private final ProjectSQLDao projectDao = new ProjectSQLDao(Project.class, Constants.TABLE_PROJECTS);
    private final GroupeSQLDao groupeDao = new GroupeSQLDao(Groupe.class, Constants.TABLE_GROUPES);
    
    @FXML
    ListView lvProjects;
    
    @FXML
    ListView lvGroups;
    
    @FXML
    Button btnRemoveProject;
    
    @FXML
    Button btnAddGroup;
    
    @FXML
    Button btnRemoveGroup;
    
    @FXML
    TextField txtProjectName;
    
    @FXML
    ComboBox cbGroups;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnRemoveGroup.setDisable(Boolean.TRUE);
        btnAddGroup.setDisable(Boolean.TRUE);
        btnRemoveProject.setDisable(Boolean.TRUE);
        lvProjects.getSelectionModel().selectedItemProperty().addListener(onProjectSelectedChanged());
        lvGroups.getSelectionModel().selectedItemProperty().addListener(onGroupeSelectedChanged());
        loadProjects();
        loadGroups();
    }    
    
    private ChangeListener<Project> onProjectSelectedChanged() {
        return (ObservableValue<? extends Project> observable, Project oldValue, Project newValue) -> {
            if (newValue != null) {
                btnRemoveProject.setDisable(Boolean.FALSE);
                btnAddGroup.setDisable(Boolean.FALSE);
                loadGroups(newValue);
            } else {
                btnRemoveProject.setDisable(Boolean.TRUE);
                btnAddGroup.setDisable(Boolean.TRUE);
            }
        };
    }
    
    private ChangeListener<ProjectGroupe> onGroupeSelectedChanged() {
        return (ObservableValue<? extends ProjectGroupe> observable, ProjectGroupe oldValue, ProjectGroupe newValue) -> {
            if (newValue != null) {
                btnRemoveGroup.setDisable(Boolean.FALSE);
            } else {
                btnRemoveGroup.setDisable(Boolean.TRUE);
            }
        };
    }
    
    private void loadGroups(Project project) {
        List<ProjectGroupe> all = projectGroupeDao.findAllGroupes();
        if (project != null && all != null) {
            all = all.stream().filter(filterByProject(project))
                              .collect(Collectors.toList());
            if (all != null && all.size() > 0) {
                lvGroups.getItems().setAll(all);   
            } else {
                lvGroups.getItems().clear();
            }
        }
    }
    
    private Predicate<ProjectGroupe> filterByProject(Project project) {
        return p -> p.getIdProject() == project.getIdProject();
    }
    
    private void loadProjects() {
        List<Project> all = projectDao.findAll();
        
        if (all != null) {
            lvProjects.getItems().setAll(all);
        }
    }
    
    private void loadGroups() {
        List<Groupe> all = groupeDao.findAll();
        
        if (all != null) {
            cbGroups.getItems().setAll(all);
        }
    }
    
    public void addProject() {
        lvProjects.getSelectionModel().clearSelection();
        txtProjectName.setText("");
    }
    
    public void removeProject() {
        Project toDelete = (Project)lvProjects.getSelectionModel().getSelectedItem();
        if (toDelete != null) {
            projectDao.delete(toDelete);
            lvProjects.getItems().remove(toDelete);
            projectGroupeDao.deleteWhereProject(toDelete);
        }
    }
    
    public void addGroup() {
        Groupe g = (Groupe)cbGroups.getSelectionModel().getSelectedItem();
        Project p = (Project)lvProjects.getSelectionModel().getSelectedItem();
        
        if (g != null && p != null) {
            ProjectGroupe toAdd = new ProjectGroupe();
            toAdd.setIdGroupe(g.getIdGroupe());
            toAdd.setIdProject(p.getIdProject());
            toAdd.setGroupe(g);
            toAdd = projectGroupeDao.create(toAdd);
            lvGroups.getItems().add(toAdd);
        }
    }
    
    public void removeGroup() {
        ProjectGroupe toDelete = (ProjectGroupe)lvGroups.getSelectionModel().getSelectedItem();
        if (toDelete != null) {
            projectGroupeDao.delete(toDelete);
            lvGroups.getItems().remove(toDelete);
        }
    }
    
    public void saveProject() {
        Project p = (Project)lvProjects.getSelectionModel().getSelectedItem();
        if (p == null) {
            p = new Project();
            p.setProjectName(txtProjectName.getText());
            createProject(p);
        } else {
            p.setProjectName(txtProjectName.getText());
            updateProject(p);
        }
    }
    
    private void createProject(Project p) {
        if (p != null) {
            p = projectDao.create(p);
            if (p != null) {
                lvProjects.getItems().add(p);
            }
        }
    }
    
    private void updateProject(Project p) {
        if (p != null) {
            projectDao.update(p);
            lvProjects.refresh();
        }
    }
}
