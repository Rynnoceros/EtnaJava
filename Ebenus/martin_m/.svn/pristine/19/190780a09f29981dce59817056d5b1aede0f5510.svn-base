/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Utilisateur;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.cours.ebenus.utils.UserConnectedManager;

/**
 *
 * @author soubri_j/martin_m
 */
public class LoginServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private IServiceFacade serviceFacade = null;

    @Override
    public void init() throws ServletException {
    	serviceFacade = new ServiceFacade();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean redirected = false;
        List<Utilisateur> users = serviceFacade.getUtilisateurDao().findUtilisateurByIdentifiant(request.getParameter("__email"));
        if (users != null && users.size() > 0) {
            if (users.get(0).getMotPasse().equals(request.getParameter("password")))
            {
                UserConnectedManager.getInstance().loginUser(users.get(0));
                response.sendRedirect(this.getServletContext().getContextPath() + "/IndexServlet");
                redirected = true;
            }
        }
        if (!redirected) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/LoginServlet");
        }
    }

    /**
     * Méthode appelée lors de la fin de la Servlet
     */
    @Override
    public void destroy() {
    }
}
