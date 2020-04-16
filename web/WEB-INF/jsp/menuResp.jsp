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
            <h2>SEGNALAZIONI</h2>
            <c:if test="${!empty segnalazioni}">
                <table>
                    <tr style="background-color: cornflowerblue">
                        <th>Id</th>
                        <th>Data</th>
                        <th>Descrizione</th>
                        <th>Prodotto</th>
                        <th>Utente</th>
                        <th>Settore</th>
                    </tr>
                <c:forEach items="${segnalazioni}" var="se">
                    <tr style="background-color: lightcyan">
                        <td>${se.id}</td>
                        <td>${se.data}</td>
                        <td>${se.descrizione}</td>
                        <td>${se.prodotto}</td>
                        <td>${se.utente.username}</td>
                        <td>${se.settore.nome}</td>
                        <td><a href="<c:url value='/removeSe/${se.id}' />" >Chiudi segnalazione.</a></td>
                        <td><a href="<c:url value='/apriAzioneCorrettiva/${se.id}' />" >Assegna azione correttiva.</a></td>
                    </tr>
                </c:forEach>
                </table>
            </c:if>

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
                    </tr>
                </c:forEach>
                </table>
            </c:if>

            <h2>AZIONI DI VERIFICA</h2>
        </div>
    </body>
</html>
