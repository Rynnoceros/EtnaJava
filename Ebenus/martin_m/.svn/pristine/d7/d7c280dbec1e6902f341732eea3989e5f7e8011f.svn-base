/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author marti
 */
public class HistoricalServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private IServiceFacade serviceFacade = null;
    private String idUtilisateur = null;
    private Adresse adresseFacturation = null;
    private Adresse adresseLivraisonPrincipale = null;
    private int compteurCommande = 0;
    List<Adresse> allAdresses = new ArrayList<Adresse>();
    List<ArticleCommande> allArticleCommandes = new ArrayList<ArticleCommande>();
    List<ArticleCommande> allCommandesUser = new ArrayList<ArticleCommande>();
    List<ArticleCommande> allCommandesId = new ArrayList<ArticleCommande>();
    List<Integer> listId = new ArrayList<Integer>();

    @Override
    public void init() throws ServletException {
    	serviceFacade = new ServiceFacade();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (UserConnectedManager.getInstance().isUserConnected()) {
            Utilisateur user = null;
            Adresse adressToUpdate = null;
            
            
                idUtilisateur = request.getParameter("id");
//                adresseFacturation = request.getParameter("idUtilisateur");
                if (idUtilisateur != null) {
                    user = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
                }
                if (user == null && adressToUpdate == null) {
                    user = new Utilisateur();
                    adressToUpdate = new Adresse();
                }
                
                allAdresses = serviceFacade.getAdresseDao().findAllAdresses();
//                int idx = 0;
                for (Adresse adr : allAdresses) {
                    
                    if (adr.getTypeAdresse().equals("F") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()))
                        adresseFacturation = adr;
//                     
                    if (adr.getTypeAdresse().equals("L") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()) && adr.getPrincipale() == true){
                        adresseLivraisonPrincipale = adr;
                    }
                }
                
                allArticleCommandes = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
                int id = 0;
                for (ArticleCommande artCom : allArticleCommandes) {
//                    artCom.getProduit().getNom()
                    if (artCom.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur())){
                        if (allCommandesUser.contains(artCom)){
                            allCommandesUser.remove(artCom);
                            allCommandesUser.add(artCom);
                        } else
                            allCommandesUser.add(artCom);
                        
                        if (!listId.contains(artCom.getCommande().getIdCommande()) && artCom.getCommande().getIdCommande() != id ){
                            id = artCom.getCommande().getIdCommande();
                            listId.add(id);
                            compteurCommande ++;
//                            if (allCommandesId.contains(artCom)){
//                                allCommandesId.remove(artCom);
                                allCommandesId.add(artCom);
//                            } else 
//                                allCommandesId.add(artCom);
//                                System.out.print(artCom.getCommande().getIdCommande());
                        } 
                    }
                }
            
            request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
            request.setAttribute("connected", UserConnectedManager.getInstance().isUserConnected());
            
            request.setAttribute("adresseFacturation", adresseFacturation);
            request.setAttribute("adresseLivraisonPrincipale", adresseLivraisonPrincipale);
            request.setAttribute("allCommandesUser", allCommandesUser);
            request.setAttribute("allCommandesId", allCommandesId);
            request.setAttribute("listId", listId);
            request.setAttribute("compteurCommande", compteurCommande);
            request.getRequestDispatcher("/pages/historical/historical.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
        
        
    }
}
