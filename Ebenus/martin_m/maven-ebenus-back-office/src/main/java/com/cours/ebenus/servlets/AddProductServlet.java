/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Produit;
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
public class AddProductServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    private String idProduit = null;    
    
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
            Produit toUpdate = null;
            
            if (request.getAttribute("error") != null) {
                toUpdate = (Produit)request.getAttribute("updatedProduct");
            } else {
                idProduit = request.getParameter("id");
                if (idProduit != null) {
                    toUpdate = serviceFacade.getProduitDao().findProduitById(Integer.parseInt(idProduit));
                }
                if (toUpdate == null) {
                    toUpdate = new Produit();
                }
            }
            request.setAttribute("produitToUpdate", toUpdate);
            request.getRequestDispatcher("/pages/products/addUpdateProduct.jsp").forward(request, response);
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
        Produit produit = new Produit();
        List<Role> roles = null;
        if (idProduit != null) {
            produit = serviceFacade.getProduitDao().findProduitById(Integer.parseInt(idProduit));
        }
        produit.setActive(Boolean.valueOf(request.getParameter("active")));
        produit.setDescription(request.getParameter("description"));
        produit.setNom(request.getParameter("nomProduit"));
        produit.setPrix(Double.valueOf(request.getParameter("prix")));
        produit.setReference(request.getParameter("reference"));
        produit.setStock(Integer.valueOf(request.getParameter("stock")));
        
        Produit isOk = null;
        if (idProduit == null) {
            isOk = serviceFacade.getProduitDao().createProduit(produit);
        } else { // Update
            isOk = serviceFacade.getProduitDao().updateProduit(produit);
        }
        
        if (isOk != null) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/CrudProductServlet");
        } else {
            request.setAttribute("error", "Error requesting database");
            request.setAttribute("produitToUpdate", produit);
            request.getRequestDispatcher("/pages/products/addUpdateProduct.jsp").forward(request, response);
        }
    }
}
