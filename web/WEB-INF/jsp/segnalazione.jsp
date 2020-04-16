<%-- 
    Document   : segnalazione
    Created on : Apr 7, 2020, 5:17:53 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segnalazione</title>
    </head>
    <body>
        <h2>Compila il form per aprire una segnalazione.</h2>
        
        <form:form method="POST" modelAttribute="segnalazione">
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td><label for="data">Data: </label> </td>
                    <td><form:input type="date" path="data" id="data"/></td>
                </tr>


                <tr>
                    <td><label for="descrizione">Descrizione: </label> </td>
                    <td><form:input path="descrizione" id="descrizione"/></td>
                </tr>

                <tr>
                    <td><label for="prodotto">Prodotto: </label> </td>
                    <td><form:input path="prodotto" id="prdotto"/></td>
                </tr>


                <tr>
                    <td><label for="utente">Utente: </label> </td>
                    <td><form:input type="text" value="${username}" path="utente" id="utente"/></td>
                </tr>

                
                <tr>
                    <td><label for="settore">Settore: </label> </td>
                    <td><form:input type="text" value="${settore}" path="settore" id="settore"/></td>
                </tr>
                
                
                <tr>
                    <td colspan="2">
                                <input type="submit" value="Conferma"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
