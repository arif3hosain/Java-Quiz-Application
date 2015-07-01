
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Examiner;

/**
 *
 * @author arif d
 */
public class Login extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String username=request.getParameter("email");
        String password=request.getParameter("password");
        Examiner exam=new Examiner(null, username, password);
        Examiner result= exam.authenticate(exam);
        
        if(result !=null){
            HttpSession session=request.getSession();
            session.setAttribute("user", result);
             
            RequestDispatcher dispather=request.getRequestDispatcher("choiceModules.jsp");
            dispather.forward(request, response);
        }
        
     
}
}