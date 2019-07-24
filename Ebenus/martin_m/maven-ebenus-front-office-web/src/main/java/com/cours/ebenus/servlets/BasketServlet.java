/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Commande;
import com.cours.ebenus.dao.entities.Produit;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soubri_j/martin_m
 */
public class BasketServlet extends HttpServlet {
 
    private IServiceFacade serviceFacade = null;
    private String idCommande = null;
    
     @Override
    public void init() throws ServletException {
        serviceFacade = new ServiceFacade() ;
    }
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
        request.setAttribute("connected", UserConnectedManager.getInstance().isUserConnected());
        if (UserConnectedManager.getInstance().isUserConnected()) {
            Commande commande = new Commande();
        
            if (request.getAttribute("error") != null) {
                this.getServletContext().getRequestDispatcher("/pages/404/404.jsp").forward(request, response);
            } else {
                idCommande = request.getParameter("id");
//                adresseFacturation = request.getParameter("idUtilisateur");
                if (idCommande != null) {
                    commande = serviceFacade.getCommandeDao().findCommandeById(Integer.parseInt(idCommande));
                }
                if (commande == null) {
                    commande = new Commande();
                }
               
                this.getServletContext().getRequestDispatcher("/pages/basket/basket.jsp").forward(request, response);
            }
            
        } else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }
    

}
