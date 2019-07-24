/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.factories;

import com.cours.ebenus.dao.entities.Commande;
import com.cours.ebenus.interfaces.IExport;
import com.cours.ebenus.utils.OrderExporterJson;
import com.cours.ebenus.utils.OrderExporterXml;

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
    
    public IExport<Commande> getOrderExporter(String exportType) {
        switch (exportType) {
            case "xml":
                return OrderExporterXml.getInstance();
            case "json":
                return OrderExporterJson.getInstance();
            default:
                return OrderExporterJson.getInstance();
        }
    }
}
