/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Exam;
import model.QuizQuestion;

/**
 *
 * @author arif d
 */
public class ExamController extends HttpServlet {
  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
	 
		
		boolean finish=false;		
		HttpSession session=request.getSession();	
	   try{
		if(session.getAttribute("currentExam")==null){ 
                    session=request.getSession();	
		    String selectedExam=(String)request.getSession().getAttribute("exam");                                                 
 			 Exam newExam=new Exam(selectedExam);	
			 session.setAttribute("currentExam",newExam);
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
		          Date date = new Date();
			  String started=dateFormat.format(date);
			  session.setAttribute("started",started);
		  }
		
		}catch(Exception e){e.printStackTrace();}
	
                    Exam exam=(Exam)(request.getSession().getAttribute("currentExam"));		        
                if(exam.getCurrentQuestion()==0){	
			exam.setQuestion(exam.getCurrentQuestion());
                        QuizQuestion q=exam.getQuestionList().get(exam.getCurrentQuestion());	
			session.setAttribute("quest",q);
                 }
			
			String action=request.getParameter("action");			
			String radio=request.getParameter("answer");
                        
			int selectedRadio=-1;
			exam.getSelections().put(exam.getCurrentQuestion(), selectedRadio);
			if("1".equals(radio))
			{
				selectedRadio=1;
				exam.getSelections().put(exam.getCurrentQuestion(), selectedRadio);
				System.out.println("You selected "+selectedRadio);
			}
			else if("2".equals(radio))
			{
				selectedRadio=2;
				exam.getSelections().put(exam.getCurrentQuestion(), selectedRadio);
				System.out.println("You selected "+selectedRadio);
			}
			else if("3".equals(radio))
			{
				selectedRadio=3;
				exam.getSelections().put(exam.getCurrentQuestion(), selectedRadio);
				System.out.println("You selected "+selectedRadio);
			}
			else if("4".equals(radio))
			{
				selectedRadio=4;
				exam.getSelections().put(exam.getCurrentQuestion(), selectedRadio);
				System.out.println("You selected "+selectedRadio);
			}
			
						
			if("Next".equals(action)){
				exam.currentQuestion++;
				exam.setQuestion(exam.getCurrentQuestion());
			        QuizQuestion q=exam.getQuestionList().get(exam.getCurrentQuestion());	
			  	session.setAttribute("quest",q);
			}
			else if("Previous".equals(action))
			{   System.out.println("You clicked Previous Button");
				exam.currentQuestion--;
				exam.setQuestion(exam.getCurrentQuestion());
			    QuizQuestion q=exam.getQuestionList().get(exam.getCurrentQuestion());	
				session.setAttribute("quest",q);
			}
			else if("Finish Exam".equals(action))
			{  
                             finish=true;
				int result=exam.calculateResult(exam);				
				request.setAttribute("result", result);
				request.getSession().setAttribute("currentExam",null);
				request.getRequestDispatcher("result.jsp").forward(request,response);
				
			}
						
		if(finish!=true){
		request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		
	
    }

     
 
}
