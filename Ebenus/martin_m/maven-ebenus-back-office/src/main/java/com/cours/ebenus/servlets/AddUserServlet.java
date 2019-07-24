/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soubri_j/martin_m
 */
public class AddUserServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    private String idUtilisateur = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String dateToDisplay = "";
    private List<Role> roles = new ArrayList<Role>();
    
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
            Utilisateur toUpdate = null;
            roles = serviceFacade.getRoleDao().findAllRoles();
            
            if (request.getAttribute("error") != null) {
                toUpdate = (Utilisateur)request.getAttribute("updatedUser");
            } else {
                idUtilisateur = request.getParameter("id");
                if (idUtilisateur != null) {
                    toUpdate = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
                    dateToDisplay = dateFormat.format(toUpdate.getDateNaissance());
                }
                if (toUpdate == null) {
                    toUpdate = new Utilisateur();
                    dateToDisplay = dateFormat.format(new Date());
                }
            }
            request.setAttribute("roles", roles);
            request.setAttribute("utilisateurToUpdate", toUpdate);
            request.setAttribute("dateToDisplay", dateToDisplay);
            request.getRequestDispatcher("/pages/users/addUpdateUser.jsp").forward(request, response);
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
        Utilisateur user = new Utilisateur();
        List<Role> rolesToFind = null;
        if (idUtilisateur != null) {
            user = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
        }
        user.setPrenom(request.getParameter("firstname"));
        user.setNom(request.getParameter("lastname"));
        user.setIdentifiant(request.getParameter("email"));
        user.setMotPasse(request.getParameter("password"));
        rolesToFind = serviceFacade.getRoleDao().findRoleByIdentifiant(request.getParameter("select_city"));
        user.setRole(rolesToFind.get(0));
        user.setCivilite(request.getParameter("sex"));
        try {
            user.setDateNaissance(dateFormat.parse(request.getParameter("dteNaiss")));  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        user.setDateModification(new Date());
        user.setVersion(user.getVersion() + 1);
        
        Utilisateur isOk = null;
        if (idUtilisateur == null) {
            user.setDateCreation(new Date());
            isOk = serviceFacade.getUtilisateurDao().createUtilisateur(user);
        } else { // Update
            isOk = serviceFacade.getUtilisateurDao().updateUserWithoutPassword(user);
        }
        
        if (isOk != null) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/CrudUserServlet");
        } else {
            request.setAttribute("error", "Error requesting database");
            request.setAttribute("utilisateurToUpdate", user);
            request.setAttribute("dateToDisplay", dateToDisplay);
            request.getRequestDispatcher("/pages/users/addUpdateUser.jsp").forward(request, response);
        }
    }
}
