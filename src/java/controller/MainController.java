

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arif d
 */
public class MainController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path=request.getContextPath();
         if(request.getRequestURI().equals(path+"/mainController")){
            request.getSession().setAttribute("currentExam", null);
            String exam=request.getParameter("test");
            request.getSession().setAttribute("exam", exam);
            
             RequestDispatcher dis=request.getRequestDispatcher("start.jsp");
             dis.forward(request, response);            
         }                
        }//finished doGet
 
}
