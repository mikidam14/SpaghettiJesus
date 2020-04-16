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
        <style>
            h1 {text-align: center;}
            #btns { 
                text-align: center;
            }
            
            table {
                border-collapse: collapse;
            }
            
            td{
                text-align: center;
                padding: 5px;
            }
            
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div><h1>Benvenuto ${loggedusername}.</h1></div>
        <div>
            <div id="btns">
                <form:form method="get" action="apriSegnalazione">
                    <button type="submit">Apri segnalazione</button>
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
        </div>
    </body>
</html>
