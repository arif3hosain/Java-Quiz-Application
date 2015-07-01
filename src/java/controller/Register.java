/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Examiner;

/**
 *
 * @author arif d
 */
public class Register extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
        String fullName=request.getParameter("fullName");
        String emaile=request.getParameter("email");
        String password=request.getParameter("password");
        Examiner examiner=new Examiner(fullName, emaile, password);
        boolean authorized=examiner.register(examiner);
        

        
    }

}
