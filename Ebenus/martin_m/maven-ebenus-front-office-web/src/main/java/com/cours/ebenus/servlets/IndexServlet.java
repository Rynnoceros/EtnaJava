/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Commande;
import com.cours.ebenus.dao.entities.Produit;
import com.cours.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.io.PrintWriter;
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
public class IndexServlet extends HttpServlet {
    
    private IServiceFacade serviceFacade = null;
    List<Commande> allCommandes = new ArrayList<Commande>();
    Commande loggedCommande = null;
    List<Utilisateur> allUsers = new ArrayList<Utilisateur>();
    Utilisateur loggedUser = null;
    List<Produit> allProduits = new ArrayList<Produit>();
    List<ArticleCommande> allArticles = new ArrayList<ArticleCommande>();
    List<ArticleCommande> articlesPlusVendu = new ArrayList<ArticleCommande>();
    
    
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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        allUsers = serviceFacade.getUtilisateurDao().findAllUtilisateurs();
        request.setAttribute("allUsers", this.allUsers);
        request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
        request.setAttribute("isAdministrateur", UserConnectedManager.getInstance().isAdministrateur());
        request.setAttribute("connected", UserConnectedManager.getInstance().isUserConnected());


        allArticles = serviceFacade.getArticleCommandeDao().findArticleOrderByTotalCommande();
        
        int cpt = 0;
        boolean verif = true;
        for (ArticleCommande list : allArticles){
            if (cpt == 0){
                articlesPlusVendu.add(list);
                cpt++;
            }
            else{
                if (!list.getProduit().getIdProduit().equals(articlesPlusVendu.get(cpt-1).getProduit().getIdProduit()) ){
    //                 System.out.print(" list: "+list.getProduit().getIdProduit()+" --- ");
                    for (int i = 0; i < cpt; i++){
//                         System.out.print("i = "+i+" cpt =  "+cpt+" list: "+ list.getProduit().getIdProduit() +" plusV: "+articlesPlusVendu.get(i).getProduit().getIdProduit()+" - ");
                         if (list.getProduit().getIdProduit().equals(articlesPlusVendu.get(i).getProduit().getIdProduit())){
//                            System.out.println("list: "+ list.getProduit().getIdProduit() +" plusV: "+articlesPlusVendu.get(i).getProduit().getIdProduit());
                            verif = false;
                         }
                     }   
    //                System.out.println(verif);
                    if (verif){
//                        System.out.println("ajout de " + list.getProduit().getIdProduit());
                        articlesPlusVendu.add(list);
                         cpt++;
                    }

                    verif = true;
                } 
                
            }
        }
        
        
        
        request.setAttribute("articlesPlusVendu", articlesPlusVendu);
        request.setAttribute("allArticles", allArticles);
//        request.setAttribute("", this);
        this.getServletContext().getRequestDispatcher("/pages/home/index.jsp").forward(request, response);
    }

    
}
