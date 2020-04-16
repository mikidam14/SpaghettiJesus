<%-- 
    Document   : menuResp
    Created on : Apr 3, 2020, 4:26:13 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <style>
            h1 {text-align: center;}
            #btns { 
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div><h1>Benvenuto ${loggedusername}.</h1></div>
        <div>
            <div>
            <div id="btns">
                <form:form method="post" action="mostraSE">
                    <button type="submit">Mostra segnalazioni</button>
                </form:form>
                <br/>
                <form:form method="post" action="mostraAC">
                    <button type="submit">Mostra azioni correttive</button>
                </form:form>
                <br/>
                <form:form method="post" action="mostraAV">
                    <button type="submit">Mostra azioni di verifica</button>
                </form:form>
                <br/>
                <form:form method="post" action="logout">
                    <button type="submit">Logout</button>
                </form:form>
                <br/>
            </div>
        </div>
    </body>
</html>
