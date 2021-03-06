/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.main;

import com.cours.ebenus.factory.AbstractDaoFactory.FactoryDaoType;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Main {

    private static final Log log = LogFactory.getLog(Main.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IServiceFacade serviceFacade = new ServiceFacade(FactoryDaoType.MANUAL_LIST_DAO_FACTORY);
        
        serviceFacade.getUtilisateurDao().findAllUtilisateurs();

    }
}
