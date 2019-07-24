/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soubri_j/martin_m
 */
public class AddRoleServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    private String idRole = null;    
    
    /**
     * Méthode d'initialisation de la Servlet
     *
     * @throws ServletException
     */
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
        if (UserConnectedManager.getInstance().isAdministrateur()) {
            Role toUpdate = null;
            
            if (request.getAttribute("error") != null) {
                toUpdate = (Role)request.getAttribute("updatedRole");
            } else {
                idRole = request.getParameter("id");
                if (idRole != null) {
                    toUpdate = serviceFacade.getRoleDao().findRoleById(Integer.parseInt(idRole));
                }
                if (toUpdate == null) {
                    toUpdate = new Role();
                }
            }
            request.setAttribute("roleToUpdate", toUpdate);
            request.getRequestDispatcher("/pages/roles/addUpdateRole.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Role role = new Role();
        List<Role> roles = null;
        if (idRole != null) {
            role = serviceFacade.getRoleDao().findRoleById(Integer.parseInt(idRole));
        }
        role.setIdentifiant(request.getParameter("identifiant"));
        role.setDescription(request.getParameter("description"));
        
        Role isOk = null;
        if (idRole == null) {
            isOk = serviceFacade.getRoleDao().createRole(role);
        } else { // Update
            isOk = serviceFacade.getRoleDao().updateRole(role);
        }
        
        if (isOk != null) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/CrudRoleServlet");
        } else {
            request.setAttribute("error", "Error requesting database");
            request.setAttribute("roleToUpdate", role);
            request.getRequestDispatcher("/pages/roles/addUpdateRole.jsp").forward(request, response);
        }
    }
}
