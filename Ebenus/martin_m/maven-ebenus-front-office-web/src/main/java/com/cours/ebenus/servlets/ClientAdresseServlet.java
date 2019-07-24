/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.dao.entities.Adresse;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

/**
 *
 * @author soubri_j/martin_m
 */
public class ClientAdresseServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    private String idUtilisateur = null;
    private String adresseFacturation = null;
    private Adresse adresseLivraisonPrincipale = null;
    private String dateToDisplay = "";
    List<Adresse> allAdresses = new ArrayList<Adresse>();
    List<Adresse> allAdressesLivraison = new ArrayList<Adresse>();
    List<Adresse> allAdressesLivraisonUser = new ArrayList<Adresse>();
    
    /**
     * Méthode d'initialisation de la Servlet
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        serviceFacade = new ServiceFacade() ;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (UserConnectedManager.getInstance().isUserConnected()) {
            Utilisateur toUpdate = null;
            Adresse adressToUpdate = null;
            
            if (request.getAttribute("error") != null) {
                toUpdate = (Utilisateur)request.getAttribute("updatedUser");
            } else {
                idUtilisateur = request.getParameter("id");
//                adresseFacturation = request.getParameter("idUtilisateur");
                if (idUtilisateur != null) {
                    toUpdate = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
                }
                if (toUpdate == null && adressToUpdate == null) {
                    toUpdate = new Utilisateur();
                    adressToUpdate = new Adresse();
                }
                
                allAdresses = serviceFacade.getAdresseDao().findAllAdresses();
//                int idx = 0;
                for (Adresse adr : allAdresses) {
                    
                    if (adr.getTypeAdresse().equals("L"))
                        if (allAdressesLivraison.contains(adr)){
                            allAdressesLivraison.remove(adr);
                            allAdressesLivraison.add(adr);
                        } else 
                            allAdressesLivraison.add(adr);
//                     
                    if (adr.getTypeAdresse().equals("L") && adr.getUtilisateur().getIdUtilisateur().equals(toUpdate.getIdUtilisateur())){
                        
                        if (allAdressesLivraisonUser.contains(adr)){
                            allAdressesLivraisonUser.remove(adr);
                            allAdressesLivraisonUser.add(adr);
                        } else 
                            allAdressesLivraisonUser.add(adr);
                    }
                }
                
//                System.out.print(allAdressesLivraisonUser.get(1).getRue());
                
            }
            request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
            request.setAttribute("utilisateurToUpdate", toUpdate);
            
            request.setAttribute("allAdresses", allAdresses);
            request.setAttribute("allAdressesLivraison", allAdressesLivraison);
            request.setAttribute("allAdressesLivraisonUser", allAdressesLivraisonUser);
            request.getRequestDispatcher("/pages/infos/clientAdresse.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utilisateur user = new Utilisateur();
        Adresse adresseFac = new Adresse();
        Adresse adresseLivPrinc = new Adresse();
        Adresse adresseLiv = new Adresse();
        idUtilisateur = request.getParameter("id");
        int num = 0;
        if (idUtilisateur != null) {
            user = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
        } 
            allAdresses = serviceFacade.getAdresseDao().findAllAdresses();
                
                for (Adresse adr : allAdresses) {
                    if (adr.getTypeAdresse().equals("F") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()))
                        adresseFac = adr;
                    
                    if (adr.getTypeAdresse().equals("L") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()) && adr.getPrincipale().equals(true))
                        adresseLivPrinc = adr;
                }
                int cpt = 1;
                for (Adresse adr : allAdressesLivraisonUser) {
                    if (cpt == Integer.parseInt(request.getParameter("ALid"))){
                        adresseLiv = adr;
                        num = cpt;
                    }
                     cpt++;
                }
       
        
        adresseFac.setRue(request.getParameter("street"));
        adresseFac.setCodePostal(request.getParameter("postalcode"));
        adresseFac.setVille(request.getParameter("city"));
        adresseFac.setPays(request.getParameter("country"));
        
        adresseLiv.setRue(request.getParameter("streetShip"+num));
        adresseLiv.setCodePostal(request.getParameter("postalcodeShip"+num));
        adresseLiv.setVille(request.getParameter("cityShip"+num));
        adresseLiv.setPays(request.getParameter("countryShip"+num));
       
        if (adresseLivPrinc.getRue() == null || request.getParameter("principal_adress"+num) == null){
            if(request.getParameter("principal_adress"+num) == null)
                adresseLiv.setPrincipale(false);
            else
                adresseLiv.setPrincipale(true);
        } 
        
        Adresse isOkAdrFac = null;
        Adresse isOkAdrLiv = null;
        Boolean isOk = false;
        if(request.getParameter("Button").equals("Modifier")) {
            isOkAdrFac = serviceFacade.getAdresseDao().updateAdresse(adresseFac);
            isOkAdrLiv = serviceFacade.getAdresseDao().updateAdresse(adresseLiv);
        } else if(request.getParameter("Button").equals("Retirer")){
            allAdressesLivraisonUser = new ArrayList<Adresse>();
            isOk = true;
//                    toDelete.set(adresseLiv.getUtilisateur().getIdUtilisateur());
//                    boolean deleted = serviceFacade.getUtilisateurDao().deleteUtilisateur(toDelete);
                    boolean deleted = serviceFacade.getAdresseDao().deleteAdresse(adresseLiv);
                    if (deleted) {
                        allAdresses.remove(adresseLiv);
                        response.setStatus(HttpServletResponse.SC_OK);
                    
                    } else {
                       response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    }
//            
                    for (Adresse adr : allAdresses) {
                    
                    if (adr.getTypeAdresse().equals("L"))
                        
//                     
                    if (adr.getTypeAdresse().equals("L") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur())){
                        
                        if (allAdressesLivraisonUser == null)
                            allAdressesLivraisonUser.add(adr);
                        else if (allAdressesLivraisonUser.contains(adr)){
                            allAdressesLivraisonUser.remove(adr);
                            allAdressesLivraisonUser.add(adr);
                        } else 
                            allAdressesLivraisonUser.add(adr);
                    }
                }
        }
        
        if ((isOkAdrLiv != null) || (isOkAdrFac != null) || isOk == true){
            request.setAttribute("allAdressesLivraisonUser", allAdressesLivraisonUser);
            response.sendRedirect(this.getServletContext().getContextPath() + "/ClientAdresseServlet?id="+idUtilisateur);
        } else {
            request.setAttribute("error", "Error requesting database");
            request.setAttribute("utilisateurToUpdate", user);
            request.setAttribute("dateToDisplay", dateToDisplay);
            request.getRequestDispatcher("/pages/infos/clientAdresse.jsp").forward(request, response);
        }
    }
    
}
