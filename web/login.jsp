<%-- 
    Document   : registration
    Created on : Jun 28, 2015, 10:12:24 PM
    Author     : arif d
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration page</title>
        <%@include file="reference.html"  %>
    </head>
    <body>
        <header>
            
        </header>
        <div id="reg-form-div">
            <form action="login" role="form" method="post" id="login-form">
                <table>
                     
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" placeholder="Email..."/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Password.."/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="btn" value="Login" /></td>
                    </tr>
                </table>
          
                
                
            </form>
        </div>
    </body>
</html>
