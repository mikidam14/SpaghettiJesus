<%-- 
    Document   : azioneverificafk
    Created on : Apr 16, 2020, 7:25:44 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Azione Verifica</title>
    </head>
    <body>
        <div><h2>Compila il form per creare un'azione di verifica.</h2></div>
        <div>
            <table>
                <tr>
                    <td><label for="descrizione">Descrizione: </label> </td>
                    <td><input type="text" id="descrizione"/></td>
                </tr>

                <tr>
                    <td><label for="utente">Utente: </label> </td>
                    <td><input type="text" id="utente"/></td>
                </tr>

                <tr>
                    <td><label for="azcr">Azione Correttiva: </label> </td>
                    <td><input type="text" value="9" id="azcr"/></td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="submit" value="Conferma"/>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <br/>
            <form:form method="post" action="backtout">
                    <button type="submit">Cancella</button>
            </form:form>
        </div>
    </body>
</html>
