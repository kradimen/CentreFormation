/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Projet;

/**
 *
 * @author DELL05
 */
@WebServlet(name = "CreerProjetServlet", urlPatterns = {"/creerProjet"})
public class CreerProjetServlet extends HttpServlet {

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
        request.getRequestDispatcher("WEB-INF/formProjet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try {
        String titre = request.getParameter("titre");
        String sujet = request.getParameter("sujet");       
        Date dateLimite = java.sql.Date.valueOf(request.getParameter("dateLimite"));
        Date creerDate = new java.sql.Date((new java.util.Date()).getTime());
             
        
        
        Projet projet = new Projet(-1, 10, 1, creerDate ,sujet, titre, dateLimite);
        
        
            projet.insert();
        } catch (SQLException ex) {
            Logger.getLogger(CreerProjetServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            request.getRequestDispatcher("WEB-INF/formProjet.jsp").forward(request, response);
        }
        
       
    }

}
