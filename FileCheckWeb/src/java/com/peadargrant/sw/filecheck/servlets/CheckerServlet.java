/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */

package com.peadargrant.sw.filecheck.servlets;

import com.peadargrant.sw.filecheck.assignments.Assignment;
import com.peadargrant.sw.filecheck.assignments.Assignments;
import com.peadargrant.sw.filecheck.checker.Checker;
import com.peadargrant.sw.filecheck.gui.ReportTableModel;
import com.peadargrant.sw.filecheck.gui.SummaryTableModel;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/**
 *
 * @author Peadar Grant
 */
public class CheckerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Sort out the file
        DiskFileItemFactory factory = new DiskFileItemFactory();
        int maxMemSize = 5000 * 1024;
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("/tmp"));


        // Setup the checker
        SummaryTableModel stm = new SummaryTableModel();
        ReportTableModel rtm = new ReportTableModel(stm); 
        Checker checker = new Checker();
        checker.setReport(rtm);
        
        // Get the selected assignment
        Assignments assignments = (Assignments) request.getSession().getAttribute("assignments"); 
        Integer assignmentIndex = new Integer(request.getParameter("assignment")); 
        Assignment a = assignments.getAssignment().get(assignmentIndex); 
        
        // RUN CHECKER HERE
        
        // Store output from checker in session
        request.getSession().setAttribute("rtm", rtm);
        
        // Redirect to results display
        response.sendRedirect("results.jsp");
        
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
