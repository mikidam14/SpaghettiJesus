<%-- 
    Document   : eventspage
    Created on : Feb 13, 2020, 12:41:54 PM
    Author     : michele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventi</title>
        <style>
            table{
                border-collapse: collapse;
            }
            table, th, tr, td {
                border: solid black 1px;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <div align="center"><h2>Eventi disponibili</h2></div>
        <c:if test="${!empty events}">
            <table align="center">
                <tr style="background-color: cornflowerblue">
                    <th width="100">Nome</th>
                    <th width="500">Descrizione</th>
                    <th></th>
                </tr>
            <c:forEach items="${events}" var="e">
                <tr style="background-color: lightcyan">
                    <td>${e.name}</td>
                    <td>${e.description}</td>
                    <td>${e.date}</td>
                    <td><a href="<c:url value='/subscribe/${e.id}'/>">Iscriviti</td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
        
        
        
        <!-- QUESTA E ROBA CHE HO TOLTO DAGLI UTENTI -->
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
