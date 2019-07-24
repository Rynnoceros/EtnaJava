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
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author soubri_j/martin_m
 */
public class UserExporterJson implements IExport<Utilisateur> {
    
    private UserExporterJson() {
        
    }
    
    private static class UserExportJsonHolder {
        private static final UserExporterJson instance = new UserExporterJson();
    }
    
    public static UserExporterJson getInstance() {
        return UserExportJsonHolder.instance;
    }
    
    @Override
    public File export(List<Utilisateur> utilisateurs) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/tmp.json");
        if (file != null) { 
            writeListToJSONFile(utilisateurs, file.getAbsolutePath());
        }
        return file;
    }
    
    private void writeListToJSONFile(List<Utilisateur> list, String jsonFilePath) {
    	JSONArray jsonArray = null;
    	JSONObject jsonObject = null;
    	FileWriter fw = null;
    	
    	if (list != null) {
            try {    		
                jsonArray = generateJSONArray(list);
                if (jsonArray != null) { 				
                    jsonObject = new JSONObject();
                    if (jsonObject != null) {
                        jsonObject.put("utilisateurs", jsonArray);
                        fw = new FileWriter(jsonFilePath);
                        if (fw != null) {
                            fw.write(jsonObject.toJSONString());
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
    	}
    }
	
    private JSONArray generateJSONArray(List<Utilisateur> list) {
    	JSONArray jsonArray = null;
    	
    	if (list != null) {
            jsonArray = new JSONArray();
            if (jsonArray != null) {
                for (Utilisateur t : list) {
                    jsonArray.add(generateJSONObject(t));
                }
            }
    	}
    	
    	return jsonArray;
    }
	
    private JSONObject generateJSONObject(Utilisateur t) {
    	JSONObject jsonObject = null;
    	
    	if (t != null) {
            jsonObject = new JSONObject();
            if (jsonObject != null) {    
                jsonObject.put("civilite", t.getCivilite());
                jsonObject.put("prenom", t.getPrenom());
                jsonObject.put("nom", t.getNom());
                jsonObject.put("dateNaissance", t.getDateNaissance());
                jsonObject.put("identifiantRole", t.getRole().getIdentifiant());
                jsonObject.put("identifiant", t.getIdentifiant());
                jsonObject.put("motPasse", t.getMotPasse());
            }
    	}
    	
    	return jsonObject;
    }
}
