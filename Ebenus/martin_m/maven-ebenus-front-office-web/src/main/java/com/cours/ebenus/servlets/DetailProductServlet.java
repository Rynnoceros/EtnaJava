/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.dao.entities.Commande;
import com.cours.ebenus.dao.entities.Produit;
import com.cours.ebenus.dao.entities.Utilisateur;
import java.io.IOException;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soubri_j/martin_m
 */
public class DetailProductServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    private String idArticle = null;
    private String idPage = null;
    private String idUtilisateur = null;
    private int idCommande = 0;
    private int idArtCom = 0;
    List<ArticleCommande> allArticlesCom = new ArrayList<ArticleCommande>();
    List<ArticleCommande> allArticlesComT = new ArrayList<ArticleCommande>();
    List<Adresse> allAdresses = new ArrayList<Adresse>();
    
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
            Produit product = new Produit();
        
            if (request.getAttribute("error") != null) {
                this.getServletContext().getRequestDispatcher("/pages/404/404.jsp").forward(request, response);
            } else {
                idPage = request.getParameter("id");
//                adresseFacturation = request.getParameter("idUtilisateur");
                if (idPage != null) {
                    product = serviceFacade.getProduitDao().findProduitById(Integer.parseInt(idPage));
                }
                if (product == null) {
                    product = new Produit();
                }
                String produitRef = product.getDescription();
//                System.out.print(produitRef);
                request.setAttribute("product", product);
                request.setAttribute("produitRef", produitRef);
                
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream input = classLoader.getResourceAsStream("config.properties");
                Properties properties = new Properties();
                properties.load(input);
                String semaine = properties.getProperty("semaine");
//                System.out.println(semaine);
                request.setAttribute("semaine", semaine);
                
                this.getServletContext().getRequestDispatcher("/pages/articles/detailProduit.jsp").forward(request, response);
            }
            
        } else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit product = new Produit();
        Utilisateur user = new Utilisateur();
        Commande commande = new Commande();
        Adresse adresseFac = new Adresse();
        Adresse adresseLiv = new Adresse();
        ArticleCommande artCom = new ArticleCommande();
        idUtilisateur = request.getParameter("id");
//        idCommande = request.getParameter("idCommande");
        if (idUtilisateur != null) {
            user = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
        } 
//        if (idCommande == null){
//            artCom = serviceFacade.getArticleCommandeDao().findArticleCommandeById(Integer.parseInt(idCommande));
//        }
        int qty = Integer.parseInt(request.getParameter("qty"));
//        int idProduit = Integer.parseInt(request.getParameter("product"));
        product = serviceFacade.getProduitDao().findProduitById(Integer.parseInt(request.getParameter("product")));
//        System.out.println("test "+qty);
        if (qty > product.getStock())
            qty = product.getStock();
        
        double totalArticle = qty * product.getPrix();
        
        allArticlesCom = serviceFacade.getArticleCommandeDao().findAllArticleCommande();
        allAdresses = serviceFacade.getAdresseDao().findAllAdresses();
//        System.out.println("test: "+qty);
        
        boolean present = false;
        for (ArticleCommande adr : allArticlesCom) {
                    
            if (adr.getStatut().equals("T") && user.getIdUtilisateur() == adr.getUtilisateur().getIdUtilisateur() && adr.getProduit().getIdProduit() == product.getIdProduit()){
               if (allArticlesComT.contains(adr)){
                    allArticlesComT.remove(adr);
                    allArticlesComT.add(adr);
                } else 
                    allArticlesComT.add(adr);
               commande = serviceFacade.getCommandeDao().findCommandeById(adr.getCommande().getIdCommande());
               idCommande = adr.getCommande().getIdCommande();
            }
        }
        
        for (Adresse adr : allAdresses) {
            if (adr.getTypeAdresse().equals("L") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()) && adr.getPrincipale().equals(true))
                adresseLiv = adr;
            if (adr.getTypeAdresse().equals("F") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()))
                adresseFac = adr;
        }
        
        
        commande.setTotalCommande(totalArticle);
        commande.setUtilisateur(user);
        commande.setAdresse(adresseFac);
        commande.setStatut("T");
//        commande.setDateCommande(new Date());
        commande.setDateModification(new Date());
       
        artCom.setCommande(commande);
        artCom.setUtilisateur(user);
        artCom.setAdresse(adresseLiv);
        artCom.setProduit(product);
        artCom.setTotalArticleCommande(totalArticle);
        artCom.setReference(product.getReference());
        artCom.setQuantite(qty);
        artCom.setStatut("T");
        artCom.setDateModification(new Date());
        
//        System.out.print("tt: "+commande.getTotalCommande()+" user: "+commande.getUtilisateur().getIdentifiant()+" adr: "+commande.getAdresse().getRue());
//        System.out.print("statut: "+commande.getStatut()+ " date modif: "+commande.getDateModification());
//        
        ArticleCommande isOkArtCom = null;
        Commande isOkCom = null;
        if (idCommande == 0) {
//            System.out.print("ici");
            commande.setDateCommande(new Date());
//            System.out.print( commande);
//            isOkCom = serviceFacade.getCommandeDao().createCommande(commande);
//            idCommande = isOkCom.getIdCommande();
//            artCom.setCommande(isOkCom);
//            System.out.print( isOkCom);
//            System.out.print( artCom);
//            isOkArtCom = serviceFacade.getArticleCommandeDao().createArticleCommande(artCom);
        } else { // Update
             isOkCom = serviceFacade.getCommandeDao().updateCommande(commande);
             isOkArtCom = serviceFacade.getArticleCommandeDao().updateArticleCommande(artCom);
        }
//        
//        if (isOkArtCom != null || isOkCom != null) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/BasketServlet?id="+idCommande);
//        } else {
//            request.setAttribute("error", "Error requesting database");
//            request.setAttribute("utilisateurToUpdate", user);
//            request.getRequestDispatcher("/pages/infos/detailProduct.jsp").forward(request, response);
//        }
    }

}
