/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.modules.groupes;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.dao.impl.ContactSQLDao;
import com.etna.mypenelope.core.dao.impl.GroupeMemberSQLDao;
import com.etna.mypenelope.core.dao.impl.GroupeSQLDao;
import com.etna.mypenelope.core.dao.impl.UtilisateurSQLDao;
import com.etna.mypenelope.core.entities.Contact;
import com.etna.mypenelope.core.entities.Groupe;
import com.etna.mypenelope.core.entities.GroupeMember;
import com.etna.mypenelope.core.entities.Utilisateur;
import com.etna.mypenelope.core.interfaces.IPersonne;
import com.etna.mypenelope.core.interfaces.IPersonne.PersonType;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
public class FXMLGroupeManagementController implements Initializable {
    private final GroupeSQLDao groupeDao = new GroupeSQLDao(Groupe.class, Constants.TABLE_GROUPES);
    private final GroupeMemberSQLDao groupeMemberDao = new GroupeMemberSQLDao(GroupeMember.class, Constants.TABLE_GROUPES_MEMBERS);
    private final UtilisateurSQLDao utilisateurDao = new UtilisateurSQLDao(Utilisateur.class, Constants.TABLE_UTILISATEUR);
    private final ContactSQLDao contactSQLDao = new ContactSQLDao(Contact.class, Constants.TABLE_CONTACTS);
    
    @FXML
    ListView lvGroups;
    
    @FXML
    ListView lvMembers;
    
    @FXML
    Button btnAddMember;
    
    @FXML
    Button btnRemoveGroup;
    
    @FXML
    Button btnRemoveMember;
    
    @FXML
    ComboBox cbPersonType;
    
    @FXML
    ComboBox cbMemberToAdd;
    
    @FXML
    TextField txtName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvGroups.getSelectionModel().selectedItemProperty().addListener(onGroupeSelectedChanged());
        lvMembers.getSelectionModel().selectedItemProperty().addListener(onMemberSelectedChanged());
        cbPersonType.getSelectionModel().selectedItemProperty().addListener(onMemberTypeSelectedChanged());
        btnRemoveGroup.setDisable(Boolean.TRUE);
        btnRemoveMember.setDisable(Boolean.TRUE);
        btnAddMember.setDisable(Boolean.TRUE);
        loadMemberType();
        loadGroups();
    }    
    
    private void loadGroups() {
        List<Groupe> allGroups = groupeDao.findAll();
        
        if (allGroups != null) {
            lvGroups.getItems().setAll(allGroups);
        }
    }
    
    private void loadMemberType() {
        cbPersonType.getItems().clear();
        cbPersonType.getItems().add(PersonType.Utilisateur.toString());
        cbPersonType.getItems().add(PersonType.Contact.toString());
    }
    
    private ChangeListener<Groupe> onGroupeSelectedChanged() {
        return (ObservableValue<? extends Groupe> observable, Groupe oldValue, Groupe newValue) -> {
            if (newValue != null) {
                loadMembers(newValue);
                txtName.setText(newValue.getGroupName());
                btnRemoveGroup.setDisable(Boolean.FALSE);
                btnAddMember.setDisable(Boolean.FALSE);
            } else {
                btnRemoveGroup.setDisable(Boolean.TRUE);
                btnAddMember.setDisable(Boolean.TRUE);
            }
        };
    }
    
    private ChangeListener<GroupeMember> onMemberSelectedChanged() {
        return (ObservableValue<? extends GroupeMember> observable, GroupeMember oldValue, GroupeMember newValue) -> {
            if (newValue != null) {
                btnRemoveMember.setDisable(Boolean.FALSE);
            }
        };
    }
    
    private ChangeListener<String> onMemberTypeSelectedChanged() {
        return (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (newValue != null) {
                if (newValue.equals(PersonType.Utilisateur.toString())) {
                    cbMemberToAdd.getItems().setAll(utilisateurDao.findAll());
                } else if (newValue.equals(PersonType.Contact.toString())) {
                    cbMemberToAdd.getItems().setAll(contactSQLDao.findAll());
                }
            }
        };
    }
    
    private void loadMembers(Groupe selectedGroup) {
        List<GroupeMember> allMembers = groupeMemberDao.findAllMembers();
        
        if (allMembers != null) {
            lvMembers.getItems().setAll(allMembers);
        }
    }
    
    public void addMember() {
        Groupe selectedGroup = (Groupe)lvGroups.getSelectionModel().getSelectedItem();
        GroupeMember toAdd = new GroupeMember();
        IPersonne member = (IPersonne)cbMemberToAdd.getSelectionModel().getSelectedItem();
        if (selectedGroup != null) {
            toAdd.setIdGroupe(selectedGroup.getIdGroupe());
            toAdd.setIdPersonne(member.getId());
            toAdd.setPersonType(cbPersonType.getSelectionModel().getSelectedItem().toString());
            toAdd.setMember(member);
            toAdd = groupeMemberDao.create(toAdd);
            lvMembers.getItems().add(toAdd);
        }
    }
    
    public void removeMember() {
        GroupeMember toDelete = (GroupeMember)lvMembers.getSelectionModel().getSelectedItem();
        
        if (toDelete != null) {
            groupeMemberDao.delete(toDelete);
            lvMembers.getItems().remove(toDelete);
        }
    }
    
    public void addGroup() {
        lvGroups.getSelectionModel().clearSelection();
        txtName.setText("");
    }
    
    public void removeGroup() {
        Groupe toDelete = (Groupe)lvGroups.getSelectionModel().getSelectedItem();
        
        if (toDelete != null) {
            groupeMemberDao.deleteWhereGroup(toDelete);
            groupeDao.delete(toDelete);
            lvGroups.getItems().remove(toDelete);
        }
    }
    
    public void saveGroup() {
        Groupe tmp = (Groupe)lvGroups.getSelectionModel().getSelectedItem();
        if (tmp == null) {
            tmp = createGroup();
            if (tmp != null) {
                lvGroups.getItems().add(tmp);
            }
        } else {
            tmp.setName(txtName.getText());
            updateGroup(tmp);
            lvGroups.refresh();
        }
    }
    
    private Groupe createGroup() {
        Groupe toCreate = new Groupe();
        toCreate.setName(txtName.getText());
        toCreate = groupeDao.create(toCreate);
        
        return toCreate;
    }
    
    private void updateGroup(Groupe toUpdate) {
        if (toUpdate != null) {
            toUpdate.setName(txtName.getText());
            groupeDao.update(toUpdate);
        }
    }
}
