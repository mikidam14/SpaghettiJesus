<%-- 
    Document   : menuUtente
    Created on : Apr 3, 2020, 12:07:16 PM
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
    </head>
    <body>
        <h1>Benvenuto.</h1>
        
        <form:form method="get" action="apriSegnalazione">
            <button type="submit">Apri Segnalazione</button>
        </form:form>
        
        <h2>AZIONI CORRETTIVE</h2>
        <c:if test="${!empty azionicorrettive}">
            <table>
                <tr style="background-color: cornflowerblue">
                    <th>Id</th>
                    <th>Descrizione</th>
                    <th>Data</th>
                    <th>Team</th>
                    <th>Segnalazione</th>
                </tr>
            <c:forEach items="${azionicorrettive}" var="ac">
                <tr style="background-color: lightcyan">
                    <td>${ac.id}</td>
                    <td>${ac.descrizione}</td>
                    <td>${ac.data}</td>
                    <td>${ac.team.nome}</td>
                    <td>${ac.segnalazione.id}</td>
                    <td><a href="<c:url value='/apriAzioneVerifica/${ac.id}' />" >Assegna azione di verifica.</a></td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
        
        <h2>AZIONI DI VERIFICA</h2>
        <c:if test="${!empty azioniverifica}">
            <table>
                <tr style="background-color: cornflowerblue">
                    <th>Id</th>
                    <th>Descrizione</th>
                    <th>Utente</th>
                    <th>AzCr</th>
                </tr>
            <c:forEach items="${azioniverifica}" var="av">
                <tr style="background-color: lightcyan">
                    <td>${av.id}</td>
                    <td>${av.descrizione}</td>
                    <td>${av.utente.username}</td>
                    <td>${av.azionecorrettiva.id}</td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
    </body>
</html>
