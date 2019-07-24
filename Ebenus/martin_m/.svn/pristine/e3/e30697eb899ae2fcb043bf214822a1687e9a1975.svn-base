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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soubri_j/martin_m
 */
public class PersonnalInformationServlet extends HttpServlet {

    private IServiceFacade serviceFacade = null;
    private String idUtilisateur = null;
    private String rueFac = null;
    private String adresseFacturation = null;
    private Adresse adresseLivraisonPrincipale = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String dateToDisplay = "";
    List<Adresse> allAdresses = new ArrayList<Adresse>();
    List<Adresse> allAdressesLivraison = new ArrayList<Adresse>();
    
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
                    dateToDisplay = dateFormat.format(toUpdate.getDateNaissance());
//                    adressToUpdate = serviceFacade.getAdresseDao().findAdresseById(Integer.parseInt(idAdresse));
                }
                if (toUpdate == null && adressToUpdate == null) {
                    toUpdate = new Utilisateur();
                    adressToUpdate = new Adresse();
                    dateToDisplay = dateFormat.format(new Date());
                }
                
                allAdresses = serviceFacade.getAdresseDao().findAllAdresses();
                
                for (Adresse adr : allAdresses) {
                    
                    if (adr.getTypeAdresse().equals("L"))
                        if (allAdressesLivraison.contains(adr)){
                            allAdressesLivraison.remove(adr);
                            allAdressesLivraison.add(adr);
                        } else
                            allAdressesLivraison.add(adr);
                }
                
            }
            request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
            request.setAttribute("utilisateurToUpdate", toUpdate);
            request.setAttribute("dateToDisplay", dateToDisplay);
            
            request.setAttribute("allAdresses", allAdresses);
            request.setAttribute("allAdressesLivraison", allAdressesLivraison);
            request.getRequestDispatcher("/pages/infos/personnalInformation.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utilisateur user = new Utilisateur();
        Adresse adresseFac = new Adresse();
        Adresse adresseLiv = new Adresse();
        if (idUtilisateur != null) {
            user = serviceFacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(idUtilisateur));
            allAdresses = serviceFacade.getAdresseDao().findAllAdresses();
                
                for (Adresse adr : allAdresses) {
                    if (adr.getTypeAdresse().equals("F") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()))
                        adresseFac = adr;
                    
                    if (adr.getTypeAdresse().equals("L") && adr.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur()) && adr.getPrincipale().equals(true))
                        adresseLiv = adr;
                }
        }
        user.setPrenom(request.getParameter("firstname"));
        user.setNom(request.getParameter("lastname"));
        user.setIdentifiant(request.getParameter("email"));
        user.setMotPasse(request.getParameter("password"));
        user.setCivilite(request.getParameter("sex"));
        try {
            user.setDateNaissance(dateFormat.parse(request.getParameter("dteNaiss")));  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        user.setDateModification(new Date());
        user.setVersion(user.getVersion() + 1);
        
        adresseFac.setRue(request.getParameter("street"));
        adresseFac.setCodePostal(request.getParameter("postalcode"));
        adresseFac.setVille(request.getParameter("city"));
        adresseFac.setPays(request.getParameter("country"));
        
        adresseLiv.setRue(request.getParameter("streetL"));
        adresseLiv.setCodePostal(request.getParameter("postalcodeL"));
        adresseLiv.setVille(request.getParameter("cityL"));
        adresseLiv.setPays(request.getParameter("countryL"));
        
        Utilisateur isOk = null;
        Adresse isOkAdrFac = null;
        Adresse isOkAdrLiv = null;
//        if (idUtilisateur == null) {
//            user.setDateCreation(new Date());
//            isOk = serviceFacade.getUtilisateurDao().createUtilisateur(user);
//        } else { // Update
            isOk = serviceFacade.getUtilisateurDao().updateUtilisateur(user);
            isOkAdrFac = serviceFacade.getAdresseDao().updateAdresse(adresseFac);
            isOkAdrLiv = serviceFacade.getAdresseDao().updateAdresse(adresseLiv);
//        }
        
        if ((isOk != null) || (isOkAdrFac !=null) || (isOkAdrLiv != null)){
            response.sendRedirect(this.getServletContext().getContextPath() + "/PersonnalInformationServlet?id="+idUtilisateur);
        } else {
            request.setAttribute("error", "Error requesting database");
            request.setAttribute("utilisateurToUpdate", user);
            request.setAttribute("dateToDisplay", dateToDisplay);
            request.getRequestDispatcher("/pages/infos/personnalInformation.jsp").forward(request, response);
        }
    }
}
