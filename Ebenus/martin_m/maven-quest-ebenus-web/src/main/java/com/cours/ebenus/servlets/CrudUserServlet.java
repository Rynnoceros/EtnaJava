/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elhad
 */
// @WebServlet(name = "CrudUserServlet", urlPatterns = {"/CrudUserServlet"})
public class CrudUserServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    List<Utilisateur> allUsers = new ArrayList<Utilisateur>();
    Utilisateur loggedUser = null;
    
    /**
     * Méthode d'initialisation de la Servlet
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        serviceFacade = new ServiceFacade();
    }

    /**
     * Méthode appelée lors d'une requête HTTP GET
     *
     * @param request L'objet requête contenant les informations de la requête
     * http
     * @param response L'objet réponse contenant les informations de la réponse
     * http
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        allUsers = serviceFacade.getUtilisateurDao().findAllUtilisateurs();
        request.setAttribute("allUsers", this.allUsers);
        request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
        request.setAttribute("isAdministrateur", UserConnectedManager.getInstance().isAdministrateur());
        if (UserConnectedManager.getInstance().isUserConnected()) {
            this.getServletContext().getRequestDispatcher("/pages/crudUser/allUsers.jsp").forward(request, response);
        } else {
            response.sendRedirect(this.getServletContext().getContextPath() + "/LoginServlet");
        }
    }

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

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");
        if (UserConnectedManager.getInstance().isAdministrateur()) {
            if (param != null) {
                param = param.replaceAll("'", "");
                Integer id = Integer.parseInt(param);
                if (id > 0) {
                    Utilisateur toDelete = new Utilisateur();
                    toDelete.setIdUtilisateur(id);
                    boolean deleted = serviceFacade.getUtilisateurDao().deleteUtilisateur(toDelete);
                    if (deleted) {
                        allUsers.removeIf(filterById(id));
                        resp.setStatus(HttpServletResponse.SC_OK);
                    }
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }  
    }
    
    private Predicate<Utilisateur> filterById(int id) {
        return p -> p.getIdUtilisateur() == id;
    }

    /**
     * Méthode appelée lors de la fin de la Servlet
     */
    @Override
    public void destroy() {
    }
}
