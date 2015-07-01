<%  
   if(request.getSession().getAttribute("user") !=null){
        
     
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="reference.html" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
     
        <table id="result-table" border="1">
            <caption><strong>Result of Quiz</strong></caption>
            <tr>
                <td>Time Started</td>
                <td>${sessionScope.started}</td>
            </tr>
        
            <tr>                     
                <td>No. of Questions </td>
                <td>10</td>
            </tr>  
            <tr>
                <td>Correct Answered</td>
                <td>${requestScope.result}</td>                       
            </tr>
        </table>
    </body>
</html>
<%}else{
      response.sendRedirect("login.jsp");
   }%>