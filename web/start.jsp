<%@page import="model.Examiner"%>
<%
    Examiner ex=(Examiner)session.getAttribute("user");
    if(ex !=null){
    out.print("Welcome: "+ex.getFullName()+"<br>");
    
    out.print("get session: "+request.getSession());
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="examController">Start </a>${sessionScope.exam}<br>Path: ${pageContext.request.contextPath}</p>
    </body>
</html>
<% }else{
        response.sendRedirect("login.jsp");
    }%>