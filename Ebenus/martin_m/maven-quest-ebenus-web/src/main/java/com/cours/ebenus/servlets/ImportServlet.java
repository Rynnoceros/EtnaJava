/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.utils.UserImportCsv;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author soubri_j/martin_m
 */
public class ImportServlet extends HttpServlet {    
    /**
     * Méthode appelée lors d'une requête HTTP POST
     *
     * @param request L'objet requête contenant les informations de la requête
     * http
     * @param response L'objet réponse contenant les informations de la réponse
     * http
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Parse the request
        List<FileItem> items;
        try {
            items = upload.parseRequest(request);
            for (FileItem item : items) {
                InputStream in = item.getInputStream();
                UserImportCsv.getInstance().importCsv(item);
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(ImportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/CrudUserServlet");
    }
}
