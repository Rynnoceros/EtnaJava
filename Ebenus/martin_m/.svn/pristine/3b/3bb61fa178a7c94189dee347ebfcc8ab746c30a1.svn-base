/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.factories.ExportFactory;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rynnoceros
 */
public class ExportServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    
    @Override
    public void init() throws ServletException {
        serviceFacade = new ServiceFacade();
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (UserConnectedManager.getInstance().isUserConnected()) {
            String exportType = request.getParameter("export");
            File toExport = ExportFactory.getInstance().getUserExporter(exportType).export(serviceFacade.getUtilisateurDao().findAllUtilisateurs());
            response.setContentType("application/" + exportType);
            response.setHeader("content-disposition", "attachment; filename=\"" + toExport.getName() + "\"");
            OutputStream out = response.getOutputStream();
            out.write(Files.readAllBytes(toExport.toPath()));
        } else {
            response.sendRedirect(this.getServletContext().getContextPath() + "/LoginServlet");
        }
    }
}
