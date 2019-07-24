/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author soubri_j/martin_m
 */
public class UserImportCsv {
    
    private static IServiceFacade serviceFacade = null;
    private static String headers = "civilite;prenom;nom;dateNaissance;identifiantRole;identifiant;motPasse";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private UserImportCsv() {
        serviceFacade = new ServiceFacade();
    }
    
    private static class UserImportCsvHolder {
        private static final UserImportCsv instance = new UserImportCsv();
    }
    
    public static UserImportCsv getInstance() {
        return UserImportCsvHolder.instance;
    }
    
    public void importCsv(FileItem file) {
        if (file != null) {
            InputStreamReader ir = null;
            BufferedReader br = null;
            
            try {
                ir = new InputStreamReader(file.getInputStream());
                if (ir != null) {
                    br = new BufferedReader(ir);
                    String headers = br.readLine();
                    String line = br.readLine();
                    while (line != null) {
                        loadUser(headers, line);
                        line = br.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ir != null) {
                        ir.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
	
    private void loadUser(String headers, String line) {
        String[] header = headers.split(Constants.CSV_SEPARATOR);
        String[] lin = line.split(Constants.CSV_SEPARATOR);

        if (header.length > 0) {
            try {
                Utilisateur um = new Utilisateur();
                for (int i = 0; i < header.length; ++i) {
                    switch (header[i].trim()) {
                        case "civilite":
                            um.setCivilite(lin[i]);
                            break;
                        case "prenom":
                            um.setPrenom(lin[i]);
                            break;
                        case "nom":
                            um.setNom(lin[i]);
                            break;
                        case "identifiant":
                            um.setIdentifiant(lin[i]);
                            break;
                        case "motPasse":
                            um.setMotPasse(lin[i]);
                            break;
                        case "dateNaissance":
                            um.setDateNaissance(dateFormat.parse(lin[i]));
                            break;
                        case "identifiantRole":
                            List<Role> roles = serviceFacade.getRoleDao().findRoleByIdentifiant(lin[i]);
                            if (roles != null && roles.size() > 0) {
                                um.setRole(roles.get(0));
                            }
                            break;
                    }
                }				 
                saveUserInDatabase(um);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void saveUserInDatabase(Utilisateur um) {
        List<Utilisateur> users = serviceFacade.getUtilisateurDao().findUtilisateurByIdentifiant(um.getIdentifiant());
        Utilisateur isOk = null;
        um.setDateModification(new Date());
        if (users != null && users.size() > 0) {
            Utilisateur toUpdate = users.get(0);
            um.setIdUtilisateur(toUpdate.getIdUtilisateur());
            isOk = serviceFacade.getUtilisateurDao().updateUserWithoutPassword(um);
        } else {
            um.setDateCreation(new Date());
            isOk = serviceFacade.getUtilisateurDao().createUtilisateur(um);
        }
    }
}
