<%-- 
    Document   : azionecorrettiva
    Created on : Apr 14, 2020, 12:26:36 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Azione Correttiva</title>
    </head>
    <body>
        <h2>Compila il form per creare un'azione correttiva.</h2>
        
        <form:form method="POST" modelAttribute="azionecorrettiva">
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td><label for="descrizione">Descrizione: </label> </td>
                    <td><form:input path="descrizione" id="descrizione"/></td>
                </tr>
                
                <tr>
                    <td><label for="data">Data: </label> </td>
                    <td><form:input type="date" path="data" id="data"/></td>
                </tr>

                <tr>
                    <td><label for="team">Team: </label> </td>
                    <td><form:input path="team" id="team"/></td>
                </tr>


                <tr>
                    <td><label for="segnalazione">Segnalazione: </label> </td>
                    <td><form:input value="${segnalazione}" path="segnalazione" id="segnalazione"/></td>
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
