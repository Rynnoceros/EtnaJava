/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.utils;

import com.cours.ebenus.dao.entities.Commande;
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
public class OrderExporterXml implements IExport<Commande> {
    
    private OrderExporterXml() {
        
    }
    
    private static class OrderExporterXmlHolder {
        private static final OrderExporterXml instance = new OrderExporterXml();
    }
    
    public static OrderExporterXml getInstance() {
        return OrderExporterXmlHolder.instance;
    }
    
    @Override
    public File export(List<Commande> commandes) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/tmp.xml");
        if (file != null) {
            writeListToXMLFile(commandes, file.getAbsolutePath());
        }
        return file;
    }
    
	
    private void writeListToXMLFile(List<Commande> allInstances, String xmlFilePath) {
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
	
    private Document createXMLDocument(List<Commande> allInstances) {
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
                            root = doc.createElement("commandes");
                            if (root != null) {
                                for (Commande instance : allInstances) {
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
	
    private Element createElement(Commande instance, Document doc) {
    	Element toReturn = null;
    	Element child = null;
    	
    	if (instance != null) {
            try {    			
                toReturn = doc.createElement("commande");
                if (toReturn != null) {
                    child = doc.createElement("numeroCommande");
                    child.setTextContent(String.valueOf(instance.getIdCommande()));
                    toReturn.appendChild(child);
                    child = doc.createElement("identifiant");
                    child.setTextContent(instance.getUtilisateur().getIdentifiant());
                    toReturn.appendChild(child);
                    child = doc.createElement("totalCommande");
                    child.setTextContent(String.valueOf(instance.getTotalCommande()));
                    toReturn.appendChild(child);
                    child = doc.createElement("dateCommande");
                    child.setTextContent(String.valueOf(instance.getDateCommande().toString()));  				
                    toReturn.appendChild(child);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    	}
    	
    	return toReturn;
    }
}
