/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.impl.ServiceFacade;
import com.cours.ebenus.utils.UserConnectedManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author soubri_j/martin_m
 */
public class ProductsServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private IServiceFacade serviceFacade = null;

    @Override
    public void init() throws ServletException {
    	serviceFacade = new ServiceFacade();
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("loggedUser", UserConnectedManager.getInstance().getLoggedUser());
        request.setAttribute("connected", UserConnectedManager.getInstance().isUserConnected());
        this.getServletContext().getRequestDispatcher("/pages/products/products.jsp").forward(request, response);
    }

}
