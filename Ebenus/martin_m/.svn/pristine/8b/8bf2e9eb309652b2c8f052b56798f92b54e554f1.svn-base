/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.interfaces.IExport;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author soubri_j/martin_m
 */
public class UserExporterCsv implements IExport<Utilisateur> {
    
    private static String headers = "civilite;prenom;nom;dateNaissance;identifiantRole;identifiant;motPasse";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private UserExporterCsv() {
    }
    
    private static class UserExporterCsvHolder {
        private static final UserExporterCsv instance = new UserExporterCsv();
    }
    
    public static UserExporterCsv getInstance() {
        return UserExporterCsvHolder.instance;
    }
    
    @Override
    public File export(List<Utilisateur> utilisateurs) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/tmp.csv");
        if (file != null) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(file);
                if (fw != null) {
                    fw.write(headers);
                    fw.write("\n");
                    for (Utilisateur user : utilisateurs) {
                        String line = constructLineUtilisateur(user);
                        fw.write(line);
                    }
                }
            } catch (IOException e) {
                    e.printStackTrace();
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }				
            }
        }
        return file;
    }
    
    private String constructLineUtilisateur(Utilisateur user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getCivilite()).append(";");
        sb.append(user.getPrenom()).append(";");
        sb.append(user.getNom()).append(";");
        sb.append(dateFormat.format(user.getDateNaissance())).append(";");
        sb.append(user.getRole().getIdentifiant()).append(";");
        sb.append(user.getIdentifiant()).append(";");
        sb.append(user.getMotPasse()).append("\n");
        return sb.toString();
    }
}
