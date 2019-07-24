/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

import com.cours.ebenus.dao.entities.Commande;
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
public class OrderExporterJson implements IExport<Commande> {
    
    private OrderExporterJson() {
        
    }
    
    private static class OrderExporterJsonHolder {
        private static final OrderExporterJson instance = new OrderExporterJson();
    }
    
    public static OrderExporterJson getInstance() {
        return OrderExporterJsonHolder.instance;
    }
    
    @Override
    public File export(List<Commande> commandes) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/tmp.json");
        if (file != null) { 
            writeListToJSONFile(commandes, file.getAbsolutePath());
        }
        return file;
    }
    
    private void writeListToJSONFile(List<Commande> list, String jsonFilePath) {
    	JSONArray jsonArray = null;
    	JSONObject jsonObject = null;
    	FileWriter fw = null;
    	
    	if (list != null) {
            try {    		
                jsonArray = generateJSONArray(list);
                if (jsonArray != null) { 				
                    jsonObject = new JSONObject();
                    if (jsonObject != null) {
                        jsonObject.put("commandes", jsonArray);
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
	
    private JSONArray generateJSONArray(List<Commande> list) {
    	JSONArray jsonArray = null;
    	
    	if (list != null) {
            jsonArray = new JSONArray();
            if (jsonArray != null) {
                for (Commande t : list) {
                    jsonArray.add(generateJSONObject(t));
                }
            }
    	}
    	
    	return jsonArray;
    }
	
    private JSONObject generateJSONObject(Commande t) {
    	JSONObject jsonObject = null;
    	
    	if (t != null) {
            jsonObject = new JSONObject();
            if (jsonObject != null) {    
                jsonObject.put("numeroCommande", t.getIdCommande());
                jsonObject.put("identifiant", t.getUtilisateur().getIdentifiant());
                jsonObject.put("totalCommande", t.getTotalCommande());
                jsonObject.put("dateCommande", t.getDateCommande());
            }
    	}
    	
    	return jsonObject;
    }
}
