/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;        
import java.io.InputStream;

/**
 * Configuration Helper class used to read properties files
 * @author rynnoceros
 */
public class ConfigurationHelper {
    InputStream is;
    String fileName = "/application.properties";
    Properties prop = null;
    
    public ConfigurationHelper(String fileName) {
        if (fileName != null) {
            this.fileName = fileName;
        }
        try {
            is = new FileInputStream(Core.getInstance().getApplicationFolder() + "/resources/" + this.fileName);
            if (is != null) {
                this.prop = new Properties();
                prop.load(is);
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }
        } catch (FileNotFoundException ex) {
            LogManager.getInstance().log(ex.getLocalizedMessage());
        } catch (IOException ex) {
            LogManager.getInstance().log(ex.getLocalizedMessage());
        }
    }
    
    public String getPropertyValue(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
