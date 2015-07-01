  
<%@page import="model.QuizQuestion"%>
<%@page import="model.Exam"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="model.Examiner"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    Examiner examiner=(Examiner)session.getAttribute("user");  
    if(examiner !=null){
        
        int currentQuestion=((Exam)request.getSession().getAttribute("currentExam")).getCurrentQuestion();
           
         
     
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
         <title>JSP Page</title>
         <%@include file="reference.html" %>
    </head>
    <body>
        <header>
            <p>Welcome: <% out.print(examiner.getFullName()); %> <a href="logout" class="btn btn-info" style="float: right;">Logout</a></p>
        </header>
        <div id="border-div">
            <div id="quiz-title">MongoDB Quiz</div>
            
            <div class="question">Current Question ${sessionScope.quest.questionNumber+1} of 10</div>
                <div class="time"></div>
                <div class="clear"></div>
                               
            <form action="examController" role="form" method="get" name="quiz-form" id="quiz-form">
                <h4>${sessionScope.quest.question}</h4><br>
                <c:forEach var="option" items="${sessionScope.quest.options}" varStatus="counter">
                    <input type="radio" onclick="enable()" name="answer" value="${counter.count}"/> ${option}<br>
                </c:forEach><br>
                <%
                if(currentQuestion >0){%>
                <br><input type="submit" name="action" class="btn btn-success" value="Previous">
                <%}%>
                <%
                if(currentQuestion >=0){
                    if(currentQuestion <9){%>
                       <input type="submit" name="action" disabled class="btn btn-primary" id="btn-next" value="Next">
                    <%} %>
                   
                <input type="submit" name="action" class="btn btn-info" value="Finish Exam">

                <%}%>

            </form>
        </div>

        <script>
            var date=new Date();
            $(document).ready(function(){
                $(".time").text(date.toLocaleTimeString());
            });
          
    $(document).ready(function(){
        $('input:radio').change(function(){
            document.getElementById('btn-next').disabled=false;
        });
    });
             
             
        </script>
        
        
        
    </body>
</html>
<% }else
        response.sendRedirect("home.jsp");

%>