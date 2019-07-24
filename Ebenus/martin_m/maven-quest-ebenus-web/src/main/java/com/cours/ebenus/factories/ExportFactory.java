/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.factories;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.interfaces.IExport;
import com.cours.ebenus.utils.UserExporterCsv;
import com.cours.ebenus.utils.UserExporterJson;
import com.cours.ebenus.utils.UserExporterXml;

/**
 *
 * @author soubri_j/martin_m
 */
public class ExportFactory {
    
    private ExportFactory() {
        
    }
    
    private static class ExportFactoryHolder {
        private static final ExportFactory instance = new ExportFactory();
    }
    
    public static ExportFactory getInstance() {
        return ExportFactoryHolder.instance;
    }
    
    public IExport<Utilisateur> getUserExporter(String exportType) {
        switch (exportType) {
            case "csv":
                return UserExporterCsv.getInstance();
            case "xml":
                return UserExporterXml.getInstance();
            case "json":
                return UserExporterJson.getInstance();
            default:
                return UserExporterCsv.getInstance();
        }
    }
}
