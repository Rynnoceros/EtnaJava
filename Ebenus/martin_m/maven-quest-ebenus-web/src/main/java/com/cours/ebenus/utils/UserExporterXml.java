/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.interfaces.IExport;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author soubri_j/martin_m
 */
public class UserExporterXml implements IExport<Utilisateur> {
    
    private UserExporterXml() {
        
    }
    
    private static class UserExporterXmlHolder {
        private static final UserExporterXml instance = new UserExporterXml();
    }
    
    public static UserExporterXml getInstance() {
        return UserExporterXmlHolder.instance;
    }
    
    @Override
    public File export(List<Utilisateur> utilisateurs) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/tmp.xml");
        if (file != null) {
            writeListToXMLFile(utilisateurs, file.getAbsolutePath());
        }
        return file;
    }
    
	
    private void writeListToXMLFile(List<Utilisateur> allInstances, String xmlFilePath) {
    	Document doc = null;
    	TransformerFactory tf = null;
    	Transformer tr = null;
    	
    	if (allInstances != null) {
            try {    			
                doc = createXMLDocument(allInstances);
                if (doc != null) {    			
                    tf = TransformerFactory.newInstance();
                    if (tf != null) {
                        tr = tf.newTransformer();
                        if (tr != null) {
                            tr.setOutputProperty(OutputKeys.INDENT, "yes");
                            tr.setOutputProperty(OutputKeys.METHOD, "xml");
                            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");    					
                            tr.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(xmlFilePath)));
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    	}
    }
	
    private Document createXMLDocument(List<Utilisateur> allInstances) {
    	Document doc = null;
    	Element root = null;
    	Element element = null;
    	DocumentBuilderFactory dbf = null;
    	DocumentBuilder db = null;
    	
    	if (allInstances != null) {
            try {
                dbf = DocumentBuilderFactory.newInstance();
                if (dbf != null) {
                    db = dbf.newDocumentBuilder();
                    if (db != null) {
                        doc = db.newDocument();
                        if (doc != null) {
                            root = doc.createElement("utilisateurs");
                            if (root != null) {
                                for (Utilisateur instance : allInstances) {
                                    element = createElement(instance, doc);
                                    if (element != null) {
                                        root.appendChild(element);
                                    }
                                }
                                doc.appendChild(root);
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    	}
    	
    	return doc;
    }
	
    private Element createElement(Utilisateur instance, Document doc) {
    	Element toReturn = null;
    	Element child = null;
    	
    	if (instance != null) {
            try {    			
                toReturn = doc.createElement("utilisateur");
                if (toReturn != null) {
                    toReturn.setAttribute("civilite", instance.getCivilite());
                    toReturn.setAttribute("prenom", instance.getPrenom());
                    toReturn.setAttribute("nom", instance.getNom());
                    toReturn.setAttribute("dateNaissance", instance.getDateNaissance().toString());
                    toReturn.setAttribute("identifiantRole", instance.getRole().getIdentifiant());    				
                    toReturn.setAttribute("identifiant", instance.getIdentifiant());
                    toReturn.setAttribute("motPasse", instance.getMotPasse());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    	}
    	
    	return toReturn;
    }
}
