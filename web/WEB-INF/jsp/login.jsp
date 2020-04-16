<%-- 
    Document   : login
    Created on : Feb 11, 2020, 5:34:47 PM
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
        <style>
            #center{
                display: flex; 
                justify-content:center;
            }
            
        </style>
    </head>
    <body>
        <div align="center"><h2>Inserisci le credenziali per effettuare il login</h2></div>
        <div id="center">
            <form:form action="checkLogin" method="POST" modelAttribute="utente">
                <table>
                    <tr>
                        <td><label for="username">Username: </label> </td>
                        <td><form:input path="Username" id="username"/></td>
                    </tr>


                    <tr>
                        <td><label for="password">Password: </label> </td>
                        <td><form:input type = "password" path="password" id="password"/></td>
                    </tr>


                    <tr>
                        <td><button type="submit">Login</button></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
