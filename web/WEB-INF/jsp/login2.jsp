<%-- 
    Document   : login2
    Created on : Apr 3, 2020, 12:10:16 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div align="center"><h2>Inserisci le credenziali per effettuare il login</h2></div>
        
        
        <!--<p><label>Username: <input type="text" name="username"/></label></p>
        <p><label>Password: <input type="password" name="password"/></label></p>-->
        
        <form:form action="checkLogin" method="POST" modelAttribute="follower">
        <form:input type = "hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="username">Username: </label> </td>
                <td><form:input path="username" id="username"/></td>
            </tr>
         
     
            <tr>
                <td><label for="password">Password: </label> </td>
                <td><form:input type = "password" path="password" id="password"/></td>
            </tr>
     
     
            <tr>
                <td><button typer="submit">Login</button></td>
            </tr>
        </table>
    </form:form>
    </body>
</html>
