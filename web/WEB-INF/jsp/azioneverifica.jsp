<%-- 
    Document   : azioneverifica
    Created on : Apr 16, 2020, 8:03:10 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Azione Di Verifica</title>
    </head>
    <body>
        <div><h2>Compila il form per creare un'azione di verifica.</h2></div>
        <div>
            <form:form method="POST" modelAttribute="azioneverifica">
                <form:input type="hidden" path="id" id="id"/>
                <table>
                    <tr>
                        <td><label for="descrizione">Descrizione: </label> </td>
                        <td><form:input path="descrizione" id="descrizione"/></td>
                    </tr>

                    <tr>
                        <td><label for="utente">Utente: </label> </td>
                        <td><form:input path="utente" id="utente"/></td>
                    </tr>

                    <tr>
                        <td><label for="azcr">Azione Correttiva: </label> </td>
                        <td><form:input value="${azionecorrettiva}" path="azCr" id="azcr"/></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                                    <input type="submit" value="Conferma"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div>
            <br/>
            <form:form method="post" action="backtout">
                    <button type="submit">Cancella</button>
            </form:form>
        </div>
    </body>
</html>
